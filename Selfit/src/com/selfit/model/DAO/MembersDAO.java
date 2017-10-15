package com.selfit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.selfit.model.DTO.Members;

public class MembersDAO {
	private FactoryDAO factory = FactoryDAO.getInstance();
	private static MembersDAO instance = new MembersDAO();
	
	private MembersDAO() {
	}
	
	public static MembersDAO getInstance() {
		return instance;
	}
	
	/**
	 * 회원 정보 조회
	 * @param memberId 회원아이디
	 * @return 회원정보
	 */
	public Members getMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members where member_id = ?";
		Members member = null;
		
			try {
				conn = factory.getConnect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberId);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String memberid = rs.getString("MEMBER_ID");
					String memberPw = rs.getString("MEMBER_PW");
					String memberName = rs.getString("MEMBER_NAME");
					String memberBirth = rs.getString("MEMBER_BIRTH");
					String memberSex = rs.getString("MEMBER_SEX");
					String memberPhone = rs.getString("MEMBER_PHONE");
					String memberPost = rs.getString("MEMBER_POST");
					String memberAddress1 = rs.getString("MEMBER_ADDRESS1");
					String memberAddress2 = rs.getString("MEMBER_ADDRESS2");
					String memberBody = rs.getString("MEMBER_BODY");
					String memberGrade = rs.getString("MEMBER_GRADE");
					String memberBrand = rs.getString("MEMBER_BRAND");
					String memberEnt = rs.getString("MEMBER_ENT");
					String memberStatus = rs.getString("MEMBER_STATUS");
					String memberUpdate = rs.getString("MEMBER_UPDATE");
					int memberActcnt = rs.getInt("MEMBER_ACTCNT");
					
					member = new Members(memberid, memberPw, memberName, memberBirth, memberSex, memberPhone, memberPost, memberAddress1, memberAddress2, memberBody, memberGrade, memberBrand, memberEnt, memberStatus, memberUpdate, memberActcnt);
				}
				return member;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("회원정보 조회 오류");
			} finally {
				factory.close(conn, pstmt, rs);
			}
		return null;
	}
	
	/**
	 * 회원 정보 전체 목록 조회 메소드
	 * @return 회원 정보 목록
	 */
	public ArrayList<Members> getAllMembers() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from members";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Members> memberList = new ArrayList<>();
			while(rs.next()) {
				String memberId = rs.getString("MEMBER_ID");
				String memberPw = rs.getString("MEMBER_PW");
				String memberName = rs.getString("MEMBER_NAME");
				String memberBirth = rs.getString("MEMBER_BIRTH");
				String memberSex = rs.getString("MEMBER_SEX");
				String memberPhone = rs.getString("MEMBER_PHONE");
				String memberPost = rs.getString("MEMBER_POST");
				String memberAddress1 = rs.getString("MEMBER_ADDRESS1");
				String memberAddress2 = rs.getString("MEMBER_ADDRESS2");
				String memberBody = rs.getString("MEMBER_BODY");
				String memberGrade = rs.getString("MEMBER_GRADE");
				String memberBrand = rs.getString("MEMBER_BRAND");
				String memberEnt = rs.getString("MEMBER_ENT");
				String memberStatus = rs.getString("MEMBER_STATUS");
				String memberUpdate = rs.getString("MEMBER_UPDATE");
				int memberActcnt = rs.getInt("MEMBER_ACTCNT");
				
				memberList.add(new Members(memberId, memberPw, memberName, memberBirth, memberSex, memberPhone, memberPost, memberAddress1, memberAddress2, memberBody, memberGrade, memberBrand, memberEnt, memberStatus, memberUpdate, memberActcnt));
			}
			return memberList;
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error : 회원정보 전체 검색 오류");
		
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean isUpStatus(String id, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select member_status from members where member_id = ?";
		
			try {
				conn = factory.getConnect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					String memberStatus = rs.getString("MEMBER_STATUS");
					
					if(memberStatus.equals(status)) {
						return true;
					} else {
						return false;
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("회원정보 조회 오류");
			} finally {
				factory.close(conn, pstmt, rs);
			}
		return false;
	}
	
	public int updateMembers(Members member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		if(!isUpStatus(member.getMemberId(), member.getMemberStatus())) {
			sql = "update members set member_pw=?, member_name=?, member_phone=?, member_post=?, member_address1=?, member_address2=?,"
				+ "member_body=?, member_grade=?, member_brand=?, member_status=?, member_update=to_char(sysdate, 'yyyy.mm.dd') where member_id = ?";
		} else {
			sql = "update members set member_pw=?, member_name=?, member_phone=?, member_post=?, member_address1=?, member_address2=?,"
					+ "member_body=?, member_grade=?, member_brand=?, member_status=? where member_id = ?";
		}
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberPost());
			pstmt.setString(5, member.getMemberAddress1());
			pstmt.setString(6, member.getMemberAddress2());
			pstmt.setString(7, member.getMemberBody());
			pstmt.setString(8, member.getMemberGrade());
			pstmt.setString(9, member.getMemberBrand());
			pstmt.setString(10, member.getMemberStatus());
			pstmt.setString(11, member.getMemberId());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원정보 수정 오류");
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int insertMember(Members dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into members values(?,?,?,?,?,?,?,?,?,?,?,'',to_char(sysdate, 'yyyy.mm.dd'),'U',to_char(sysdate, 'yyyy.mm.dd'), 0)"; 
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getMemberBirth());
			pstmt.setString(5, dto.getMemberSex());
			pstmt.setString(6, dto.getMemberPhone());
			pstmt.setString(7, dto.getMemberPost());
			pstmt.setString(8, dto.getMemberAddress1());
			pstmt.setString(9, dto.getMemberAddress2());
			pstmt.setString(10, dto.getMemberBody());
			pstmt.setString(11, dto.getMemberGrade());
			
			int result = pstmt.executeUpdate();
			System.out.println("test");
			return result;
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public boolean isMemberId(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where member_id=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return false;
	}
	
	public Members selectMember(String memberId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from members where member_id=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Members(rs.getString("member_id"), rs.getString("member_pw"), rs.getString("member_name"), rs.getString("member_birth"), rs.getString("member_sex"), rs.getString("member_phone"), rs.getString("member_post"), rs.getString("member_address1"), rs.getString("member_address2"), rs.getString("member_body"), rs.getString("member_grade"));
			}
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	
	public int updateMember(String memberId, String memberPhone, String memberPost, String memberAddress1, String memberAddress2, String memberBody) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update members set member_phone=?, member_post=?, member_address1=?, member_address2=?, member_body=? where member_id=?"; 
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberPhone);
			pstmt.setString(2, memberPost);
			pstmt.setString(3, memberAddress1);
			pstmt.setString(4, memberAddress2);
			pstmt.setString(5, memberBody);
			pstmt.setString(6, memberId);
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	
	public String findMemberId(String memberName, String memberBirth) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select member_id from members where member_name=? and member_birth=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberBirth);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			return rs.getString("member_id");
			
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean findMemberPw(String memberId, String memberBirth, String memberPhone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select member_pw from members where member_id=? and member_birth=? and member_phone=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberBirth);
			pstmt.setString(3, memberPhone);
			
			rs = pstmt.executeQuery();

			return rs.next();
			
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return false;
	}
	
	public int changeMemberPw(String memberId, String changePw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update members set member_pw=? where member_id=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changePw);
			pstmt.setString(2, memberId);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[Error]: sql 실행구문 오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public HashMap<String, String> checkLogin(String memberId, String memberPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select member_id, member_body, member_grade from members where member_id=? and member_pw=?";
		
		try {
			conn = factory.getConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				HashMap<String, String> memberInfo = new HashMap<>();
				memberInfo.put("memberId", rs.getString("member_id"));
				memberInfo.put("memberBody", rs.getString("member_body"));
				memberInfo.put("memberGrade", rs.getString("member_grade"));
				return memberInfo;
			}
			
		} catch (SQLException e) {
			System.out.println("[Error]: sql 구문 실행오류!");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
