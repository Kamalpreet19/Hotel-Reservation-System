package com.test;

import java.util.ArrayList;

public class HotelReservationService {

    private ArrayList<Hotel> hotelList=new ArrayList<>();

    public void addHotel(String name, int weekDayRate, int weekEndRate, int rating){
        Hotel hotel=new Hotel(name, weekDayRate, weekEndRate, rating);
        hotelList.add(hotel);
    }

    public String findCheapestBestRatedHotel(int[] dayTypes) {
        Hotel bestHotel = null;
        int minCost = Integer.MAX_VALUE;

        for (Hotel hotel : hotelList) {
            int cost = hotel.calculateTotalCost(dayTypes);

            if (cost < minCost) {

                minCost = cost;
                bestHotel = hotel;
            } else if (cost == minCost) {

                if (hotel.getRating() > bestHotel.getRating()) {
                    bestHotel = hotel;
                }
            }
        }

        return bestHotel.getName() + ", Rating: " + bestHotel.getRating() + " and Total Rates: $" + minCost;
    }

}
