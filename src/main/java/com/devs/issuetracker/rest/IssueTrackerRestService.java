package com.devs.issuetracker.rest;


import com.devs.issuetracker.model.Developer;
import com.devs.issuetracker.service.GenericService;

import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wamalalawrence
 */

@Controller
@RequestMapping("/")
public class IssueTrackerRestService
{
    static final Logger logger = Logger.getLogger(IssueTrackerRestService.class);

    @Autowired
    GenericService developerService;

    /**
     * Check if service is up
     * @return status String
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody String getStatus()
    {
        String statusMessage = "issuetracker Restful service up and running...";
        if(logger.isDebugEnabled()){
            logger.debug(statusMessage);
        }
        return statusMessage;
    }

    /* Get a single Developer json object from Spring Rest Services */
    @RequestMapping(value = "/developer", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Developer getDeveloper(@RequestBody Developer developer) {
        if(developer != null) {
            ObjectId id = developer.getDeveloperId();
            if(id != null) {
                    developer = (Developer) developerService.get(id);
                    return developer;
            }
        }
        return developer;
    }
    
    /* Add a new developer */
    @RequestMapping(value = "/developer", method = RequestMethod.PUT,
            produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ObjectId addDeveloper(@RequestBody Developer developer) 
    {
    	if(developer != null){
    		ObjectId id = developerService.add(developer);
        	if(id != null) {
        		if(logger.isInfoEnabled()) logger.info("developer added with id: " +id);
        		return id;
        	}
    	}
		return null;
    }
    
    /* Get a list of all developers */
    @RequestMapping(value = "/developers", method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<Developer> getDevelopers() 
    {
    	List<Developer> developers = developerService.getAll();
    	if(logger.isInfoEnabled()) logger.info(developers.size() + " developers found.");
		return developers;
    }
}
