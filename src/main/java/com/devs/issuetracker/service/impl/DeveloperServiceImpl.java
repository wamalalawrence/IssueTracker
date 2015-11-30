package com.devs.issuetracker.service.impl;

import com.devs.issuetracker.dao.GenericDao;
import com.devs.issuetracker.model.Developer;
import com.devs.issuetracker.service.GenericService;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

/**
 * Created by wamalalawrence
 */
@Service
public class DeveloperServiceImpl implements GenericService<Developer>
{
    private static final Logger logger = Logger.getLogger(DeveloperServiceImpl.class);
    protected GenericDao dao;

    @Override
    public ObjectId add(Developer developer) {
        logger.debug("Adding a new Developer instance");
        return dao.insert(developer);
    }

    public Developer get(ObjectId id) {
        Developer developer = (Developer) dao.selectById(id);
        if(logger.isInfoEnabled()){
        	logger.info(developer.toString());
        }
		return developer;
    }
    
    public List<Developer> getAll() {
		return dao.selectAll();
	}

// dao getters and setters
    public GenericDao getDao() {
        return dao;
    }

    public void setDao(GenericDao dao) {
        this.dao = dao;
    }

}
