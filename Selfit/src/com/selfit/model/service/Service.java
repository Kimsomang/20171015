package com.selfit.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.selfit.model.DAO.BodysDAO;
import com.selfit.model.DAO.BrandsDAO;
import com.selfit.model.DAO.CategoriesDAO;
import com.selfit.model.DAO.ContactsDAO;
import com.selfit.model.DAO.MembersDAO;
import com.selfit.model.DAO.PostDao;
import com.selfit.model.DTO.Bodys;
import com.selfit.model.DTO.Brands;
import com.selfit.model.DTO.Categories;
import com.selfit.model.DTO.Contacts;
import com.selfit.model.DTO.Members;
import com.selfit.model.DTO.PostData;

public class Service {

	private MembersDAO memberDAO = MembersDAO.getInstance();
	private CategoriesDAO categoryDAO = CategoriesDAO.getInstance();
	private BrandsDAO brandDAO = BrandsDAO.getInstance();
	private ContactsDAO contactDAO = ContactsDAO.getInstance();
	private BodysDAO bodyDAO = BodysDAO.getInstance();
	PostDao postDao = new PostDao();
	
	public int insertMember(Members dto) {
		return memberDAO.insertMember(dto);
	}
	
	public boolean isMemberId(String memberId) {
		return memberDAO.isMemberId(memberId);
	}
	
	public Members selectMember(String memberId) {
		return memberDAO.selectMember(memberId);
	}
		
	public String findMemberId(String memberName, String memberBirth) {
		return memberDAO.findMemberId(memberName, memberBirth);
	}
	
	public boolean findMemberPw(String memberId, String memberBirth, String memberPhone) {
		return memberDAO.findMemberPw(memberId, memberBirth, memberPhone);
	}
	
	public int updateMember(String memberId, String memberPhone, String memberPost, 
							String memberAddress1, String memberAddress2, String memberBody) {
		return memberDAO.updateMember(memberId, memberPhone, memberPost, memberAddress1, memberAddress2, memberBody);
	}
	
	public int changeMemberPw(String memberId, String changePw) {
		return memberDAO.changeMemberPw(memberId, changePw);
	}

	public HashMap<String, String> checkLogin(String memberId, String memberPw) {
		return memberDAO.checkLogin(memberId, memberPw);
	}
	
	public ArrayList<PostData> selectAddress(String dong){
		return postDao.selectAddress(dong);
	}
	
	/**
	 * 회원 정보 전체 조회를 위한 메소드
	 * @return 회원정보 리스트
	 */
	public ArrayList<Members> getAllMembers() {
		ArrayList<Members> members = memberDAO.getAllMembers();
		
		return members;
	}
	
	public Members getMember(String memberId) {
		Members member = memberDAO.getMember(memberId);
		return member;
	}
	
	public void updateMembers(Members member) {
		if(memberDAO.updateMembers(member) == 0) {
			System.out.println("회원정보 수정실패");
		} else {
			System.out.println("회원정보 수정성공");
		}
	}
	
	/**
	 * 체형 정보 전체 조회를 위한 메소드
	 * @return 체형 정보 리스트
	 */
	public ArrayList<Bodys> getAllBodys() {
		ArrayList<Bodys> bodys = bodyDAO.getAllBodys();
		return bodys;
	}
	
	public Bodys getBody(String bodyId) {
		Bodys body = bodyDAO.getBody(bodyId);
		return body;
	}
	
	public void insertBody(Bodys body) {
		if(bodyDAO.insertBody(body) == 0) {
			System.out.println("체형 삽입 실패");
		} else {
			System.out.println("체형 삽입 성공");
		}
	}
	
	public void updateBody(Bodys body) {
		if(bodyDAO.updateBody(body) == 0) {
			System.out.println("체형 수정실패");
		} else {
			System.out.println("체형 수정성공");
		}
	}
	
	public void deleteBody(String bodyId) {
		if(bodyDAO.deleteBody(bodyId) == 0) {
			System.out.println("체형 삭제 실패");
		} else {
			System.out.println("체형 삭제 성공");
		}
	}
	
	/**
	 * 카테고리 정보 전체 조회를 위한 메소드
	 * @return 카테고리 정보 리스트
	 */
	public ArrayList<Categories> getAllContents() {
		ArrayList<Categories> category = categoryDAO.getAllCategory();
		return category;
	}
	
	public Categories getCategory(String categoryId) {
		Categories category = categoryDAO.getCategory(categoryId);
		return category;
	}
	
	public void insertCategory(Categories category) {
		if(categoryDAO.insertCategory(category) == 0) {
			System.out.println("카테고리 삽입실패");
		} else {
			System.out.println("카테고리 삽입성공");
		}
	}
	
	public void updateCategory(Categories category) {
		if(categoryDAO.updateCategory(category) == 0) {
			System.out.println("카테고리 수정실패");
		} else {
			System.out.println("카테고리 수정성공");
		}
	}
	
	public void deleteCategory(String categoryId) {
		if(categoryDAO.deleteCategory(categoryId) == 0) {
			System.out.println("카테고리 삭제 실패");
		} else {
			System.out.println("카테고리 삭제 성공");
		}
	}
	
	public Brands getBrand(String brandId) {
		Brands brand = brandDAO.getBrand(brandId);
		return brand;
	}
	
	public ArrayList<Brands> getAllBrands() {
		ArrayList<Brands> brand = brandDAO.getAllBrands();
		return brand;
	}
	
	public void insertBrand(Brands brand) {
		if(brandDAO.insertBrand(brand) == 0) {
			System.out.println("브랜드 삽입실패");
		} else {
			System.out.println("브랜드 삽입성공");
		}
	}
	
	public void updateBrand(Brands brand) {
		if(brandDAO.updateBrand(brand) == 0) {
			System.out.println("브랜드 수정실패");
		} else {
			System.out.println("브랜드 수정성공");
		}
	}
	
	public void deleteBrand(String brandsId) {
		if(brandDAO.deleteBrand(brandsId) == 0) {
			System.out.println("브랜드 삭제 실패");
		} else {
			System.out.println("브랜드 삭제 성공");
		}
	}
	
	public ArrayList<Contacts> getAllContacts() {
		ArrayList<Contacts> contact = contactDAO.getAllContacts();
		return contact;
	}
	
	public void insertContact(Contacts contact) {
		if(contactDAO.insertContact(contact) == 0) {
			System.out.println("제휴문의 삽입 실패");
		} else {
			System.out.println("제휴문의 삽입 성공");
		}
	}
}
