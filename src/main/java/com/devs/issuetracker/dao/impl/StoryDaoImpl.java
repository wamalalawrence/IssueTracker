package com.devs.issuetracker.dao.impl;

import com.devs.issuetracker.dao.AbstractDao;
import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Bug;
import com.devs.issuetracker.model.Story;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

/**
 * Created by wamalalawrence on 15/11/21.
 */

@Repository
public class StoryDaoImpl extends AbstractDao implements GenericDao<Story>
{
    public Story selectById(ObjectId id)
    {
        return (Story)mongoTemplate.findById(id, Story.class);
    }

    public ObjectId insert(Story story) 
    {
        mongoTemplate.insert(story);
        return story.getIssueId();
    }
    
	public List<Story> selectAll() 
	{
		return mongoTemplate.findAll(Story.class);
	}

}

