package com.anjelikabog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.anjelikabog.steps.BaseSteps.getDriver;

public class YandexMainPage {

    @FindBy(className = "services-new__list")
    WebElement topPanel;

    public YandexMainPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void selectService(){
        topPanel.findElement(By.xpath(".//a[@data-id='market']")).click();
    }
}
