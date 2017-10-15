package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.selfit.model.DTO.Brands;

public class RecommendDAO {
	private static RecommendDAO instance = new RecommendDAO();
	private FactoryDAO factory = FactoryDAO.getInstance();

	private RecommendDAO() {
	}

	/** 인스턴스 반환 */
	public static RecommendDAO getInstance() {
		return instance;
	}
	
	/**
	 * 추천결과 조회기능
	 * @param bodyId 바디인덱스
	 * @return 바디 인덱스별 추천결과 조회부
	 */
	public ArrayList<Brands> getRecommend(String bodyId) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rs = null;
		ArrayList<Brands> returnValue = new ArrayList<>();
		String sql = "select a.brand_id brand_id, b.brand_name brand_name, b.brand_desc brand_desc, a.view_count view_count from (select brand_id, view_count from recommend where body_id = ?) a, brands b where a.brand_id = b.brand_id order by view_count asc";
		try {
			connection = factory.getConnect();
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, bodyId);
			rs = pStatement.executeQuery();
			while (rs.next()) {
				Brands temp = new Brands(rs.getString("brand_id"), rs.getString("brand_name"), rs.getString("brand_decs"));
				returnValue.add(temp);
			}
			return returnValue;
		} catch (Exception e) {
		} finally {
			factory.close(connection, pStatement, rs);
		}
		return null;
	}
}
