package com.anjelikabog.steps;

import com.anjelikabog.pages.ProductsPage;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.anjelikabog.steps.BaseSteps.switchToWindow;

public class ProductsStep {
    ProductsPage productsPage = new ProductsPage();
    String firstProduct;


    @Step("Проверяем, что количество товаров на странице 48")
    public void countProducts(String expectedAmount){
        productsPage.checkFillField(expectedAmount, productsPage.getAmountProducts());
    }

    @Step("Осуществляем поиск по наименованию товара, первого из списка отфильтрованных")
    public void searchProducts(){
        firstProduct = productsPage.getArrayProducts().get(0).getText();
        productsPage.searchProducts(firstProduct);
    }

    @Step("Переходим в первый товар по результатам поиска")
    public void goToElement(){
        productsPage.goToElement();
    }

    @Step("Переходим на вкладку")
    public void switchToWindowProduct(){
        switchToWindow();
    }

    @Step("Проверяем, что наименование товара из поиска совпадает с наименованием товара, первого из списка отфильтрованных")
    public void compareNames(){
        productsPage.checkFillField(firstProduct,productsPage.getTextTitle());
    }

}
