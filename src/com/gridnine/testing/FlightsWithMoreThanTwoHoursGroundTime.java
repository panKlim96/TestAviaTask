package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightsWithMoreThanTwoHoursGroundTime implements AviaFlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> IntStream.range(1, flight.getSegments().size())
                        .mapToLong(i -> flight.getSegments().get(i).getDepartureDate()
                                .minusHours(flight.getSegments().get(i - 1).getArrivalDate().getHour()).getHour())
                        .sum() <= 2)
                .collect(Collectors.toList());
    }

    @Override
    public String getFilterName() {
        return FlightsWithMoreThanTwoHoursGroundTime.class.getSimpleName();
    }
}
