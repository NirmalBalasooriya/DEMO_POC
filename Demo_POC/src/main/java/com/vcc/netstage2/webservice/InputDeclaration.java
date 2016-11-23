package com.vcc.netstage2.webservice;

public class InputDeclaration {
	
	private String countryCode;
	
	private String id;
	
	//next transit border office code
	private String border_office;
	
	private String country_export_code;
	
	private String good_description;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBorder_office() {
		return border_office;
	}

	public void setBorder_office(String border_office) {
		this.border_office = border_office;
	}

	public String getCountry_export_code() {
		return country_export_code;
	}

	public void setCountry_export_code(String country_export_code) {
		this.country_export_code = country_export_code;
	}

	public String getGood_description() {
		return good_description;
	}

	public void setGood_description(String good_description) {
		this.good_description = good_description;
	}
	
	public String toString(){
		return ":: id:"+id+" next:"+border_office+" dest:"+country_export_code+" descrip:"+good_description;
	}
}
