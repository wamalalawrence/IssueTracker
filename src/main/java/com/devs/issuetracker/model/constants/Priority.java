package com.devs.issuetracker.model.constants;

public enum Priority {

	CRITICAL("Critical"),
	MAJOR("Major"),
	MINOR("Minor");
	
	private final String priority;
	
	Priority(String priority) {
		this.priority = priority;
	}
	
	public String getPriority() {
		return this.priority;
	}
}
