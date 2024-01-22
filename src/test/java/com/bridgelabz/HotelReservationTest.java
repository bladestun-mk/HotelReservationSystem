package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

    @Test
    public void testFindCheapestBestRated() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        Hotel cheapestBestRatedHotel = hotelReservation.findBestRated(startDate, endDate);
        Assert.assertNotNull(cheapestBestRatedHotel);
        Assert.assertEquals("Ridgewood", cheapestBestRatedHotel.getName());
    }
}

