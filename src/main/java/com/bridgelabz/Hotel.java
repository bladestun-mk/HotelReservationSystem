package com.bridgelabz;

public class Hotel {
    private String name;
    private int weekdayRateForRegularCustomers;
    private static int hotelCount = 0;

    public Hotel(String name, int weekdayRateForRegularCustomers) {
        this.name = name;
        this.weekdayRateForRegularCustomers = weekdayRateForRegularCustomers;
        hotelCount++;
    }

    public String getName() {
        return name;
    }

    public int getWeekdayRateForRegularCustomers() {
        return weekdayRateForRegularCustomers;
    }

    public static int getHotelCount() {
        return hotelCount;
    }

    public static void resetHotelCount() {
        hotelCount = 0;
    }


}
