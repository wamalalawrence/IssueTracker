package com.devs.issuetracker.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.devs.issuetracker.model.abstracts.Issue;
import com.devs.issuetracker.model.constants.Priority;

/**
 * 
 * @author wamalalawrence
 *
 */

@Document
public class Bug extends Issue implements Serializable{

	private Priority priority;
	private String status;

    public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bug [" + '\'' +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", creationDate=" + getCreationDate() + '\'' +
                ", assignedDeveloperId=" + getAssignedDeveloperId()  + '\'' +
                ", priority=" + priority + '\'' +
                ", issueId=" + getIssueId() + '\'' +
                ", status=" + status + "]";
	}
	
	

}
