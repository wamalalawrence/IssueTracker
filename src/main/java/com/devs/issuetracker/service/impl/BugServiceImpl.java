package com.devs.issuetracker.service.impl;

import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Bug;
import com.devs.issuetracker.model.Developer;
import com.devs.issuetracker.service.GenericService;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wamalalawrence on 15/11/21.
 */

@Service
public class BugServiceImpl implements GenericService<Bug>
{
    private static final Logger logger = Logger.getLogger(BugServiceImpl.class);
    protected GenericDao dao;

    @Override
    public ObjectId add(Bug bug) {
        logger.debug("Adding a new Bug instance");
        return dao.insert(bug);
    }

    public Bug get(ObjectId id) {
        return (Bug) dao.selectById(id);
    }
    
    public List<Bug> getAll() {
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
