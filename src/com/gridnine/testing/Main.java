package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());

        ApplicationContext applicationContext = ApplicationContext.getInstance();
        AviaFlightsFilter flightsWithMoreThanTwoHoursGroundTime = applicationContext.getFilterByName(FlightsWithMoreThanTwoHoursGroundTime.class.getSimpleName());
        System.out.println("Один фильтр:\n" + flightsWithMoreThanTwoHoursGroundTime.filter(flights) + "\n");

        List<AviaFlightsFilter> allAviaFilters = applicationContext.getAviaFlightsFiltersList();
        for (AviaFlightsFilter aviaFilter : allAviaFilters) {
            flights = aviaFilter.filter(flights);
        }
        System.out.println("Все фильтры:\n" + flights);
    }

}
