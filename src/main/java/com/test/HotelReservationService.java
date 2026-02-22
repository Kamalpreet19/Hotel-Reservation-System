package com.test;

import java.util.ArrayList;

public class HotelReservationService {

    private ArrayList<Hotel> hotelList=new ArrayList<>();

    public void addHotel(String name, int weekDayRate, int weekEndRate){
        Hotel hotel=new Hotel(name, weekDayRate, weekEndRate);
        hotelList.add(hotel);
    }

    public String findCheapestHotel(int[] dayTypes) {
        Hotel cheapest = null;
        int minCost = Integer.MAX_VALUE;

        for (Hotel hotel : hotelList) {
            int cost = hotel.calculateTotalCost(dayTypes);
            if (cost < minCost) {
                minCost = cost;
                cheapest = hotel;
            }
        }

        return cheapest.getName() + ", Total Rates: $" + minCost;
    }


}
