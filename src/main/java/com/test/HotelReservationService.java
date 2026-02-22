package com.test;

import java.util.ArrayList;

public class HotelReservationService {

    private ArrayList<Hotel> hotelList=new ArrayList<>();

    public void addHotel(String name, int weekDayRate, int weekEndRate, int rating){
        Hotel hotel=new Hotel(name, weekDayRate, weekEndRate, rating);
        hotelList.add(hotel);
    }

    public String findCheapestHotel(int[] dayTypes) {
        ArrayList<String> cheapestHotels = new ArrayList<>();
        int minCost = Integer.MAX_VALUE;

        for (Hotel hotel : hotelList) {
            int cost = hotel.calculateTotalCost(dayTypes);

            if (cost < minCost) {

                minCost = cost;
                cheapestHotels.clear();
                cheapestHotels.add(hotel.getName());
            } else if (cost == minCost) {

                cheapestHotels.add(hotel.getName());
            }
        }


        String hotelNames = String.join(" and ", cheapestHotels);
        return hotelNames + ", Total Rates: $" + minCost;
    }


}
