package com.devs.issuetracker.model.abstracts;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by wamalalawrence
 * This is just a mapped super class with no corresponding table in the underlying datastore
 */

@MappedSuperclass
public abstract class Issue {

	@Id
    private ObjectId issueId;

	private String title;
	private String description;
	private Date creationDate;
	private String assignedDeveloperId;

    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public ObjectId getIssueId() {
		return issueId;
	}
	public void setIssueId(ObjectId issueId) {
		this.issueId = issueId;
	}

    public String getAssignedDeveloperId() {
        return assignedDeveloperId;
    }

    public void setAssignedDeveloperId(String assignedDeveloperId) {
        this.assignedDeveloperId = assignedDeveloperId;
    }
}
