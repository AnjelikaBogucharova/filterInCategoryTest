package com.anjelikabog.steps;

import com.anjelikabog.pages.YandexMarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketStep {
    YandexMarketPage yandexMarketPage = new YandexMarketPage();

    @Step("Выбираем раздел {0}")
    public void selectMenu(String nameMenu){
        yandexMarketPage.selectMenu(nameMenu);
    }

    @Step("Выбираем категорию товаров {0}")
    public void selectCategory(String nameCategory){
        yandexMarketPage.selectCategory(nameCategory);
    }
}
