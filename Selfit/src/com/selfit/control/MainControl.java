package com.selfit.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.selfit.model.DTO.Bodys;
import com.selfit.model.DTO.Brands;
import com.selfit.model.DTO.Categories;
import com.selfit.model.DTO.Contacts;
import com.selfit.model.DTO.Members;
import com.selfit.model.DTO.PostData;
import com.selfit.model.service.Service;
import com.selfit.model.utility.Utility;

/**
 * Servlet implementation class MainControl
 */
public class MainControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Service service = new Service();
       
	/** 기본 생성자 */
    public MainControl() {
    }

    /**
	 * <pre>
	 * MainControl에서 최초로 수행하는 메서드
	 * </pre>
	 * 
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}
	
	/**
	 * <pre>
	 * action으로 서비스 형태를 제대로 받아오는지 확인하는 메서드
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @return 서비스 형태를 담고 있는가에 대한 boolean 값
	 */
	protected boolean isAction(HttpServletRequest request) {
		if(request.getParameter("action") != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * <pre>
	 * 사용자 인증 메서드
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @return 로그 상태의 회원아이디 존재 유무에 따른 boolean 값
	 */
	protected boolean isLogin(HttpServletRequest request) {
		String memberId = getId(request);
		String memberGrade = getGrade(request);
		if (memberId == null || memberId.trim().isEmpty()) {
			if (memberGrade==null || memberGrade.isEmpty()) {
				return false;
			}
			return false;
		}
		return true;
	}
	
	/**
	 * <pre>
	 * 로그인 상태 회원 아이디를 받아오는 메서드
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @return 로그인 상태 회원 아이디
	 */
	private String getId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String memberId = (String)session.getAttribute("memberId");
		return memberId;
	}
	
	/**
	 * <pre>
	 * 로그인 상태 회원 등급을 받아오는 메서드
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @return 로그인 상태 회원 등급
	 */
	private String getGrade(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String memberGrade = (String)session.getAttribute("memberGrade");
		return memberGrade;
	}
	
	/**
	 * 관리자 확인여부, 로그인 안되어 있으면 로그인 페이지 자동연결, 등급 초과 시 에러페이지 연결
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @return true 관리자 계정, false 사용자 계정
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean isAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isLogin(request)) {
			response.sendRedirect("login.jsp");
			return false;
		} else {
			String memberGrade = getGrade(request);
			System.out.println(memberGrade);
			switch (memberGrade) {
			case "G":
				response.sendRedirect("gradeError.jsp");
				return false;
			case "A":
				return true;
			default:
				return false;
			}
		}
	}
	
	/**
	 * 일반사용자 확인 메서드, 로그인 안되어 있으면 로그인 페이지 자동연결, 등급 초과 시 에러페이지 연결
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @return true 사용자 계정, false 미로그인 계정
	 * @throws ServletException
	 * @throws IOException
	 */
	private boolean isGeneral(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isLogin(request)) {
			request.getRequestDispatcher("login.jsp");
			return false;
		} else {
			return true;
		}
	}
	
	
	protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String memberGrade = (String)session.getAttribute("memberGrade");
		if (memberGrade == null || memberGrade.isEmpty()) {
			memberGrade = "Void";
		}
		switch (memberGrade) {
		case "A":
			response.sendRedirect("control?action=manage");
			break;
		case "G" :
			response.sendRedirect("control?action=serviceCategories");
			break;
		default:
			System.out.println("DEFAULT : "+memberGrade);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isLogin(request)) {
			response.sendRedirect("serviceError.jsp");
			return;
		}
		HttpSession session = request.getSession();
		session.removeAttribute("memberGrade");
		session.removeAttribute("memberId");
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	
	protected void errorHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("serviceName", request.getParameter("action"));
		request.setAttribute("errorDesc", "현재 서비스 되지 않는 페이지 입니다, 다시 확인하여 주십시요");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	/**
	 * <pre>
	 * 회원 가입 서비스를 수행하는 메서드
	 * - 회원 등급 최초 설정: 'G'등급 부여
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void signin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId1")+"@"+request.getParameter("memberId2");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberBirth = request.getParameter("memberBirth1")+"."+request.getParameter("memberBirth2")
							+"."+request.getParameter("memberBirth3");
		String memberSex = request.getParameter("memberSex");
		String memberPhone = request.getParameter("memberPhone1")+"-"+request.getParameter("memberPhone2")
							+"-"+request.getParameter("memberPhone3");
		String memberPost = request.getParameter("memberPost");
		String memberAddress1 = request.getParameter("memberAddress1");
		String memberAddress2 = request.getParameter("memberAddress2");
		String memberBody = request.getParameter("memberBody");
		
		Members dto = new Members(memberId, memberPw, memberName, memberBirth, memberSex, memberPhone, 
									memberPost, memberAddress1, memberAddress2, memberBody, "G");
		if(service.insertMember(dto)!=1) {
			request.setAttribute("error", "회원가입");
			request.getRequestDispatcher("error.jsp");
			return;
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	
	/**
	 * <pre>
	 * 우편주소 서비스를 이행하는 메서드
	 * -회원이 입력한 '동(면/읍)'에 해당하는 주소를 검색
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void postService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong = request.getParameter("dong");
		ArrayList<PostData> postData = service.selectAddress(dong);
		
		request.setAttribute("postData", postData);
		
		request.getRequestDispatcher("/postService.jsp").forward(request, response);
	}
		
	/**
	 * <pre>
	 * 로그인 서비스를 수행하는 메서드
	 * -회원 아이디/비밀번호를 검사하는 역할
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		HashMap<String, String> memberInfo = service.checkLogin(loginId, loginPw);
		if(memberInfo!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("memberId", memberInfo.get("memberId"));
			session.setAttribute("memberBody", memberInfo.get("memberBody"));
			session.setAttribute("memberGrade", memberInfo.get("memberGrade"));
			
			response.sendRedirect("control?action=serviceCategories");
			
		}else {
			request.setAttribute("logMsg", "아이디 혹은 비밀번호를 다시 확인해주세요!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * <pre>
	 * 아이디 찾기 서비스를 수행하는 메서드
	 * -회원의 이름/생년월일을 통해 회원 아이디 조회
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void idfind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("memberName");
		String memberBirth = request.getParameter("memberBirth1")+"."+request.getParameter("memberBirth2")
								+"."+request.getParameter("memberBirth3");
		String findId = service.findMemberId(memberName, memberBirth);
		if(findId!=null) {
			request.setAttribute("idfindMsg", "찾으시는 아이디: "+findId);
			request.getRequestDispatcher("/idfind.jsp").forward(request, response);			
		}else {
			request.setAttribute("idfindMsg", "사용자 입력 정보가 올바르지 않습니다!");
			request.getRequestDispatcher("/idfind.jsp").forward(request, response);						
		}
	}
	
	/**
	 * <pre>
	 * 비밀번호 찾기 서비스를 수행하는 메서드
	 * -회원의 아이디/생년월일/전화번호를 통해 회원 비밀번호 조회
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void pwfind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId")+"@"+request.getParameter("memberId2");
		String memberBirth = request.getParameter("memberBirth1")+"."+request.getParameter("memberBirth2")
		+"."+request.getParameter("memberBirth3");
		String memberPhone = request.getParameter("memberPhone1")+"-"+request.getParameter("memberPhone2")
		+"-"+request.getParameter("memberPhone3");
		Utility util = new Utility();
		if(service.findMemberPw(memberId, memberBirth, memberPhone)) {
			String changePw = util.createRandomPw();
			if(service.changeMemberPw(memberId, changePw)!=1) {
				System.out.println("[Error]: 비밀번호 변경 실패!");
			}
			
			request.setAttribute("pwfindMsg", "임시비밀번호 발급: "+changePw);
			request.setAttribute("pwfindMsg2", "[로그인 후! 비밀번호를 지금 바로 변경해주시기 바랍니다!!]");
			request.getRequestDispatcher("/pwfind.jsp").forward(request, response);						
		}else {
			request.setAttribute("pwfindMsg", "사용자 입력 정보가 올바르지 않습니다!");
			request.getRequestDispatcher("/pwfind.jsp").forward(request, response);									
		}
	}
	
	/**
	 * <pre>
	 * 내 정보보기 서비스를 수행하는 메서드
	 * -세션에 저장된 회원 아이디를 통해 회원 정보 조회
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogin = isLogin(request);
		if(isLogin) {
			if(getGrade(request).equals("A")) {
				getAdminInfo(request,response);
			} else {
				Members member = service.selectMember(getId(request));
				request.setAttribute("member", member);
				request.getRequestDispatcher("mypage.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("error", "로그인 정보가 없습니다!");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	/**
	 * <pre>
	 * 회원 정보를 수정하는 메서드
	 * -로그인 회원이 입력한 데이터를 바탕으로 수정
	 * -수정항목: 회원 전화번호/주소/체형  
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isLogin = isLogin(request);
		
		if(isLogin) {
			String memberPhone = request.getParameter("memberPhone1")+"-"+request.getParameter("memberPhone2")
									+"-"+request.getParameter("memberPhone3");
			String memberPost = request.getParameter("memberPost");
			String memberAddress1 = request.getParameter("memberAddress1");
			String memberAddress2 = request.getParameter("memberAddress2");
			String memberBody = request.getParameter("memberBody");
			int result = service.updateMember(getId(request), memberPhone, memberPost,
												memberAddress1, memberAddress2, memberBody);
			if(result==1) {
				response.sendRedirect("control?action=manage");
			}else {
				request.setAttribute("error", "수정 실패!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);				
			}
		}
	}
	
	/**
	 * <pre>
	 * 회원 비밀번호 변경 서비스를 수행하는 메서드
	 * -로그인 회원이 입력한 비밀번호로 개인 비밀번호를 변경
	 * </pre>
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void changePw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		boolean isLogin = isLogin(request);
		if(isLogin) {
			String changePw = request.getParameter("changePw");
			int result = service.changeMemberPw(getId(request), changePw);
			if(result==1) {
				response.sendRedirect("control?action=serviceCategories");				
			}else {
				request.setAttribute("error", "비밀번호 변경 실패!");
				request.getRequestDispatcher("/error.jsp").forward(request, response);								
			}
		}
	}
	
	/**
	 * 메니지 페이지 접근 메서드, 관리자 로그인 확인용임
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void manage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		request.getRequestDispatcher("manage.jsp").forward(request, response);
	}
	
	/**
	 * 회원정보 전체 조회 메소드
	 * Members 테이블 전체 조회 후 manageMembers 페이지로 이동하여 값(List)을 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		ArrayList<Members> members = service.getAllMembers();
		if(members != null) {
			request.setAttribute("getAllMembers", members);
			request.getRequestDispatcher("manageMembers.jsp").forward(request, response);
		}
	}

	/**
	 * 체형 정보 전체 조회 메소드
	 * Bodys 테이블 전체 조회 후 manageBodys 페이지로 이동하여 값(List)을 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllBodys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		ArrayList<Bodys> body = service.getAllBodys();
		if(body != null) {
			request.setAttribute("getAllBodys", body);
			request.getRequestDispatcher("manageBodys.jsp").forward(request, response);
		}
	}
	
	/**
	 * 카테고리 정보 전체 조회 메소드
	 * Categories 테이블 전체 조회 후 manageContents 페이지로 이동하여 값(List)을 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllContents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		ArrayList<Categories> category = service.getAllContents();
		if(category != null) {
			request.setAttribute("getAllContents", category);
			request.getRequestDispatcher("manageContents.jsp").forward(request, response);
		}
	}

	/**
	 * 브랜드 정보 전체 조회 메소드
	 * Brands 테이블 전체 조회 후 manageBrands 페이지로 이동하여 값(List)을 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		ArrayList<Brands> brand = service.getAllBrands();
		if(brand != null) {
			request.setAttribute("getAllBrands", brand);
			request.getRequestDispatcher("manageBrands.jsp").forward(request, response);
		}
	}
	
	/**
	 * 관리자 정보 조회 메소드
	 * 세션 아이디 값을 조회하여 관리자 자신의 정보를 조회
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAdminInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		
		boolean isLogin = isLogin(request);
		if(isLogin) {
			Members member = service.getMember(getId(request));
			
			if(member != null) {
				request.setAttribute("adminInfo", member);
				request.getRequestDispatcher("/manageInfo.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "관리자 정보조회 실패");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("errorMessage", "로그인 정보가 없습니다.");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	/**
	 * 관리자 정보 수정 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pw");
		String memberName = request.getParameter("userName");
		String memberPhone = request.getParameter("mobile");
		String memberPost = request.getParameter("post");
		String memberAddress1 = request.getParameter("address1");
		String memberAddress2 = request.getParameter("address2");
		String memberBody = request.getParameter("bodyType");
		String memberGrade = request.getParameter("grade");
		String memberBrand = request.getParameter("preferBrand");
		String memberStatus = request.getParameter("condition");
		Members member = new Members(memberId, memberPw, memberName, null, null, memberPhone, memberPost, memberAddress1, memberAddress2, memberBody, memberGrade, memberBrand, null, memberStatus, null, 0);
		if(member != null) {
			service.updateMembers(member);
			getAllMembers(request, response);
		}
	}
	
	/**
	 * 회원 정보 수정 메소드
	 * 관리자의 권한으로 회원의 정보를 가져와서 수정페이지로 이동
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String memberId = request.getParameter("id");
		Members member = service.getMember(memberId);
		
		if(member != null) {
			request.setAttribute("getMember", member);
			request.getRequestDispatcher("updateMembers.jsp").forward(request, response);
		}
	}
	
	/**
	 * 관리자가 수정페이지에서 회원 정보를 수정해주는 메소드
	 * 수정페이지에서 작성한 회원의 수정정보를 입력받아 DB정보를 수정시켜줌
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pw");
		String memberName = request.getParameter("userName");
		String memberPhone = request.getParameter("mobile");
		String memberPost = request.getParameter("post");
		String memberAddress1 = request.getParameter("address1");
		String memberAddress2 = request.getParameter("address2");
		String memberBody = request.getParameter("bodyType");
		String memberGrade = request.getParameter("grade");
		String memberBrand = request.getParameter("preferBrand");
		String memberStatus = request.getParameter("condition");
		Members member = new Members(memberId, memberPw, memberName, null, null, memberPhone, memberPost, memberAddress1, memberAddress2, memberBody, memberGrade, memberBrand, null, memberStatus, null, 0);
		if(member != null) {
			service.updateMembers(member);
			getAllMembers(request, response);
		}
	}
	
	/**
	 * 체형정보 등록 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertBody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String bodyId = request.getParameter("bodysId");
		String bodyName = request.getParameter("bodysName");
		String bodyDesc = request.getParameter("bodysDesc");
		Bodys body = new Bodys(bodyId, bodyName, bodyDesc);
		if(body != null) {
			service.insertBody(body);
			getAllBodys(request, response);
		}
	}
	
	/**
	 * 카테고리 등록 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String categoriesId = request.getParameter("categoriesId");
		String categoriesName = request.getParameter("categoriesName");
		String categoriesDesc = request.getParameter("categoriesDesc");
		Categories category = new Categories(categoriesId, categoriesName, categoriesDesc);
		if(category != null) {
			service.insertCategory(category);
			getAllContents(request, response);
		}
	}
	
	/**
	 * 브랜드 등록 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String brandId = request.getParameter("brandsId");
		String brandName = request.getParameter("brandsName");
		String brandDesc = request.getParameter("brandsDesc");
		Brands brand = new Brands(brandId, brandName, brandDesc);
		if(brand != null) {
			service.insertBrand(brand);
			getAllBrands(request, response);
		}
	}
	
	/**
	 * 체형정보 수정 메소드
	 * 선택한 체형아이디를 가져와서 수정페이지로 이동 및 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String bodyId = request.getParameter("id");
		Bodys body = service.getBody(bodyId);
		if(body != null) {
			request.setAttribute("getBody", body);
			request.getRequestDispatcher("updateBodys.jsp").forward(request, response);
		}
	}
	
	/**
	 * 체형정보 수정 메소드
	 * 수정 정보를 입력받아 DB에 수정데이터를 입력시켜줌
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBodys(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String bodyId = request.getParameter("bodysId");
		String bodyName = request.getParameter("bodysName");
		String bodyDesc = request.getParameter("bodysDesc");
		Bodys body = new Bodys(bodyId, bodyName, bodyDesc);
		if(body != null) {
			service.updateBody(body);
			getAllBodys(request, response);
		}
	}
	
	/**
	 * 카테고리 수정 메소드
	 * 선택한 카테고리아이디를 가져와서 수정페이지로 이동 및 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateContents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String categoryId = request.getParameter("id");
		Categories category = service.getCategory(categoryId);
		if(category != null) {
			request.setAttribute("getCategory", category);
			request.getRequestDispatcher("updateContents.jsp").forward(request, response);
		}
	}
	
	/**
	 * 카테고리 수정 메소드
	 * 수정 정보를 입력받아 DB에 수정데이터를 입력시켜줌
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String categoryId = request.getParameter("categoriesId");
		String categoryName = request.getParameter("categoriesName");
		String categoryDesc = request.getParameter("categoriesDesc");
		Categories category = new Categories(categoryId, categoryName, categoryDesc);
		if(category != null) {
			service.updateCategory(category);
			
			getAllContents(request, response);
		}
	}
	
	/**
	 * 브랜드 수정 메소드
	 * 선택한 브랜드아이디를 가져와서 수정페이지로 이동 및 데이터 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String brandsId = request.getParameter("id");
		Brands brand = service.getBrand(brandsId);
		if(brand != null) {
			request.setAttribute("getBrand", brand);
			request.getRequestDispatcher("updateBrands.jsp").forward(request, response);
		}
	}
	
	/**
	 * 브랜드 수정 메소드
	 * 수정 정보를 입력받아 DB에 수정데이터를 입력시켜줌
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBrands(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String brandId = request.getParameter("brandsId");
		String brandName = request.getParameter("brandsName");
		String brandDesc = request.getParameter("brandsDesc");
		Brands brand = new Brands(brandId, brandName, brandDesc);
		if(brand != null) {
			service.updateBrand(brand);
			getAllBrands(request, response);
		}
	}
	
	/**
	 * 체형 정보 삭제 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteBody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String bodyId = request.getParameter("bodysId");
		if(bodyId != null) {
			service.deleteBody(bodyId);
			getAllBodys(request, response);
		}
	}
	
	/**
	 * 카테고리 정보 삭제 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String categoryId = request.getParameter("categoriesId");
		if(categoryId != null) {
			service.deleteCategory(categoryId);
			getAllContents(request, response);
		}
	}
	
	/**
	 * 브랜드 정보 삭제 메소드
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String brandId = request.getParameter("brandsId");
		
		if(brandId != null) {
			service.deleteBrand(brandId);
			getAllBrands(request, response);
		}
	}
	
	/**
	 * 제휴문의 정보 조회 메소드
	 * 들어온 제휴문의에 대한 정보를 모두 출력
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllContacts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		ArrayList<Contacts> contacts = service.getAllContacts();
		if(contacts != null) {
			request.setAttribute("getAllContacts", contacts);
			request.getRequestDispatcher("manageContacts.jsp").forward(request, response);
		}
	}
	
	/**
	 * 제휴문의 등록 메소드
	 * 등록 완료 후 메인페이지로 이동
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void insertContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isAdmin(request, response)) {
			return;
		}
		String contactCorp = request.getParameter("corpName");
		String contactPerson = request.getParameter("corpManager");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String contactTel = phone1+"-"+phone2+"-"+phone3;
		String contactEmail = request.getParameter("email");
		Contacts contact = new Contacts(contactCorp, contactPerson, contactTel, contactEmail, null);
		if(contact != null) {
			service.insertContact(contact);
			response.sendRedirect("index.jsp");
		}
	}
	
	/**
	 * 서비스 카테고리 조회기능
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void serviceCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(isGeneral(request, response));
		if (!isGeneral(request, response)) {
    		return;
    	}
		Service service = new Service();
    	ArrayList<Categories> categories = service.getAllContents();
    	if (categories == null || categories.isEmpty()) {
    		response.sendRedirect("serviceError.jsp");
    		return;
    	}
    	request.setAttribute("categories", categories);
    	request.setAttribute("servicePage", "serviceCategory.jsp");
    	request.getRequestDispatcher("service.jsp").forward(request, response);
    }
	
	/**
	 * 추천 컨텐츠 조회기능 (테이블 변경으로 인한 기능부 제외함 데이터 조회x)
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void serviceContents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!isGeneral(request, response)) {
    		return;
    	}
    	HashMap<String, ArrayList<Brands>> result = new HashMap();
    	ArrayList<Brands> brand = new ArrayList<>();
    	request.setAttribute("result", result);
    	request.setAttribute("servicePage", "serviceContents.jsp");
    	request.getRequestDispatcher("service.jsp").forward(request, response);
    }
    
	/**
	 * 맵생성 페이지 접근기능 (미완성)
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @throws ServletException
	 * @throws IOException
	 */
    protected void serviceMap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (!isGeneral(request, response)) {
    		return;
    	}
    	request.setAttribute("servicePage", "serviceMap.jsp");
    	request.getRequestDispatcher("service.jsp").forward(request, response);
    }
	
	
    /**
	 * <pre>
	 * GET 방식과 POST 방식 한번에 처리하는 메서드
	 * </pre>
	 * 
	 * -전달받은 action에 따라 각각 서비스별로 이행
	 * -서비스를 총괄하는 메서드
	 * 
	 * @param request (HttpServletRequest의 request 객체)
	 * @param response (HttpServletRequest의 response 객체)
	 * @see HttpServlet#process(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isAction(request)) {
			errorHandle(request, response);
			return;
		}
		String action = request.getParameter("action");
		System.out.println(action);
		switch(action) {
		case "index":
			index(request, response);
			break;
		case "signin": 
			signin(request, response);
			break;
		case "postService": 
			postService(request, response);
			break;
		case "login": 
			login(request, response);
			break;
		case "idfind": 
			idfind(request, response);
			break;
		case "pwfind": 
			pwfind(request, response);
			break;
		case "mypage": 
			mypage(request, response);
			break;
		case "update": 
			update(request, response);
			break;
		case "changePw": 
			changePw(request, response);
			break;
		case "manage" :
			manage(request, response);
			break;
		case "allMembers" :
			getAllMembers(request, response);
			break;
		case "allBodys" :
			getAllBodys(request, response);
			break;
		case "allContents" :
			getAllContents(request, response);
			break;
		case "allBrand" :
			getAllBrands(request, response);
			break;
		case "updateMembers" :
			updateMembers(request, response);
			break;
		case "updateUser" :
			updateUser(request, response);
			break;
		case "updateBody" :
			updateBody(request, response);
			break;
		case "updateBodys" :
			updateBodys(request, response);
			break;
		case "insertBody" :
			insertBody(request, response);
			break;
		case "deleteBody" :
			deleteBody(request, response);
			break;
		case "updateContents" :
			updateContents(request, response);
			break;
		case "insertCategory" :
			insertCategory(request, response);
			break;
		case "updateCategory" :
			updateCategory(request, response);
			break;
		case "deleteCategory" :
			deleteCategory(request, response);
			break;
		case "insertBrand" :
			insertBrand(request, response);
			break;
		case "updateBrand" :
			updateBrand(request, response);
			break;
		case "updateBrands" :
			updateBrands(request, response);
			break;
		case "deleteBrand" :
			deleteBrand(request, response);
			break;
		case "contact" :
			insertContact(request, response);
			break;
		case "allContacts" :
			getAllContacts(request, response);
			break;
		case "adminInfo" :
			getAdminInfo(request, response);
			break;
		case "updateAdmin" :
			updateAdmin(request, response);
			break;
		case "serviceCategories":
			serviceCategories(request,response);
			break;
		case "serviceContents":
			serviceContents(request,response);
			break;
		case "serviceMap":
			serviceMap(request,response);
			break;
		case "logout" :
			logout(request,response);
			break;
		default :
			errorHandle(request,response);
			break;
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charser=utf-8");
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
