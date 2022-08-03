package com.indeed.step_definitions;

import com.indeed.utilities.DBUtils;
import com.indeed.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public void teardownScenario(Scenario scenario){
        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDB(){
        DBUtils.createConnection();
    }
    @After ("@db")
    public void teardownDB() {
        DBUtils.destroy();
    }

    @Before("@db2")
    public void setupDB_BookIT(){
        DBUtils.createConnectionBookIT();
    }

    @After ("@db2")
    public void teardownDB_BookIT() {
        DBUtils.destroy();
    }
}
