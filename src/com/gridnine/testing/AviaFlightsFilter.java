package com.gridnine.testing;

import java.util.List;

public interface AviaFlightsFilter {
    List<Flight> filter(List<Flight> flights);
    String getFilterName();

}
