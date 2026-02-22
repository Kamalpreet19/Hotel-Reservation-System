package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

        @Test
        public void testFindCheapestBestRatedHotel() {
            HotelReservationService service = new HotelReservationService();

            service.addHotel("Lakewood", 110, 90, 3);
            service.addHotel("Bridgewood", 100, 100, 4); // cheapest + higher rating
            service.addHotel("Ridgewood", 220, 150, 5);

            int[] days = {1, 1};

            String expected = "Bridgewood, Rating: 4 and Total Rates: $200";

            String actual = service.findCheapestBestRatedHotel(days);

            assertEquals(expected, actual); // Test check
        }

        @Test
        public void testFindCheapestBestRatedHotel_SingleHotel() {
            HotelReservationService service = new HotelReservationService();

            service.addHotel("Lakewood", 110, 90, 3);
            service.addHotel("Bridgewood", 150, 50, 4);
            service.addHotel("Ridgewood", 220, 150, 5);

            int[] days = {1, 1};

            String expected = "Lakewood, Rating: 3 and Total Rates: $220";
            String actual = service.findCheapestBestRatedHotel(days);

            assertEquals(expected, actual);
        }
    }


