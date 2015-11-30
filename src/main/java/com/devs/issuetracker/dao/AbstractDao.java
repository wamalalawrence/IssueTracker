package com.devs.issuetracker.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by wamalalawrence
 */
public abstract class AbstractDao {

    protected MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate template) {
        this.mongoTemplate = template;
    }

    public MongoTemplate getMongoTemplate() {
        return this.mongoTemplate;
    }
}
