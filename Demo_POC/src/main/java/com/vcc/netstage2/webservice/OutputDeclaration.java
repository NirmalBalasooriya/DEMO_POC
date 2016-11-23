package com.vcc.netstage2.webservice;

public class OutputDeclaration {
	
	private String id;
	
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return "id:"+id+" status:"+status;
	}
}
