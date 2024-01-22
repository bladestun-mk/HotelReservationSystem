package com.bridgelabz;

public class Hotel {
    private String name;
    private int weekdayRateForRegularCustomers, weekendRateForRegularCustomers,
            weekdayRateForRewardCustomers,weekendRateForRewardCustomers, rating;
    private static int hotelCount = 0;

    public Hotel(String name, int weekdayRateForRegularCustomers, int weekendRateForRegularCustomers,
                 int weekdayRateForRewardCustomers,int weekendRateForRewardCustomers, int rating) {
        this.name = name;
        this.weekdayRateForRegularCustomers = weekdayRateForRegularCustomers;
        this.weekendRateForRegularCustomers = weekendRateForRegularCustomers;
        this.weekdayRateForRewardCustomers = weekdayRateForRewardCustomers;
        this.weekendRateForRewardCustomers = weekendRateForRewardCustomers;
        this.rating = rating;
        hotelCount++;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
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

    public int getWeekdayRateForRewardCustomers() {
        return weekdayRateForRewardCustomers;
    }

    public int getWeekendRateForRewardCustomers() {
        return weekendRateForRewardCustomers;
    }

    public static void resetHotelCount() {
        hotelCount = 0;
    }
}
