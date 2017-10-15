package com.selfit.model.DTO;

public class Contacts {
	private String contactCorp;
	private String contactPerson;
	private String contactTel;
	private String contactEmail;
	private String contactDate;
	
	public Contacts() {}
	
	/**
	 * @param contactCorp
	 * @param contactPerson
	 * @param contactTel
	 * @param contactEmail
	 * @param contactDate
	 */
	public Contacts(String contactCorp, String contactPerson, String contactTel, String contactEmail,
			String contactDate) {
		super();
		this.contactCorp = contactCorp;
		this.contactPerson = contactPerson;
		this.contactTel = contactTel;
		this.contactEmail = contactEmail;
		this.contactDate = contactDate;
	}

	/**
	 * @return the contactCorp
	 */
	public String getContactCorp() {
		return contactCorp;
	}

	/**
	 * @param contactCorp the contactCorp to set
	 */
	public void setContactCorp(String contactCorp) {
		this.contactCorp = contactCorp;
	}

	/**
	 * @return the contactPerson
	 */
	public String getContactPerson() {
		return contactPerson;
	}

	/**
	 * @param contactPerson the contactPerson to set
	 */
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	/**
	 * @return the contactTel
	 */
	public String getContactTel() {
		return contactTel;
	}

	/**
	 * @param contactTel the contactTel to set
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}

	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	/**
	 * @return the contactDate
	 */
	public String getContactDate() {
		return contactDate;
	}

	/**
	 * @param contactDate the contactDate to set
	 */
	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(contactCorp);
		builder.append(", ");
		builder.append(contactPerson);
		builder.append(", ");
		builder.append(contactTel);
		builder.append(", ");
		builder.append(contactEmail);
		builder.append(", ");
		builder.append(contactDate);
		return builder.toString();
	}
}
