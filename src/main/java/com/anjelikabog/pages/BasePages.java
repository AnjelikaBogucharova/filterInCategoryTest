package com.anjelikabog.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.anjelikabog.steps.BaseSteps.getDriver;
import static junit.framework.TestCase.assertEquals;

public class BasePages {
    Wait<WebDriver> wait = new WebDriverWait(getDriver(),5,1000);
    JavascriptExecutor executor = (JavascriptExecutor)getDriver();

    public void fillField(WebElement elem, String value){
        elem.clear();
        elem.sendKeys(value);
    }

    public void checkFillField(String expectedValue, String receivedValue) {
        assertEquals(String.format("Ожидаемое значение %s не соответствует полученному %s", expectedValue, receivedValue), expectedValue, receivedValue);
    }
}
