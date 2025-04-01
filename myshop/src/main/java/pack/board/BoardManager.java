package pack.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardManager {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	private int recTot; // 전체 레코드 수
	private int pageList = 5; // 페이지 단 출력 레코드 수
	private int pageTot; // 전체 페이지 수
	private BoardDto bean;

	public BoardManager() {	// DB 연결 준비하기
		try {
			Context context = new InitialContext(); // 톰캣에서 DB 환경 정보 가져오기
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria"); // DB 연결 설정
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패 : " + e); // 실패 시 메시지 출력
		}
	}

	public void totalList() {  //역할: 글이 몇 개 있는지 전체 개수 세기
		String sql = "select count(*) from board"; // 글 개수 세는 SQL
		try (Connection conn = ds.getConnection(); // DB 연결
			 PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 준비
			 ResultSet rs = pstmt.executeQuery(); // SQL 실행 → 결과 받기
		) {
			rs.next(); // 결과 한 줄 가져오기
			recTot = rs.getInt(1); // 전체 글 수 저장
			System.out.println("전체 레코드 수 : " + recTot);
		} catch (Exception e) {
			System.out.println("totalList err " + e);
		}
	}

	public int getPageSu() { // 역할: 페이지가 몇 개 필요한지 계산
	    pageTot = recTot / pageList;  // 한 페이지당 글 수로 나누기
	    if (recTot % pageList > 0)  // 나머지가 있으면 페이지 1개 더 필요
	        pageTot++;
	    System.out.println("전체 페이지 수 : " + recTot);
	    return pageTot;  // 총 페이지 수 반환
	}


	// 글 목록을 가져오는 함수
	// page: 몇 페이지인지
	// searchType: 제목 or 작성자 검색인지
	// searchWord: 검색어
	public ArrayList<BoardDto> getDataAll(int page, String searchType, String searchWord) {
		ArrayList<BoardDto> list = new ArrayList<>(); // 글 목록을 담을 리스트
		String sql = "select * from board"; // 기본 SQL문
		try {
			conn = ds.getConnection(); // DB 연결

			if (searchWord == null) { // 검색 안 한 경우
				sql += " order by gnum desc, onum asc"; // 최신글 순서로 정렬
				pstmt = conn.prepareStatement(sql); // SQL 실행 준비
			} else { // 검색한 경우
				sql += " where " + searchType + " like ?"; // 검색 조건 추가
				sql += " order by gnum desc, onum asc"; // 정렬
				pstmt = conn.prepareStatement(sql); // SQL 실행 준비
				pstmt.setString(1, "%" + searchWord + "%"); // 검색어 채우기
			}

			rs = pstmt.executeQuery(); // SQL 실행 → 결과 받기
			for (int i = 0; i < (page - 1) * pageList; i++) {// 페이지 이동 처리 (보여줄 글 위치로 이동)
				rs.next(); // 몇 번째 글부터 보여줄지 이동만 함
			}

			int k = 0; // 몇 개 글 보여줬는지 카운트
			while (rs.next() && k < pageList) { // 글 남아 있고 5개 미만이면
				BoardDto dto = new BoardDto(); // 글 담을 상자 생성

				// DB 결과에서 정보 꺼내서 dto에 담기
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setBdate(rs.getString("bdate"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setNested(rs.getInt("nested"));

				list.add(dto); // 리스트에 글 추가
				k++;
			}
		} catch (Exception e) {
			System.out.println("getDataAll err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}

		return list; // 글 목록 리스트 반환
	}

	public int currentMaxNum() {
		// 글 번호 중에서 가장 큰 번호를 가져오는 SQL
		String sql = "select max(num) from board";
		int num = 0; // 최댓값을 저장할 변수

		try (Connection conn = ds.getConnection(); // DB 연결
				PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 실행 준비
				ResultSet rs = pstmt.executeQuery() // SQL 실행해서 결과 받기
		) {
			if (rs.next()) // 결과가 있다면
				num = rs.getInt(1); // 최댓값 가져와서 저장
		} catch (Exception e) {
			System.out.println("currentMaxNum err : " + e.getMessage());
		}

		return num; // 최댓값 반환
	}

	public void saveData(BoardBean bean) { // 글을 DB(데이터 저장소)에 저장하는 함수
		// board 테이블에 글을 저장하는 SQL문 (물음표는 나중에 값으로 채움)
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ds.getConnection(); // DB 연결을 열고
				PreparedStatement pstmt = conn.prepareStatement(sql); // SQL문을 실행할 준비
		) {
			pstmt.setInt(1, bean.getNum()); // 글 번호 저장
			pstmt.setString(2, bean.getName()); // 작성자 이름 저장
			pstmt.setString(3, bean.getPass()); // 비밀번호 저장
			pstmt.setString(4, bean.getMail()); // 이메일 저장
			pstmt.setString(5, bean.getTitle());// 글 제목 저장
			pstmt.setString(6, bean.getCont()); // 글 내용 저장
			pstmt.setString(7, bean.getBip()); // 작성자의 IP 주소 저장 (어디서 썼는지)
			pstmt.setString(8, bean.getBdate());// 작성 날짜 저장 (오늘 날짜)
			pstmt.setInt(9, 0); // 조회수 저장 (처음엔 0)
			pstmt.setInt(10, bean.getGnum()); // 글 그룹 번호 저장 (원글이면 자기 번호)
			pstmt.setInt(11, 0); // 댓글 위치 정보 저장 (원글은 0)
			pstmt.setInt(12, 0);// 댓글 들여쓰기 정보 저장 (원글은 0)
			pstmt.executeUpdate(); // 위에서 준비한 값들을 DB에 저장!
		} catch (Exception e) {
			System.out.println("saveData err : " + e.getMessage());
		}
	}

	// 글 번호(num)를 받아서, 조회수를 1 증가시키는 함수
	public void updateReadcnt(String num) {
		String sql = "update board set readcnt = readcnt + 1 where num=?"; // 조회수 올리는 SQL

		try (Connection conn = ds.getConnection(); // DB 연결
				PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 준비
		) {
			pstmt.setString(1, num); // 글 번호 채우기
			pstmt.executeUpdate(); // SQL 실행해서 조회수 +1
		} catch (Exception e) {
			System.out.println("updateReadcnt err : " + e.getMessage());
		}
	}

	public BoardDto getData(String num) {
		// 글 번호(num)에 해당하는 글 하나만 가져오는 SQL
		String sql = "select * from board where num=?";
		BoardDto dto = null; // 글 정보를 담을 상자

		try (Connection conn = ds.getConnection(); // DB 연결
				PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 실행 준비
		) {
			pstmt.setString(1, num); // SQL 물음표에 글 번호 채우기

			try (ResultSet rs = pstmt.executeQuery();) { // SQL 실행 → 결과 받기
				if (rs.next()) { // 결과가 있다면 (글 있음)
					dto = new BoardDto(); // 글 정보를 담을 상자 생성

					// DB에서 읽은 값 하나하나를 dto에 담기
					dto.setNum(rs.getInt("num")); // 글 번호
					dto.setName(rs.getString("name")); // 작성자 이름
					dto.setPass(rs.getString("pass")); // 비밀번호
					dto.setMail(rs.getString("mail")); // 이메일
					dto.setTitle(rs.getString("title")); // 제목
					dto.setCont(rs.getString("cont")); // 내용
					dto.setBip(rs.getString("bip")); // IP 주소
					dto.setBdate(rs.getString("bdate")); // 작성일
					dto.setReadcnt(rs.getInt("readcnt")); // 조회수
				}
			}
		} catch (Exception e) {
			System.out.println("getData err : " + e.getMessage());
		}

		return dto; // dto 반환 (JSP에서 화면에 보여주기 위해)
	}

	public BoardDto getReplyData(String num) {
		// 글 번호(num)에 해당하는 글 정보를 가져오는 SQL
		String sql = "select * from board where num=?";
		BoardDto dto = null; // 글 정보를 담을 상자

		try (Connection conn = ds.getConnection(); // DB 연결
				PreparedStatement pstmt = conn.prepareStatement(sql); // SQL 준비
		) {
			pstmt.setString(1, num); // SQL 물음표에 글 번호 채움

			try (ResultSet rs = pstmt.executeQuery();) { // SQL 실행해서 결과 받기
				if (rs.next()) { // 글이 있다면
					dto = new BoardDto(); // 글 상자 만들기

					// 댓글을 달기 위해 필요한 정보만 꺼내서 담기
					dto.setTitle(rs.getString("title")); // 제목
					dto.setGnum(rs.getInt("gnum")); // 그룹 번호
					dto.setOnum(rs.getInt("onum")); // 순서 번호
					dto.setNested(rs.getInt("nested")); // 들여쓰기 단계
				}
			}
		} catch (Exception e) {
			System.out.println("getData err : " + e.getMessage());
		}

		return dto; // 결과 반환
	}

	// 같은 그룹(gnum)의 댓글 중에서,
	// 댓글이 들어갈 자리(onum)보다 크거나 같은 댓글들의 onum을 +1 해줌
	public void updateOnum(int gnum, int onum) {
		String sql = "update board set onum = onum + 1 where onum >= ? and gnum = ?";

		try {
			conn = ds.getConnection(); // DB 연결 열기
			pstmt = conn.prepareStatement(sql); // SQL 준비
			pstmt.setInt(1, onum); // 댓글 자리 채우기
			pstmt.setInt(2, gnum); // 같은 그룹 채우기
			pstmt.execute(); // 실행 → 댓글 자리 정리
		} catch (Exception e) {
			System.out.println("updateOnum err : " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	// 댓글을 DB에 저장하는 함수
	public void saveReplyData(BoardBean bean) {
		String sql = "insert into board values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, bean.getNum()); // 댓글 번호 (글 번호)
			pstmt.setString(2, bean.getName()); // 작성자 이름
			pstmt.setString(3, bean.getPass()); // 비밀번호
			pstmt.setString(4, bean.getMail()); // 이메일
			pstmt.setString(5, bean.getTitle()); // 제목
			pstmt.setString(6, bean.getCont()); // 내용
			pstmt.setString(7, bean.getBip()); // IP 주소
			pstmt.setString(8, bean.getBdate()); // 날짜
			pstmt.setInt(9, 0); // 조회수 (댓글은 0)
			pstmt.setInt(10, bean.getGnum()); // 원글의 그룹 번호
			pstmt.setInt(11, bean.getOnum()); // 댓글 자리(onum)
			pstmt.setInt(12, bean.getNested()); // 들여쓰기 정보

			pstmt.executeUpdate(); // 댓글 저장 실행
		} catch (Exception e) {
			System.out.println("saveReplyData err : " + e.getMessage());
		}
	}

	public boolean checkPassword(int num, String newPass) {
		boolean b = false; // 결과를 저장할 변수 (처음엔 false)

		// 글 번호(num)에 해당하는 비밀번호를 가져오는 SQL
		String sql = "select pass from board where num=?";

		try {
			conn = ds.getConnection(); // DB 연결
			pstmt = conn.prepareStatement(sql); // SQL 준비
			pstmt.setInt(1, num); // 물음표에 글 번호 채우기

			rs = pstmt.executeQuery(); // SQL 실행해서 결과 받기

			if (rs.next()) { // 결과가 있다면 (글이 있다면)
				// 입력한 비밀번호(newPass)와 DB의 비밀번호 비교
				if (newPass.equals(rs.getString("pass"))) {
					b = true; // 같으면 성공!
				}
			}
		} catch (Exception e) {
			System.out.println("checkPassword err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close(); // 결과 닫기
				if (pstmt != null)
					pstmt.close(); // SQL 닫기
				if (conn != null)
					conn.close(); // 연결 닫기
			} catch (Exception e2) {
			}
		}

		return b; // 결과 반환 (true or false)
	}

	// 글을 수정하는 함수
	public void saveEdit(BoardBean bean) {
		String sql = "update board set name=?, mail=?, title=?, cont=? where num=?";

		try {
			conn = ds.getConnection(); // DB 연결 열기
			pstmt = conn.prepareStatement(sql); // SQL 실행 준비

			// 새로 입력한 내용으로 DB 값 변경
			pstmt.setString(1, bean.getName()); // 새 이름
			pstmt.setString(2, bean.getMail()); // 새 이메일
			pstmt.setString(3, bean.getTitle()); // 새 제목
			pstmt.setString(4, bean.getCont()); // 새 내용
			pstmt.setInt(5, bean.getNum()); // 어떤 글인지 번호로 찾음

			pstmt.executeUpdate(); // 글 수정 실행
		} catch (Exception e) {
			System.out.println("saveEdit err : " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

	// 글을 삭제하는 함수
	public void delData(String num) {
		String sql = "delete from board where num=?";

		try {
			conn = ds.getConnection(); // DB 연결
			pstmt = conn.prepareStatement(sql); // SQL 준비
			pstmt.setString(1, num); // 삭제할 글 번호
			pstmt.executeUpdate(); // 글 삭제 실행
		} catch (Exception e) {
			// 에러는 무시
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}

}
