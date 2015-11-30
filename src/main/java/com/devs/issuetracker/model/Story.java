package com.devs.issuetracker.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.devs.issuetracker.model.abstracts.Issue;

/**
 * 
 * @author wamalalawrence
 *
 */

@Document
public class Story extends Issue implements Serializable{

    private int pointVaue;
	private String status;

	public int getPointVaue() {
		return pointVaue;
	}
	public void setPointVaue(int pointVaue) {
		this.pointVaue = pointVaue;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    @Override
    public String toString() {
        return "Story [ " + '\'' +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", creationDate=" + getCreationDate() + '\'' +
                ", assignedDeveloperId=" + getAssignedDeveloperId() + '\'' +
                ", pointVaue=" + pointVaue + '\'' +
                ", issueId=" + getIssueId() + '\'' +
                ", status=" + status + "]";

    }


}
