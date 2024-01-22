package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void testFindCheapestBestRated() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";
        int regularCustomerType = 1;

        Hotel cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDate, endDate,regularCustomerType);
        Assert.assertNotNull(cheapestBestRatedHotel);
        Assert.assertEquals("Lakewood", cheapestBestRatedHotel.getName());
    }
}

