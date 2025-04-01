package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DbConnPaging { // DB 처리용 Business Logic
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//페이징
	int recordTotal = 0;	// 행(record) 총 갯수
	int pageSize = 5;		// 페이지 당 출력 행수
	int totalPage = 0;		// 전체 페이지 수

	public DbConnPaging() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("DBConnClass err" + e);
		}

	}
/*
	public ArrayList<SangpumDto> getDataAll(String pa) {	// 해당 페이지의 자료만 반환
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			String sql = " select * from sangdata order by code desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			int startNum = (Integer.parseInt(pa) - 1) * pageSize + 1;
			for(int p=1; p < startNum; p++) {
				rs.next();	// 레코드 포인터 위치 지정		페이지 0,5,10
			}
			
			int i = 1;
			while (rs.next() && i <= pageSize) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
				i++;
			}
		} catch (Exception e) {
			System.out.println("getDataAll err" + e);
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
		return list;
	} */
	
	public ArrayList<SangpumDto> getDataAll(String pa) {	// 위코드를 람다식 사용
	ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
	String url = "jdbc:mariadb://127.0.0.1:3306/test";
	String sql = "select * from sangdata order by code desc";
	// try - with - resources 구문 사용
	try(
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery()) {
		int startNum = (Integer.parseInt(pa) - 1) * pageSize + 1;
		rs.absolute(startNum - 1);	// 레코드 포인터를 시작 위치로 이동
		
		list = Stream.iterate(1, i -> i +1) // 1부터 시작하는 스트림 생성
				.limit(pageSize)	// 스트림의 크기를 pageSize 만큼 제한
				.map(i -> {
					try {
						if(rs.next()) {	// rs.next()로 레코드를 이동하여 SangpumDto에 값 기억
							SangpumDto dto = new SangpumDto();
							dto.setCode(rs.getString("code"));
							dto.setSang(rs.getString("sang"));
							dto.setSu(rs.getString("su"));
							dto.setDan(rs.getString("dan"));
							return dto;
						}
					} catch (Exception e) {
						System.out.println("getDataAll map err : " + e);
					}
					return null;
				})
				.filter(Objects::nonNull) // null이 아닌 객체만 필터링
				.collect(Collectors.toCollection(ArrayList::new));
		// collect() 스트림 결과를 ArrayList 로 수집
	} catch (Exception e) {
		System.out.println("getDataAll err" + e);
	}
	return list;
 }
 
 
	public int prepareTotalPage() {
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			  String sql = "SELECT COUNT(*) FROM sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) recordTotal = rs.getInt(1);
			
			// 전체 페이지수 계산
			totalPage = recordTotal / pageSize;	// 몫만
			if(recordTotal % pageSize != 0) totalPage += 1;
			System.out.println("전체 페이지 수 : " + totalPage);
		} catch (Exception e) {
			System.out.println("getDataAll err" + e);
		} 
		return totalPage;
		}
	
	// 이밑에는 자료 추가를 저장하는 곳
	public void sangpumInsert(SangpumFormBean formBean) {
		// System.out.println(formBean.getSang() + "," + formBean.getSu() + formBean.getDan()); 
		try {
			
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/test", "root", "123");
			
			pstmt = conn.prepareStatement("select max(code) from sangdata");
			rs = pstmt.executeQuery();
			rs.next();
			
			int maxCode = rs.getInt(1);
			// System.out.println("가장 큰 code : " + maxCode);
			
			String sql = "insert into sangdata values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxCode + 1);
			pstmt.setString(2, formBean.getSang());
			pstmt.setString(3, formBean.getSu());
			pstmt.setString(4, formBean.getDan());
			pstmt.executeUpdate();
		}catch (Exception e) {
				System.out.println("getDataAll err" + e);
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
		return;
		}
		
	}

