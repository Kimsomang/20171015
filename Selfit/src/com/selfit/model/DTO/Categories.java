package com.selfit.model.DTO;

public class Categories {
	private String categoriesId;
	private String categoriesName;
	private String categoriesDesc;
	
	public Categories() {}
	
	public Categories(String categoriesId, String categoriesName) {
		this.categoriesId = categoriesId;
		this.categoriesName = categoriesName;
	}
	
	public Categories(String categoriesId, String categoriesName, String categoriesDesc) {
		this(categoriesId, categoriesName);
		this.categoriesDesc = categoriesDesc;
	}
	
	public String getCategoriesId() {
		return categoriesId;
	}
	public void setCategoriesId(String categoriesId) {
		this.categoriesId = categoriesId;
	}
	public String getCategoriesName() {
		return categoriesName;
	}
	public void setCategoriesName(String categoriesName) {
		this.categoriesName = categoriesName;
	}
	public String getCategoriesDesc() {
		return categoriesDesc;
	}
	public void setCategoriesDesc(String categoriesDesc) {
		this.categoriesDesc = categoriesDesc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(categoriesId);
		builder.append(", ");
		builder.append(categoriesName);
		builder.append(", ");
		builder.append(categoriesDesc);
		return builder.toString();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoriesId == null) ? 0 : categoriesId.hashCode());
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
		if (!(obj instanceof Categories))
			return false;
		Categories other = (Categories) obj;
		if (categoriesId == null) {
			if (other.categoriesId != null)
				return false;
		} else if (!categoriesId.equals(other.categoriesId))
			return false;
		return true;
	}
}
