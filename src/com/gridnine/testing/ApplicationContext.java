package com.gridnine.testing;

import java.util.*;

public class ApplicationContext {
    /*
    По-хорошему данный лист лучше заполнять с помощью рефлексии, проходя по пакету
    и добавляя все имплементации AviaFlightsFilters в лист. Можно сделать с помощью библиотеки
    Reflections. В стандартной рефлексии такой возможности нет.
    * */
    private static ApplicationContext applicationContext = new ApplicationContext();

    private List<AviaFlightsFilter> aviaFlightsFiltersList = new ArrayList<>(Arrays.asList(
            new FligtsThatDepartsUntilNow(),
            new FligtsThatDepartBeforeArrive(),
            new FlightsWithMoreThanTwoHoursGroundTime()
    ));

    private ApplicationContext(){}

    public static ApplicationContext getInstance(){
        return applicationContext;
    }
    public List<AviaFlightsFilter> getAviaFlightsFiltersList() {
        return aviaFlightsFiltersList;
    }

    public AviaFlightsFilter getFilterByName(String name){
        return aviaFlightsFiltersList.stream()
                                .filter(filter-> filter.getFilterName().equals(name))
                                .findFirst()
                                .get();
    }
}
