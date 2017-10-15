package com.selfit.model.DTO;

public class Brands {
	private String brandId;
	private String brandName;
	private String brandDesc;

	public Brands() {}

	/**
	 * @param brandId 브랜드 일련번호
	 * @param brandName 브랜드 이름
	 */
	public Brands(String brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}

	/**
	 * @param brandId 브랜드 일련번호
	 * @param brandName 브랜드 이름
	 * @param brandDesc 브랜드 상세정보
	 */
	public Brands(String brandId, String brandName, String brandDesc) {
		this(brandId, brandName);
		this.brandDesc = brandDesc;
	}

	/**
	 * @return the brandId
	 */
	public String getBrandId() {
		return brandId;
	}

	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @return the brandDesc
	 */
	public String getBrandDesc() {
		return brandDesc;
	}

	/**
	 * @param brandDesc the brandDesc to set
	 */
	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(brandId);
		builder.append(", ");
		builder.append(brandName);
		builder.append(", ");
		builder.append(brandDesc);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
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
		if (!(obj instanceof Brands))
			return false;
		Brands other = (Brands) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		return true;
	}
}
