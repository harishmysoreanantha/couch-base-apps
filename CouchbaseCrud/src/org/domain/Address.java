package org.domain;

public class Address {

	private String docType;
	private String city;
	private String country;

	public Address() {
	}

	public Address(String docType, String city, String country) {
		super();
		this.docType = docType;
		this.city = city;
		this.country = country;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [docType=");
		builder.append(docType);
		builder.append(", city=");
		builder.append(city);
		builder.append(", country=");
		builder.append(country);
		builder.append("]");
		return builder.toString();
	}

}
