package com.anjelikabog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.anjelikabog.steps.BaseSteps.getDriver;

public class YandexMarketPage extends BasePages{

    @FindBy(xpath = "//div[contains(@data-zone-name, 'menu')]")
    WebElement topMenu;

    public YandexMarketPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void selectMenu(String nameMenu){
        executor.executeScript("arguments[0].click();", topMenu.findElement(By.xpath("//span[contains(text(), '" + nameMenu + "')]")));
    }

    public void selectCategory(String nameCategory){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'_9') and text()='" + nameCategory + "']"))).click();
    }


}
