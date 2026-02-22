package com.test;

import java.util.ArrayList;

public class HotelReservationService {

    private ArrayList<Hotel> hotelList=new ArrayList<>();

    public void addHotel(String name, int weekDayRate, int weekEndRate){
        Hotel hotel=new Hotel(name, weekDayRate, weekEndRate);
        hotelList.add(hotel);
    }

    public int getHotelCount(){
        return hotelList.size();
    }
}
