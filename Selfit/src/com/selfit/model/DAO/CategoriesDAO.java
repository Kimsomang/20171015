package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.selfit.model.DTO.Categories;

public class CategoriesDAO {
	private FactoryDAO factory = FactoryDAO.getInstance();
	private static CategoriesDAO instance = new CategoriesDAO();
	
	private CategoriesDAO() {
	}
	
	public static CategoriesDAO getInstance() {
		return instance;
	}
	
	/**
	 * 카테고리 정보 전체 목록 조회 메소드
	 * @return 카테고리 정보 리스트
	 */
	public ArrayList<Categories> getAllCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from categories";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Categories> categoryList = new ArrayList<>();
			while(rs.next()) {
				String categoriesId = rs.getString("CATEGORIES_ID");
				String categoriesName = rs.getString("CATEGORIES_NAME");
				String categoriesDesc = rs.getString("CATEGORIES_DESC");
				
				categoryList.add(new Categories(categoriesId, categoriesName, categoriesDesc));
			}
			return categoryList;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error : 카테고리 정보 전체 검색 오류");
		
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public Categories getCategory(String categoryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from categories where categories_id = ?";
		Categories category = null;
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String categoriesId = rs.getString("CATEGORIES_iD");
				String categoriesName = rs.getString("CATEGORIES_NAME");
				String categoriesDesc = rs.getString("CATEGORIES_DESC");
				
				category = new Categories(categoriesId, categoriesName, categoriesDesc);
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("카테고리 조회 오류");
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int insertCategory(Categories category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into categories values(?, ?, ?)";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category.getCategoriesId());
			pstmt.setString(2, category.getCategoriesName());
			pstmt.setString(3, category.getCategoriesDesc());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("카테고리 삽입 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int updateCategory(Categories category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update categories set categories_name = ?, categories_desc = ? where categories_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, category.getCategoriesName());
			pstmt.setString(2, category.getCategoriesDesc());
			pstmt.setString(3, category.getCategoriesId());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("카테고리 수정 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int deleteCategory(String categoryId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from categories where categories_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, categoryId);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("카테고리 삭제 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
}
