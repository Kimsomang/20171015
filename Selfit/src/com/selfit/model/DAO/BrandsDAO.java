package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.selfit.model.DTO.Brands;
import com.selfit.model.DTO.Categories;

public class BrandsDAO {
	private FactoryDAO factory = FactoryDAO.getInstance();
	private static BrandsDAO instance = new BrandsDAO();
	
	private BrandsDAO() {
	}
	
	public static BrandsDAO getInstance() {
		return instance;
	}
	
	/**
	 * 브랜드 정보 전체 목록 조회 메소드
	 * @return 브랜드 정보 리스트
	 */
	public ArrayList<Brands> getAllBrands() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from brands";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Brands> brandList = new ArrayList<>();
			while(rs.next()) {
				String brandId = rs.getString("BRAND_ID");
				String brandName = rs.getString("BRAND_NAME");
				String brandDesc = rs.getString("BRAND_DESC");
				
				brandList.add(new Brands(brandId, brandName, brandDesc));
			}
			return brandList;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error : 브랜드 정보 전체 검색 오류");
		
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public Brands getBrand(String brandId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from brands where brand_id = ?";
		Brands brand = null;
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brandId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String brandsId = rs.getString("BRAND_ID");
				String brandsName = rs.getString("BRAND_NAME");
				String brandsDesc = rs.getString("BRAND_DESC");
				
				brand = new Brands(brandsId, brandsName, brandsDesc);
			}
			return brand;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("브랜드 조회 오류");
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int insertBrand(Brands brand) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into brands values(?, ?, ?)";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, brand.getBrandId());
			pstmt.setString(2, brand.getBrandName());
			pstmt.setString(3, brand.getBrandDesc());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("브랜드 삽입 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int updateBrand(Brands brand) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update brands set brand_name = ?, brand_desc = ? where brand_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, brand.getBrandName());
			pstmt.setString(2, brand.getBrandDesc());
			pstmt.setString(3, brand.getBrandId());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("브랜드 수정 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int deleteBrand(String brandsId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from brands where brand_id = ?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, brandsId);
			
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("브랜드 삭제 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	} 
}
