package com.devs.issuetracker.dao.impl;

import com.devs.issuetracker.dao.AbstractDao;
import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Developer;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by wamalalawrence
 */

@Repository
public class DeveloperDaoImpl extends AbstractDao implements GenericDao<Developer>
{
    public Developer selectById(ObjectId id) 
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("developerId").is(id));
        Developer developer= mongoTemplate.findOne(query,  Developer.class);
        return developer;
    }

    public ObjectId insert(Developer developer) 
    {
        mongoTemplate.insert(developer);
        return developer.getDeveloperId();
    }


	public List<Developer> selectAll() {
		return mongoTemplate.findAll(Developer.class);
	}

}
