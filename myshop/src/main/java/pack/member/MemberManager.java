package pack.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberManager {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public MemberManager() { // DB 연결 준비하기
		try {
			Context context = new InitialContext(); // 톰캣에서 설정된 DB 정보 찾기
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria"); // DB 연결 준비 완료
		} catch (Exception e) {
			System.out.println("MemberManager 로딩 실패 : " + e);
		}
	}

	// 동 이름으로 우편번호 찾기
	public ArrayList<ZipcodeDto> zipcodeRead(String dongName) {
		ArrayList<ZipcodeDto> list = new ArrayList<>();

		try {
			conn = ds.getConnection();
			String sql = "select * from ziptab where area3 like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongName + "%"); // 동 이름 채워서 검색
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeDto dto = new ZipcodeDto(); // 우편번호 정보 상자
				dto.setZipcode(rs.getString("zipcode"));
				dto.setArea1(rs.getString("area1"));
				dto.setArea2(rs.getString("area2"));
				dto.setArea3(rs.getString("area3"));
				dto.setArea4(rs.getString("area4"));
				list.add(dto); // 리스트에 추가
			}
		} catch (Exception e) {
			System.out.println("zipcodeRead err : " + e);
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

	}

	public boolean idCheckProcess(String id) {
		boolean b = false;

		try {
			conn = ds.getConnection();
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			b = rs.next(); // 결과가 있으면 true → 이미 있는 아이디
		} catch (Exception e) {
			System.out.println("idCheckProcess 로딩 실패 : " + e);
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
		return b; // true: 아이디 있음 / false: 아이디 없음
	}
	
	//회원가입할 때 입력한 정보들을 DB에 저장해주는 함수.
	public boolean memberInsert(MemberBean mbean) {
		boolean b = false;
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mbean.getId());
			pstmt.setString(2, mbean.getPasswd());
			pstmt.setString(3, mbean.getName());
			pstmt.setString(4, mbean.getEmail());
			pstmt.setString(5, mbean.getPhone());
			pstmt.setString(6, mbean.getZipcode());
			pstmt.setString(7, mbean.getAddress());
			pstmt.setString(8, mbean.getJob());
			if (pstmt.executeUpdate() > 0)
				b = true;
		} catch (Exception e) {
			System.out.println("memberInsert 로딩 실패 : " + e);
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
		return b;
	}
	
	// 로그인 확인 (아이디+비밀번호 맞는지 확인)
	public boolean loginCheck(String id, String passwd) {
	    boolean b = false;
	    String sql = "select * from member where id=? and passwd=?";

	    try {
	        conn = ds.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);
	        pstmt.setString(2, passwd);
	        rs = pstmt.executeQuery();

	        b = rs.next();  // 맞는 정보가 있으면 true
	    } catch (Exception e) {
	        System.out.println("loginCheck 로딩 실패 : " + e);
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
		return b;
	}

	
	public MemberDto getMember(String id) {
		MemberDto memberDto = null;
		
		try {
			 conn = ds.getConnection();
			 String sql = "select * from member where id=?";
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 memberDto = new MemberDto();
				 memberDto.setId(rs.getString("id"));
				 memberDto.setPasswd(rs.getString("passwd"));
				 memberDto.setName(rs.getString("name"));
				 memberDto.setEmail(rs.getString("email"));
				 memberDto.setPhone(rs.getString("phone"));
				 memberDto.setZipcode(rs.getString("zipcode"));
				 memberDto.setAddress(rs.getString("address"));
				 memberDto.setJob(rs.getString("job"));
			 }
		} catch (Exception e) {
		     System.out.println("getMember 로딩 실패 : " + e);
		}finally {
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
		return memberDto;
		
	}
	public boolean memberUpdate(MemberBean bean, String id) {
	    boolean b = false;
	    String sql = "UPDATE member SET passwd=?, name=?, email=?, phone=?, zipcode=?, address=?, job=? WHERE id=?";

	    try {
	        conn = ds.getConnection();	        
	        pstmt = conn.prepareStatement(sql);	       
	        pstmt.setString(1, bean.getPasswd());	        
	        pstmt.setString(2, bean.getName());	      
	        pstmt.setString(3, bean.getEmail());	       
	        pstmt.setString(4, bean.getPhone());
	        pstmt.setString(5, bean.getZipcode());
	        pstmt.setString(6, bean.getAddress());
	        pstmt.setString(7, bean.getJob());
	        pstmt.setString(8, id);

	        if (pstmt.executeUpdate() > 0) b = true;  

	    } catch (Exception e) {
	        System.out.println("memberUpdate 로딩 실패 : " + e);
	    } finally {
	        try {
	            if (pstmt != null)
	                pstmt.close();
	            if (conn != null)
	                conn.close();
	        } catch (Exception e2) {}
	    }
	    return b;
	}

	public boolean adminLoginCheck(String adminid, String adminpasswd) {
	    boolean b = false;

	    try {
	        conn = ds.getConnection();
	        String sql = "SELECT * FROM admin WHERE admin_id = ? AND admin_passwd = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, adminid);
	        pstmt.setString(2, adminpasswd);
	        rs = pstmt.executeQuery();
	        b = rs.next();
	    } catch (Exception e) {
	        System.out.println("adminLoginCheck 오류: " + e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e2) {}
	    }

	    return b;
	}

	
	public ArrayList<MemberDto> getMemberAll() {
	    ArrayList<MemberDto> list = new ArrayList<MemberDto>();

	    try {
	        conn = ds.getConnection();
	        String sql = "SELECT * FROM member ORDER BY id";	// 아이디별로 불러옴
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            MemberDto dto = new MemberDto(); // 회원정보를 담을 DTO 객체생성
	            dto.setId(rs.getString("id"));
	            dto.setName(rs.getString("name"));
	            dto.setEmail(rs.getString("email"));
	            dto.setPhone(rs.getString("phone"));
	            list.add(dto); // 리~~스트에 추가!
	        }
	    } catch (Exception e) {
	        System.out.println("getMemberAll 오류: " + e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception e2) {}
	    }

	    return list;
	}

}