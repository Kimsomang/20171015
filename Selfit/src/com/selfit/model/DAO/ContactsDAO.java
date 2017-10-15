package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.selfit.model.DTO.Contacts;
import com.selfit.model.utility.Utility;

public class ContactsDAO {
	private FactoryDAO factory = FactoryDAO.getInstance();
	private static ContactsDAO instance = new ContactsDAO();
	
	private ContactsDAO() {
	}
	
	public static ContactsDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Contacts> getAllContacts() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select*from contacts";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			ArrayList<Contacts> contactList = new ArrayList<>();
			while(rs.next()) {
				String contactCorp = rs.getString("contact_corp");
				String contactPerson = rs.getString("contact_person");
				String contactTel = rs.getString("contact_tel");
				String contactEmail = rs.getString("contact_email");
				String contactDate = rs.getString("contact_date");
				
				contactList.add(new Contacts(contactCorp, contactPerson, contactTel, contactEmail, contactDate));
			}
			return contactList;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("제휴문의 오류");
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int insertContact(Contacts contact) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into contacts values(?, ?, ?, ?, ?)";
		Utility util = new Utility();
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, contact.getContactCorp());
			pstmt.setString(2, contact.getContactPerson());
			pstmt.setString(3, contact.getContactTel());
			pstmt.setString(4, contact.getContactEmail());
			pstmt.setString(5, util.getDate());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("제휴문의 삽입 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
}
