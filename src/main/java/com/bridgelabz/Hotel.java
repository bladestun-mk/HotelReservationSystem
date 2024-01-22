package com.bridgelabz;
/**
 * The `Hotel` class represents a hotel entity with various attributes such as name, rates, and rating.
 * It is designed to store information about both regular and reward customers' rates for weekdays and weekends.
 * The class also keeps track of the hotel count through a static variable.
 */
public class Hotel {
    // Private member variables to store hotel information
    private String name;
    private int weekdayRateForRegularCustomers, weekendRateForRegularCustomers,
            weekdayRateForRewardCustomers, weekendRateForRewardCustomers, rating;
    // Static variable to keep track of the total number of hotels
    private static int hotelCount = 0;
    /**
     * Constructor to initialize a Hotel object with the provided parameters.
     *
     * @param name                          The name of the hotel.
     * @param weekdayRateForRegularCustomers The weekday rate for regular customers.
     * @param weekendRateForRegularCustomers The weekend rate for regular customers.
     * @param weekdayRateForRewardCustomers  The weekday rate for reward program customers.
     * @param weekendRateForRewardCustomers  The weekend rate for reward program customers.
     * @param rating                        The rating of the hotel.
     */
    public Hotel(String name, int weekdayRateForRegularCustomers, int weekendRateForRegularCustomers,
                 int weekdayRateForRewardCustomers, int weekendRateForRewardCustomers, int rating) {
        this.name = name;
        this.weekdayRateForRegularCustomers = weekdayRateForRegularCustomers;
        this.weekendRateForRegularCustomers = weekendRateForRegularCustomers;
        this.weekdayRateForRewardCustomers = weekdayRateForRewardCustomers;
        this.weekendRateForRewardCustomers = weekendRateForRewardCustomers;
        this.rating = rating;
        hotelCount++;// Increment hotel count upon creation of a new hotel object
    }
    // Getter methods to retrieve information about the hotel
    /**
     * Returns the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the rating of the hotel.
     *
     * @return The rating of the hotel.
     */
    public int getRating() {
        return rating;
    }
    /**
     * Returns the weekday rate for regular customers.
     *
     * @return The weekday rate for regular customers.
     */
    public int getWeekdayRateForRegularCustomers() {
        return weekdayRateForRegularCustomers;
    }
    /**
     * Returns the total number of hotels created.
     *
     * @return The total number of hotels.
     */
    public static int getHotelCount() {
        return hotelCount;
    }
    /**
     * Returns the weekend rate for regular customers.
     *
     * @return The weekend rate for regular customers.
     */
    public int getWeekendRateForRegularCustomers() {
        return weekendRateForRegularCustomers;
    }
    /**
     * Returns the weekday rate for reward program customers.
     *
     * @return The weekday rate for reward program customers.
     */
    public int getWeekdayRateForRewardCustomers() {
        return weekdayRateForRewardCustomers;
    }
    /**
     * Returns the weekend rate for reward program customers.
     *
     * @return The weekend rate for reward program customers.
     */
    public int getWeekendRateForRewardCustomers() {
        return weekendRateForRewardCustomers;
    }
    /**
     * Resets the hotel count to zero. Useful for scenarios where a fresh count is needed.
     */
    public static void resetHotelCount() {
        hotelCount = 0;
    }
}
