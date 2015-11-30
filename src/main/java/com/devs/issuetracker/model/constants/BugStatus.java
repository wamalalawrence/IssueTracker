package com.devs.issuetracker.model.constants;

public enum BugStatus {
	
	NEW("New"),
	VERIFIED("Verified"),
	RESOLVED("Resolved");
	
	private final String statusCode;
	
	private BugStatus(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}

}
