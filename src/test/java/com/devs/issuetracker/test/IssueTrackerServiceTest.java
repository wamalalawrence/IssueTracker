package com.devs.issuetracker.test;

import com.devs.issuetracker.model.Developer;
import com.devs.issuetracker.model.Story;
import com.devs.issuetracker.model.constants.StoryStatus;
import com.devs.issuetracker.service.GenericService;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by wamalalawrence on 15/11/21.
 */
public class IssueTrackerServiceTest extends StartStopMongoDB
{
    private static final Logger logger = Logger.getLogger(IssueTrackerServiceTest.class);
    private GenericService developerService = null;
    private GenericService storyService = null;

    @Before
    public void setUp() throws Exception {
        logger.info("setting up test");
        super.setUp();
        developerService = (GenericService) TestApplicationContext.getInstance().getBean("developerService");
        storyService = (GenericService) TestApplicationContext.getInstance().getBean("storyService");
        //@TODO Run mongo with a test specific .js file to produce initial data state
    }

    @Test
    public void testCreateAndFindDeveloper() throws Exception {

        ObjectId id = null;

        for (int i = 0; i < 3; i++) {
            Developer developer = new Developer();
            developer.setName("Lawrence Wamala" + i);

            id = developerService.add(developer);
            logger.debug("Added developer with id: " + id);
        }

        Developer developerFound = (Developer) developerService.get(id);
        logger.debug("Developer = " + developerFound.toString());
        Assert.assertNotNull(developerFound);
    }

    @Test
    public void testCreateAndFindStory() throws Exception {

        ObjectId id = null;

        Story story = new Story();
        story.setPointVaue(1);
        story.setStatus(StoryStatus.NEW.getStatusCode());
        story.setCreationDate(new Date());
        story.setDescription("Test sory");
        story.setTitle("Automation Testing");
//        story.setAssignedDeveloperId();

        id = storyService.add(story);
        logger.debug("Added Story with id: " + id);

        Story storyFound = (Story) storyService.get(id);
        logger.debug("Story = " + storyFound.toString());
        Assert.assertNotNull(storyFound);
    }

    // TODO:- More tests


}
