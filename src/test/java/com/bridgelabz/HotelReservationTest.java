package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {
    @Test
    public void testHotelsAdded() {
        // Reset the count before the test to ensure a clean state
        Hotel.resetHotelCount();
        Hotel lakewood = new Hotel("Lakewood", 110);
        Hotel bridgewood = new Hotel("Bridgewood", 160);
        Hotel ridgewood = new Hotel("Ridgewood", 220);
        // Check the count after creating instances
        Assert.assertEquals(3, Hotel.getHotelCount());
    }
}
