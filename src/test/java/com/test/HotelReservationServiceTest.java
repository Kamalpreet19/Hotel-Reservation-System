package com.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

    @Test
    public void testFindBestRatedHotel_NormalCustomer() throws Exception {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5));


        int[] days = {1, 1};

        String expected = "Ridgewood, Rating: 5 and Total Rates: $440";
        String actual = service.findBestRatedHotel(days);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindCheapestHotelForRewardCustomer() throws Exception {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3, 80, 80));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4, 110, 50));
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5, 100, 40));

        int[] days = {1, 1};

        String expected = "Lakewood, Rating: 3 and Total Rates: $160";
        String actual = service.findCheapestHotelForRewardCustomer(days);

        assertEquals(expected, actual);
    }

    @Test
    public void testFindCheapestHotelForRewardCustomer_TieBreakerByRating() throws Exception {
        HotelReservationService service = new HotelReservationService();

        service.addHotel(new Hotel("Lakewood", 110, 90, 3, 80, 80));
        service.addHotel(new Hotel("Bridgewood", 150, 50, 4, 80, 80)); // same reward cost as Lakewood
        service.addHotel(new Hotel("Ridgewood", 220, 150, 5, 100, 40));

        int[] days = {1, 1};


        String expected = "Bridgewood, Rating: 4 and Total Rates: $160";
        String actual = service.findCheapestHotelForRewardCustomer(days);

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidCustomerType() {
        Exception exception = assertThrows(Exception.class, () -> {
            Utils.isRewardCustomer("vip");
        });

        assertEquals("Customer type must be 'regular' or 'reward'", exception.getMessage());
    }

    @Test
    public void testInvalidDateRange() {
        Exception exception = assertThrows(Exception.class, () -> {
            Utils.getDayTypes(5, 3);
        });

        assertEquals("Start day cannot be after end day", exception.getMessage());
    }
}