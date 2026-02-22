package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelReservationService {
    List<Hotel> hotels = new ArrayList<>();

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }


    public String findBestRatedHotel(int[] dayTypes) {
        return hotels.stream()
                .max(Comparator.comparingInt(h -> h.rating))
                .map(h -> formatResult(h, h.calculateCost(dayTypes, false)))
                .orElse("No hotels available");
    }


    public String findCheapestHotelForRewardCustomer(int[] dayTypes) {
        return hotels.stream()
                .min(Comparator.comparingInt((Hotel h) -> h.calculateCost(dayTypes, true))
                        .thenComparing(Comparator.comparingInt(h -> -h.rating)))
                .map(h -> formatResult(h, h.calculateCost(dayTypes, true)))
                .orElse("No hotels available");
    }

    private String formatResult(Hotel hotel, int total) {
        return hotel.name + ", Rating: " + hotel.rating + " and Total Rates: $" + total;
    }
}