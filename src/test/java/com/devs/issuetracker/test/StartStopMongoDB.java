package com.devs.issuetracker.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.devs.issuetracker.test.util.PropertyValueLoader;
/**
 * Created by wamalalawrence
 * Used to start and stop the local MongoDB instance before the test class is executed.
 */
public class StartStopMongoDB
{
    private static final Logger logger = Logger.getLogger(StartStopMongoDB.class);
    static Process p = null;

    @Before
    public void setUp() throws Exception {
        //@Todo Run a test specific .js file to produce initial data state
    }

    @After
    public void tearDown() throws Exception {
        //@Todo you could Drop database here if needed
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
    	
    	String mongoHome = PropertyValueLoader.getPropValue("mongodbHomeDir");
    	String dbDir = PropertyValueLoader.getPropValue("dataDir");
        String[] command = new String[]{mongoHome, "--dbpath", dbDir, "--rest"};

        ProcessBuilder pb = new ProcessBuilder(command);
        p = pb.start();
        logger.debug("Process started with pid: " + p);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        // Stop mongod process
        boolean processClosed = false;

        Thread.sleep(500);
        if (p != null) {
            while (!processClosed) {

                try {
                    p.destroy();
                    processClosed = true;
                    Thread.sleep(500);
                    logger.info(" Process destroyed: " + p.exitValue());
                } catch (IllegalThreadStateException itse) {
                    logger.warn(itse);
                    processClosed = false;
                }
            }
        }
    }

}
