package com.bridgelabz;

public class Hotel {
    private String name;
    private int weekdayRateForRegularCustomers;


    private int weekendRateForRegularCustomers;
    private static int hotelCount = 0;

    public Hotel(String name, int weekdayRateForRegularCustomers, int weekendRateForRegularCustomers) {
        this.name = name;
        this.weekdayRateForRegularCustomers = weekdayRateForRegularCustomers;
        this.weekendRateForRegularCustomers = weekendRateForRegularCustomers;
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

    public int getWeekendRateForRegularCustomers() {
        return weekendRateForRegularCustomers;
    }

    public static void resetHotelCount() {
        hotelCount = 0;
    }


}
