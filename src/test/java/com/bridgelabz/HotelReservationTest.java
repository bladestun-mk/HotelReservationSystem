package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void testHotelsAdded() {
        // Reset the count before the test to ensure a clean state
        Hotel.resetHotelCount();
        Hotel lakewood = new Hotel("Lakewood", 110, 90, 80,80,3);
        Hotel bridgewood = new Hotel("Bridgewood", 150, 50,110,50, 4);
        Hotel ridgewood = new Hotel("Ridgewood", 220, 60, 100,40,5);
        // Check the count after creating instances
        Assert.assertEquals(3, Hotel.getHotelCount());
    }

    @Test
    public void testCalculateLakewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int lakewoodRegularCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.lakewood);
        Assert.assertEquals(200, lakewoodRegularCost);
    }

    @Test
    public void testCalculateBridgewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int bridgewoodRegularCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.bridgewood);
        Assert.assertEquals(200, bridgewoodRegularCost);
    }

    @Test
    public void testCalculateRidgewoodCost() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        String startDate = "11/9/2020";
        String endDate = "12/9/2020";

        int ridgewoodRegularCost = hotelReservation.calculateTotalCost(startDate, endDate, hotelReservation.ridgewood);
        Assert.assertEquals(370, ridgewoodRegularCost);
    }

    @Test
    public void checkRightRatingAdded() {
        HotelReservationMain hotelReservation = new HotelReservationMain();
        int lakewoodRating = hotelReservation.lakewood.getRating();
        int bridgewoodRating = hotelReservation.bridgewood.getRating();
        int ridgewoodRating = hotelReservation.ridgewood.getRating();
        Assert.assertEquals(3, lakewoodRating);
        Assert.assertEquals(4, bridgewoodRating);
        Assert.assertEquals(5, ridgewoodRating);
    }
    @Test
    public void checkRightRewardRatesAdded(){
        HotelReservationMain hotelReservation = new HotelReservationMain();
        int lakewoodRewardWeekdayRates = hotelReservation.lakewood.getWeekdayRateForRewardCustomers();
        int lakewoodRewardWeekendRates = hotelReservation.lakewood.getWeekendRateForRewardCustomers();
        int bridgewoodRewardWeekdayRates = hotelReservation.bridgewood.getWeekdayRateForRewardCustomers();
        int bridgewoodRewardWeekendRates = hotelReservation.bridgewood.getWeekendRateForRewardCustomers();
        int ridgewoodRewardWeekdayRates = hotelReservation.ridgewood.getWeekdayRateForRewardCustomers();
        int ridgewoodRewardWeekendRates = hotelReservation.ridgewood.getWeekendRateForRewardCustomers();
        Assert.assertEquals(80,lakewoodRewardWeekdayRates);
        Assert.assertEquals(80,lakewoodRewardWeekendRates);
        Assert.assertEquals(110,bridgewoodRewardWeekdayRates);
        Assert.assertEquals(50,bridgewoodRewardWeekendRates);
        Assert.assertEquals(100,ridgewoodRewardWeekdayRates);
        Assert.assertEquals(40,ridgewoodRewardWeekendRates);
    }
}
