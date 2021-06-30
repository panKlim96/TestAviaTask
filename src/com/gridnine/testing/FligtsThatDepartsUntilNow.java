package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FligtsThatDepartsUntilNow implements AviaFlightsFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream().filter(flight -> flight.getSegments()
                .stream()
                .noneMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
    }

    @Override
    public String getFilterName() {
        return FligtsThatDepartsUntilNow.class.getSimpleName();
    }
}
