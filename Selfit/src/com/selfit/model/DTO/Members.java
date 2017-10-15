package com.selfit.model.DTO;

public class Members {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberBirth;
	private String memberSex;
	private String memberPhone;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private String memberBody;
	private String memberGrade;
	private String memberBrand;
	private String memberEnt;
	private String memberStatus;
	private String memberUpdate;
	private int memberActcnt;
	
	public Members() {}
	
	/**
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param memberName 이름
	 * @param memberBirth 생년월일
	 * @param memberSex 성별
	 * @param memberPhone 핸드폰 번호
	 * @param memberPost 우편번호
	 * @param memberAddress1 우편번호 주소
	 * @param memberAddress2 상세주소
	 * @param memberBody 체형
	 * @param memberGrade 회원등급
	 */
	public Members(String memberId, String memberPw, String memberName, String memberBirth, String memberSex,
			String memberPhone, String memberPost, String memberAddress1, String memberAddress2, String memberBody,
			String memberGrade) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberSex = memberSex;
		this.memberPhone = memberPhone;
		this.memberPost = memberPost;
		this.memberAddress1 = memberAddress1;
		this.memberAddress2 = memberAddress2;
		this.memberBody = memberBody;
		this.memberGrade = memberGrade;
	}

	/**
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param memberName 이름
	 * @param memberBirth 생년월일
	 * @param memberSex 성별
	 * @param memberPhone 핸드폰 번호
	 * @param memberPost 우편번호
	 * @param memberAddress1 우편번호 주소
	 * @param memberAddress2 상세주소
	 * @param memberBody 체형
	 * @param memberGrade 회원등급
	 * @param memberBrand 선호 브랜드
	 * @param memberEnt 가입일
	 * @param memberStatus 회원상태 (U,B,S,O)
	 * @param memberUpdate 마지막 회원상태 변경일자
	 * @param memberActcnt 회원 활동수
	 */
	public Members(String memberId, String memberPw, String memberName, String memberBirth, String memberSex,
			String memberPhone, String memberPost, String memberAddress1, String memberAddress2, String memberBody,
			String memberGrade, String memberBrand, String memberEnt, String memberStatus, String memberUpdate,
			int memberActcnt) {
		this(memberId, memberPw, memberName, memberBirth, memberSex,
				memberPhone, memberPost, memberAddress1, memberAddress2, memberBody,
				memberGrade);
		this.memberBrand = memberBrand;
		this.memberEnt = memberEnt;
		this.memberStatus = memberStatus;
		this.memberUpdate = memberUpdate;
		this.memberActcnt = memberActcnt;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberBirth
	 */
	public String getMemberBirth() {
		return memberBirth;
	}

	/**
	 * @param memberBirth the memberBirth to set
	 */
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	/**
	 * @return the memberSex
	 */
	public String getMemberSex() {
		return memberSex;
	}

	/**
	 * @param memberSex the memberSex to set
	 */
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}

	/**
	 * @return the memberPhone
	 */
	public String getMemberPhone() {
		return memberPhone;
	}

	/**
	 * @param memberPhone the memberPhone to set
	 */
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	/**
	 * @return the memberPost
	 */
	public String getMemberPost() {
		return memberPost;
	}

	/**
	 * @param memberPost the memberPost to set
	 */
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}

	/**
	 * @return the memberAddress1
	 */
	public String getMemberAddress1() {
		return memberAddress1;
	}

	/**
	 * @param memberAddress1 the memberAddress1 to set
	 */
	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}

	/**
	 * @return the memberAddress2
	 */
	public String getMemberAddress2() {
		return memberAddress2;
	}

	/**
	 * @param memberAddress2 the memberAddress2 to set
	 */
	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}

	/**
	 * @return the memberBody
	 */
	public String getMemberBody() {
		return memberBody;
	}

	/**
	 * @param memberBody the memberBody to set
	 */
	public void setMemberBody(String memberBody) {
		this.memberBody = memberBody;
	}

	/**
	 * @return the memberGrade
	 */
	public String getMemberGrade() {
		return memberGrade;
	}

	/**
	 * @param memberGrade the memberGrade to set
	 */
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}

	/**
	 * @return the memberBrand
	 */
	public String getMemberBrand() {
		return memberBrand;
	}

	/**
	 * @param memberBrand the memberBrand to set
	 */
	public void setMemberBrand(String memberBrand) {
		this.memberBrand = memberBrand;
	}

	/**
	 * @return the memberEnt
	 */
	public String getMemberEnt() {
		return memberEnt;
	}

	/**
	 * @param memberEnt the memberEnt to set
	 */
	public void setMemberEnt(String memberEnt) {
		this.memberEnt = memberEnt;
	}

	/**
	 * @return the memberStatus
	 */
	public String getMemberStatus() {
		return memberStatus;
	}

	/**
	 * @param memberStatus the memberStatus to set
	 */
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	/**
	 * @return the memberUpdate
	 */
	public String getMemberUpdate() {
		return memberUpdate;
	}

	/**
	 * @param memberUpdate the memberUpdate to set
	 */
	public void setMemberUpdate(String memberUpdate) {
		this.memberUpdate = memberUpdate;
	}

	/**
	 * @return the memberActcnt
	 */
	public int getMemberActcnt() {
		return memberActcnt;
	}

	/**
	 * @param memberActcnt the memberActcnt to set
	 */
	public void setMemberActcnt(int memberActcnt) {
		this.memberActcnt = memberActcnt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(memberName);
		builder.append(", ");
		builder.append(memberBirth);
		builder.append(", ");
		builder.append(memberSex);
		builder.append(", ");
		builder.append(memberPhone);
		builder.append(", ");
		builder.append(memberPost);
		builder.append(", ");
		builder.append(memberAddress1);
		builder.append(", ");
		builder.append(memberAddress2);
		builder.append(", ");
		builder.append(memberBody);
		builder.append(", ");
		builder.append(memberGrade);
		builder.append(", ");
		builder.append(memberBrand);
		builder.append(", ");
		builder.append(memberEnt);
		builder.append(", ");
		builder.append(memberStatus);
		builder.append(", ");
		builder.append(memberUpdate);
		builder.append(", ");
		builder.append(memberActcnt);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Members))
			return false;
		Members other = (Members) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
}
