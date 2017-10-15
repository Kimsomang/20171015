/**
 * 
 */
package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author kosta
 *
 */
public class FactoryDAO {
	private static FactoryDAO instance = new FactoryDAO();
	private DataSource ds;
	
	private FactoryDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static FactoryDAO getInstance() {
		return instance;
	}
	
	/**
	 * CUD 자원해제
	 * @param conn
	 * @param stmt
	 */
	public void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
	
	/**
	 * SELECT 자원해제
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error : 자원 해제 오류");
		}
	}
	
}
