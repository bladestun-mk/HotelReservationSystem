package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void testHotelsAdded() {
        // Reset the count before the test to ensure a clean state
        Hotel.resetHotelCount();
        Hotel lakewood = new Hotel("Lakewood", 110,90);
        Hotel bridgewood = new Hotel("Bridgewood", 150,50);
        Hotel ridgewood = new Hotel("Ridgewood", 220,60);
        // Check the count after creating instances
        Assert.assertEquals(3, Hotel.getHotelCount());
    }
    @Test
    public void testCalculateLakewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int lakewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);
        Assert.assertEquals(200, lakewoodCost);
    }

    @Test
    public void testCalculateBridgewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int bridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.bridgewood);
        Assert.assertEquals(200, bridgewoodCost);
    }

    @Test
    public void testCalculateRidgewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int ridgewoodCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.ridgewood);
        Assert.assertEquals(370, ridgewoodCost);
    }
}
