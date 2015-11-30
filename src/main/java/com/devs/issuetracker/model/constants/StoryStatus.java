package com.devs.issuetracker.model.constants;

public enum StoryStatus {

	NEW("New"),
	ESTIMATED("Estimated"),
	COMPLETED("Completed");
	
	private final String statusCode;
	
	private StoryStatus(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return statusCode;
	}
	
}
