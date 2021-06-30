package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class FligtsThatDepartBeforeArrive implements AviaFlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments()
                .stream()
                .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }

    @Override
    public String getFilterName() {
        return FligtsThatDepartBeforeArrive.class.getSimpleName();
    }
}
