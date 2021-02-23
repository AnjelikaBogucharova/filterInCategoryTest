package com.anjelikabog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.anjelikabog.steps.BaseSteps.getDriver;
import static com.anjelikabog.steps.BaseSteps.switchToWindow;

public class ProductsPage extends BasePages{

    @FindBy(id = "header-search")
    public WebElement fieldSearch;

    public List<WebElement> getArrayProducts() {
        return getDriver().findElements(By.xpath("//article[contains(@data-autotest-id,'product-snippet')]//h3[@data-zone-name='title']//span"));
    }

    public String getAmountProducts(){
        wait.until(ExpectedConditions.visibilityOf(fieldSearch));
        return String.valueOf(getArrayProducts().size());
    }

    @FindBy(xpath = "//*[contains(@data-apiary-widget-name,'Title')]//h1")
    WebElement titleProduct;

//    @FindBy(xpath = "//article[contains(@data-autotest-id,'product-snippet')]//h3[@data-zone-name='title']//span")
//    List<WebElement> arrayProducts;

    public ProductsPage(){
        PageFactory.initElements(getDriver(), this);
    }

    public void searchProducts(String productName){
        fillField(fieldSearch, productName);
        getDriver().findElement(By.xpath("//div[text()='Найти']/parent::button")).click();
    }

    public void goToElement(){
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElements(By.xpath("//article[contains(@data-autotest-id,'product-snippet')]//h3[@data-zone-name='title']//span")).get(0))).click();
    }

    public String getTextTitle(){
        return titleProduct.getText();
    }

}
