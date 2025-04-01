package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnPooling {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	public DbConnPooling() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("DbConnPooling 생성자 오류: " + e);
		}
	}

	public ArrayList<GuestbookDto> getDataAll() {
		ArrayList<GuestbookDto> list = new ArrayList<>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from guestbook");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GuestbookDto dto = new GuestbookDto();
				dto.setCode(rs.getString("code"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContents(rs.getString("contents"));
				list.add(dto);
			}

		} catch (Exception e) {
		System.out.println("getDataAll err");	e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public boolean insertData(GuestbookFormBean bean) {
		boolean b = false;
		try {
			conn = ds.getConnection();

			String sql = "select max(code) as max from guestbook";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxCode = 0;
			if(rs.next()) {
			maxCode = rs.getInt("max");
			}
			maxCode += 1;
			
			// 추가
			sql = "insert into guestbook(code,writer,title,contents) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxCode);
			pstmt.setString(2, bean.getWriter());
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getContents());
			
			int result = pstmt.executeUpdate();
			if(result == 1) b = true;
			
		} catch (Exception e) {
			System.out.println("insertData err" + e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return b;
	}
	
	public GuestbookDto updateDataRead(String code) {
		
	GuestbookDto dto = null;
	String sql = "select * from guestbook where code=?";
			
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1,code);
				ResultSet rs = pstmt.executeQuery();	
				if(rs.next()) {
					dto = new GuestbookDto();
					dto.setCode(rs.getString("code"));
					dto.setWriter(rs.getString("writer"));
					dto.setTitle(rs.getString("title"));
					dto.setContents(rs.getString("contents"));
					
				}
		}catch (Exception e) {
			System.out.println("updateDataRead errr : " + e);
		}

	
		return dto;
	}
	
	
	public boolean updateData(GuestbookFormBean bean) {
		boolean b = false;
		
		String sql = "update guestbook set writer=?,title=?,contents=? where code=?";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, bean.getWriter());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContents());
			pstmt.setString(4, bean.getCode());
			if(pstmt.executeUpdate() > 0) b = true;

		} catch (Exception e) {
			System.out.println("updateData err " + e);
		}
		
		return b;
	}
	
	public boolean deleteData(String code) {
		boolean b = false;
		String sql = "delete from guestbook where code=?";
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, code);
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			System.out.println("deleteData err " + e);
		}
		
		
		return b;
	}
	
	
	
	
}
