package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.selfit.model.DTO.PostData;

public class PostDao {
	FactoryDAO fDao = FactoryDAO.getInstance();
	
	public PostDao() {}
	
	public ArrayList<PostData> selectAddress(String dong){
		ArrayList<PostData> array = new ArrayList<PostData>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select zipcode, sido, gugun, dong, ri, bldg, bunji, seq from zipcode_old where dong like(?)";
		
		try {
			conn = fDao.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+dong+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				array.add(new PostData(rs.getString("zipcode"), rs.getString("sido"), rs.getString("gugun"), rs.getString("dong"), rs.getString("ri"), rs.getString("bldg"), rs.getString("bunji"), rs.getInt("seq")));
			}
			
			return array;
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			fDao.close(conn, pstmt, rs);
		}
		return null;
	}
}
