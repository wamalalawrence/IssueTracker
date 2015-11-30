package com.devs.issuetracker.dao.impl;

import com.devs.issuetracker.dao.AbstractDao;
import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Bug;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

/**
 * Created by wamalalawrence on 15/11/21.
 */

@Repository
public class BugDaoImpl extends AbstractDao implements GenericDao<Bug>
{
    public Bug selectById(ObjectId id) 
    {
        return (Bug)mongoTemplate.findById(id, Bug.class);
    }

    public ObjectId insert(Bug bug) 
    {
        mongoTemplate.insert(bug);
        return bug.getIssueId();
    }

	public List<Bug> selectAll() 
	{
		return mongoTemplate.findAll(Bug.class);
	}

}
