package com.anjelikabog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.anjelikabog.steps.BaseSteps.getDriver;


public class FilterPage extends BasePages{

    @FindBy(xpath = "//*[contains(text(),'Цена')]/parent::button/parent::div//div[@data-prefix='от']/input")
    public WebElement priceFrom;

    public FilterPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void showList(){
        executor.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//div[contains(@class,'_2k6')]//span[text()='Показать ещё']")));
    }

    public void getMaker(String maker){
        executor.executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//*[@value='" + maker + "']/parent::label")));
    }

    public void goToFilters(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Все фильтры']"))).click();
    }

    public void fillField(String field, String value){
        if(field.contains("Цена от")) fillField(priceFrom, value);
        else if(field.contains("Производитель")) {
            getMaker(value);
        }
        else throw new AssertionError("Поле '" + field + "' не доступно для фильтра");
    }

    public void showProducts(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Показать')]"))).click();
    }


}
