package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

    @Test
    public void testFindBestRatedHotel() {
        HotelReservationService service = new HotelReservationService();

        service.addHotel("Lakewood", 110, 90, 3);
        service.addHotel("Bridgewood", 150, 50, 4);
        service.addHotel("Ridgewood", 220, 150, 5);

        int[] days = {1, 1};

        String expected = "Ridgewood, Rating: 5 and Total Rates: $440";
        String actual = service.findBestRatedHotel(days);

        assertEquals(expected, actual);
    }
}


