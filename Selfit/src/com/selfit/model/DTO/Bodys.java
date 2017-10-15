package com.selfit.model.DTO;

public class Bodys {
	private String bodyId;
	private String bodyName;
	private String bodyDesc;

	public Bodys() {}

	/**
	 * @param bodyId 체형 일련번호
	 * @param bodyName 체형 이름
	 */
	public Bodys(String bodyId, String bodyName) {
		this.bodyId = bodyId;
		this.bodyName = bodyName;
	}

	/**
	 * @param bodyId 체형 일련번호
	 * @param bodyName 체형 이름
	 * @param bodyDesc 체형 상세정보
	 */
	public Bodys(String bodyId, String bodyName, String bodyDesc) {
		this(bodyId, bodyName);
		this.bodyDesc = bodyDesc;
	}

	/**
	 * @return the bodyId
	 */
	public String getBodyId() {
		return bodyId;
	}

	/**
	 * @param bodyId the bodyId to set
	 */
	public void setBodyId(String bodyId) {
		this.bodyId = bodyId;
	}

	/**
	 * @return the bodyName
	 */
	public String getBodyName() {
		return bodyName;
	}

	/**
	 * @param bodyName the bodyName to set
	 */
	public void setBodyName(String bodyName) {
		this.bodyName = bodyName;
	}

	/**
	 * @return the bodyDesc
	 */
	public String getBodyDesc() {
		return bodyDesc;
	}

	/**
	 * @param bodyDesc the bodyDesc to set
	 */
	public void setBodyDesc(String bodyDesc) {
		this.bodyDesc = bodyDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bodyId);
		builder.append(", ");
		builder.append(bodyName);
		builder.append(", ");
		builder.append(bodyDesc);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bodyId == null) ? 0 : bodyId.hashCode());
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
		if (!(obj instanceof Bodys))
			return false;
		Bodys other = (Bodys) obj;
		if (bodyId == null) {
			if (other.bodyId != null)
				return false;
		} else if (!bodyId.equals(other.bodyId))
			return false;
		return true;
	}
}
