package com.devs.issuetracker.service.impl;

import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Developer;
import com.devs.issuetracker.model.Story;
import com.devs.issuetracker.service.GenericService;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * Created by wamalalawrence on 15/11/21.
 */

@Service
public class StoryServiceImpl implements GenericService<Story>
{
    private static final Logger logger = Logger.getLogger(StoryServiceImpl.class);
    protected GenericDao dao;

    @Override
    public ObjectId add(Story story) {
        logger.debug("Adding a new Story instance");
        return dao.insert(story);
    }

    public Story get(ObjectId id) {
        return (Story) dao.selectById(id);
    }
    
    public List<Story> getAll() {
		return dao.selectAll();
	}

    //setters and getters
    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }
}

