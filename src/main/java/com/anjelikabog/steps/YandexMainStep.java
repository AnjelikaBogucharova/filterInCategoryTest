package com.anjelikabog.steps;

import com.anjelikabog.pages.YandexMainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static com.anjelikabog.steps.BaseSteps.switchToWindow;

public class YandexMainStep {
    YandexMainPage yandexMainPage = new YandexMainPage();

    @Step("Переходим в сервис Яндекс.Маркет")
    public void selectServiceMarket(){
        yandexMainPage.selectService();
        switchToWindow();
    }
}
