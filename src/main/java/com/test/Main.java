package com.test;

public class Main {

        public static void main(String[] args) {
            HotelReservationService service = new HotelReservationService();

            service.addHotel("Lakewood", 110, 90, 3);
            service.addHotel("Bridgewood", 150, 50, 4);
            service.addHotel("Ridgewood", 220, 150, 5);


            int[] days = {1, 1};

            String result = service.findBestRatedHotel(days);
            System.out.println(result);
        }
    }

