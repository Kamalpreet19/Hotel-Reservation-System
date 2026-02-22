package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

    @Test
    public void testFindBestRatedHotel_NormalCustomer() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel("Lakewood", 110, 90, 3);
        service.addHotel("Bridgewood", 150, 50, 4);
        service.addHotel("Ridgewood", 220, 150, 5);

        int[] days = {1, 1};

        String expected = "Ridgewood, Rating: 5 and Total Rates: $440";
        String actual = service.findBestRatedHotel(days);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindCheapestHotelForRewardCustomer() {
        HotelReservationService service = new HotelReservationService();


        service.addHotel("Lakewood", 110, 90, 3, 80, 80);
        service.addHotel("Bridgewood", 150, 50, 4, 110, 50);
        service.addHotel("Ridgewood", 220, 150, 5, 100, 40);

        int[] days = {1, 1}; // both weekdays


        String expected = "Lakewood, Rating: 3 and Total Rates: $160";
        String actual = service.findCheapestHotelForRewardCustomer(days);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindCheapestHotelForRewardCustomer_TieBreakerByRating() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel("Lakewood", 110, 90, 3, 80, 80);
        service.addHotel("Bridgewood", 150, 50, 4, 80, 80); // same reward total as Lakewood
        service.addHotel("Ridgewood", 220, 150, 5, 100, 40);

        int[] days = {1, 1};

        String expected = "Bridgewood, Rating: 4 and Total Rates: $160";
        String actual = service.findCheapestHotelForRewardCustomer(days);

        assertEquals(expected, actual);
    }
}