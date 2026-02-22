package com.test;

import java.util.ArrayList;

public class HotelReservationService {

    private ArrayList<Hotel> hotelList = new ArrayList<>();


    public void addHotel(String name, int weekDayRate, int weekEndRate, int rating){
        Hotel hotel = new Hotel(name, weekDayRate, weekEndRate, rating);
        hotelList.add(hotel);
    }


    public void addHotel(String name, int weekDayRate, int weekEndRate, int rating,
                         int rewardWeekDayRate, int rewardWeekEndRate){
        Hotel hotel = new Hotel(name, weekDayRate, weekEndRate, rating,
                rewardWeekDayRate, rewardWeekEndRate);
        hotelList.add(hotel);
    }


    public String findBestRatedHotel(int[] dayTypes) {
        if (hotelList.isEmpty()) return "No hotels available";

        Hotel bestHotel = hotelList.get(0);
        for (Hotel hotel : hotelList) {
            if (hotel.getRating() > bestHotel.getRating()) {
                bestHotel = hotel;
            }
        }

        int totalCost = bestHotel.calculateTotalCost(dayTypes);
        return bestHotel.getName() + ", Rating: " + bestHotel.getRating() + " and Total Rates: $" + totalCost;
    }


    public String findCheapestHotelForRewardCustomer(int[] dayTypes) {
        if (hotelList.isEmpty()) return "No hotels available";

        Hotel cheapest = hotelList.get(0);
        int minCost = cheapest.calculateRewardCost(dayTypes);

        for (Hotel hotel : hotelList) {
            int cost = hotel.calculateRewardCost(dayTypes);
            if (cost < minCost) {
                minCost = cost;
                cheapest = hotel;
            } else if (cost == minCost && hotel.getRating() > cheapest.getRating()) {

                cheapest = hotel;
            }
        }

        return cheapest.getName() + ", Rating: " + cheapest.getRating() + " and Total Rates: $" + minCost;
    }
}