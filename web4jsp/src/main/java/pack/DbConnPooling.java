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

	public ArrayList<SangpumDto> getDataAll() {
		ArrayList<SangpumDto> list = new ArrayList<>();

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
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

	public boolean insertData(SangpumFormBean bean) {
		boolean b = false;
		try {
			conn = ds.getConnection();

			String sql = "select max(code) as max from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxCode = 0;
			if(rs.next()) {
			maxCode = rs.getInt("max");
			}
			maxCode += 1;
			
			// 추가
			sql = "insert into sangdata(code,sang,su,dan) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxCode);
			pstmt.setString(2, bean.getSang());
			pstmt.setString(3, bean.getSu());
			pstmt.setString(4, bean.getDan());
			int result = pstmt.executeUpdate();
			if(result == 1) b = true;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
		return b;
	}
	
	public SangpumDto updateDataRead(String code) {
		
	SangpumDto dto = null;
	String sql = "select * from sangdata where code=?";
			
		try(
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1,code);
				ResultSet rs = pstmt.executeQuery();	
				if(rs.next()) {
					dto = new SangpumDto();
					dto.setCode(rs.getString("code"));
					dto.setSang(rs.getString("sang"));
					dto.setSu(rs.getString("su"));
					dto.setDan(rs.getString("dan"));
				}
		}catch (Exception e) {
			System.out.println("updateDataRead errr : " + e);
		}

	
		return dto;
	}
	
	
	public boolean updateData(SangpumFormBean bean) {
		boolean b = false;
		
		String sql = "update sangdata set sang=?,su=?,dan=? where code=?";
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, bean.getSang());
			pstmt.setString(2, bean.getSu());
			pstmt.setString(3, bean.getDan());
			pstmt.setString(4, bean.getCode());
			if(pstmt.executeUpdate() > 0) b = true;

		} catch (Exception e) {
			System.out.println("updateData err " + e);
		}
		
		return b;
	}
	
	public boolean deleteData(String code) {
		boolean b = false;
		String sql = "delete from sangdata where code=?";
		
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
