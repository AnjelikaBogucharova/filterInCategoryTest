package com.anjelikabog.steps;

import com.anjelikabog.pages.FilterPage;
import ru.yandex.qatools.allure.annotations.Step;

public class FilterStep {
    FilterPage filterPage = new FilterPage();

    @Step("Переходим в расширенный фильтр")
    public void goToFilters(){
        filterPage.goToFilters();
    }

    @Step("Выбираем фильтр {0} со значением {1}")
    public void fillFilters(String nameFilter, String value){
        filterPage.fillField(nameFilter, value);
    }

    @Step("Переходим к результатам фильтра")
    public void showResults(){
        filterPage.showProducts();
    }

    @Step("Раскрываем фильтр")
    public void showList(){
        filterPage.showList();
    }
}
