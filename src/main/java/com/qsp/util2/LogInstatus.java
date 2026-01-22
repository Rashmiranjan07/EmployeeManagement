package com.qsp.util2;

public enum LogInstatus {
	VALID("valid"),INVALID("invalid");
	private String status;
	private LogInstatus(String status) {
		this.status=status;
	}
	
	public String getValues() {
		return this.status;
	}

}
