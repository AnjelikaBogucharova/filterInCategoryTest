package com.anjelikabog.steps;

import com.anjelikabog.util.TestProperties;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static WebDriver getDriver() {
        return driver;
    }

    protected static WebDriver driver;

    public static Properties property = TestProperties.getInstance().getProperties();

    public static ArrayList<String> parentWindowHandle = new ArrayList<>();


    @Before
    public  void executeBeforeTest() {
        System.setProperty("webdriver.chrome.driver", property.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(property.getProperty("url"));
    }


    @After
    public  void executeAfterTest() {
        driver.quit();
    }

    public static void switchToWindow (){
        String parentWindow = getDriver().getWindowHandle();
        parentWindowHandle.add(parentWindow);
        String childWindow = "";
        for(String handle : getDriver().getWindowHandles()){
            if(!handle.equals(parentWindow) && !parentWindowHandle.contains(handle)) {
                childWindow = handle;
                break;
            }
        }
        getDriver().switchTo().window(childWindow);
    }
}
