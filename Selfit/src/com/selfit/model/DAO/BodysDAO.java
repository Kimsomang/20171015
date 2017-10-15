package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.selfit.model.DTO.Bodys;
import com.selfit.model.DTO.Brands;

public class BodysDAO {
	private FactoryDAO factory = FactoryDAO.getInstance();
	private static BodysDAO instance = new BodysDAO();
	
	private BodysDAO() {
	}
	
	public static BodysDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Bodys> getAllBodys() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from bodys";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			ArrayList<Bodys> bodyList = new ArrayList<>();
			while(rs.next()) {
				String bodyId = rs.getString("body_id");
				String bodyName = rs.getString("body_name");
				String bodyDesc = rs.getString("body_desc");
				
				bodyList.add(new Bodys(bodyId, bodyName, bodyDesc));
			}
			return bodyList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("체형정보 전체 조회 오류");
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public Bodys getBody(String bodyId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from bodys where body_id = ?";
		Bodys body = null;
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bodyId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bodysId = rs.getString("body_id");
				String bodysName = rs.getString("body_name");
				String bodysDesc = rs.getString("body_desc");
				
				body = new Bodys(bodysId, bodysName, bodysDesc);
			}
			return body;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("체형정보 조회 오류");
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int insertBody(Bodys body) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into bodys values(?, ?, ?)";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, body.getBodyId());
			pstmt.setString(2, body.getBodyName());
			pstmt.setString(3, body.getBodyDesc());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("체형 삽입 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int updateBody(Bodys body) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update bodys set body_name = ?, body_desc = ? where body_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, body.getBodyName());
			pstmt.setString(2, body.getBodyDesc());
			pstmt.setString(3, body.getBodyId());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("체형 수정 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int deleteBody(String bodyId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from bodys where body_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bodyId);
			
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("체형 삭제 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	} 
}
