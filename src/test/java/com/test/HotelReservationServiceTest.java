package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class HotelReservationServiceTest {

    @Test
    public void givenHotelDetails_WhenHotelAdded_ShouldReturnProperCount() {

        HotelReservationService service = new HotelReservationService();

        service.addHotel("Lakewood", 110, 90);

        assertEquals(1, service.getHotelCount());
    }
}
