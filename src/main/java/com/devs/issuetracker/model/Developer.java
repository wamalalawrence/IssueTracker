package com.devs.issuetracker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 
 * @author wamalalawrence
 *
 */
@Document
public class Developer implements Serializable {

	@Id
    private ObjectId developerId;

	private String name;

	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ObjectId getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(ObjectId developerId) {
		this.developerId = developerId;
	}

	@Override
	public String toString() {
		return "Developer{" +
				"DeveloperId=" + developerId +
				", name='" + name + '\'' +
				'}';
	}
}
