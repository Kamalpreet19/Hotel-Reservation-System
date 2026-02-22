package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

    @Test
    public void testFindCheapestHotel() {
        HotelReservationService service = new HotelReservationService();
        service.addHotel("Lakewood", 110, 90);
        service.addHotel("Bridgewood", 150, 50);
        service.addHotel("Ridgewood", 220, 150);

        int[] days = {1, 1};

        String expected = "Lakewood, Total Rates: $220";
        String actual = service.findCheapestHotel(days);

        assertEquals(expected, actual); // This is the test check
    }
}
