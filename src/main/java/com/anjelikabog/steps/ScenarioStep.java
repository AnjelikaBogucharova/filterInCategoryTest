package com.anjelikabog.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioStep {
    YandexMainStep yandexMainStep = new YandexMainStep();
    YandexMarketStep yandexMarketStep = new YandexMarketStep();
    FilterStep filterStep = new FilterStep();
    ProductsStep productsStep = new ProductsStep();

    @When("^Выбрали сервис Яндекс Маркет$")
    public void selectService(){
        yandexMainStep.selectServiceMarket();
    }

    @When("^Выбрали раздел с товарами \"(.+)\"$")
    public void selectMenu(String nameMenu){
        yandexMarketStep.selectMenu(nameMenu);
    }

    @When("^Выбрали категорию товаров \"(.+)\"$")
    public void selectCategory(String nameCategory){
        yandexMarketStep.selectCategory(nameCategory);
    }

    @Then("^Перешли в расширенный поиск$")
    public void goToFilters(){
        filterStep.goToFilters();
    }

    @When("^Раскрыли список производителей$")
    public void showList(){
        filterStep.showList();
    }

    @When("^Установли фильтры$")
    public void fillFilters(DataTable filtersData){
        filtersData.asMap(String.class, String.class).forEach(
                (filter, value)->filterStep.fillFilters(filter,value)
        );
    }

    @Then("^Переходим к результатам фильтра$")
    public void showProducts(){
        filterStep.showResults();
    }

    @Then("^Проверяем, что количество товаров на странице равно \"(.+)\"$")
    public void countProducts(String expectedAmount){
        productsStep.countProducts(expectedAmount);

    }

    @When("^Осуществили поиск товара, по наименованию первого товара из результата фильтрации$")
    public void searchProducts(){
        productsStep.searchProducts();
    }

    @When("^Перешли в первый элемент поиска$")
    public void goToElement(){
        productsStep.goToElement();
    }

    @Then("^Перешли во вкладку$")
    public void switchToWindowProduct(){
        productsStep.switchToWindowProduct();
    }

    @Then("^Проверяем, что наименование товара соответствует наименованию первого товара из результата фильтрации$")
    public void compareNames(){
        productsStep.compareNames();
    }
}
