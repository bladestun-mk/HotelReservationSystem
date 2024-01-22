package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * The `HotelReservationMain` class is the core of the hotel reservation system. It manages a list of hotels and
 * provides methods for calculating the total cost of stay, finding the cheapest and best-rated hotels for a given
 * date range, and retrieving the list of available hotels.
 */
public class HotelReservationMain {
    // List to store information about available hotels
    private List<Hotel> hotels;
    /**
     * Default constructor initializes the list of hotels with predefined values.
     */
    HotelReservationMain() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel("Lakewood", 110, 90, 80, 80, 3));
        hotels.add(new Hotel("Bridgewood", 150, 50, 110, 50, 4));
        hotels.add(new Hotel("Ridgewood", 220, 150, 100, 40, 5));
    }

    /**
     * Calculates the total cost of stay at a given hotel for the specified date range.
     *
     * @param startDateString The check-in date in DD/MM/YYYY format.
     * @param endDateString   The check-out date in DD/MM/YYYY format.
     * @param hotel           The hotel for which the cost is calculated.
     * @return The total cost of stay at the hotel, or -1 if there's an invalid date format.
     */
    public int calculateTotalCost(String startDateString, String endDateString, Hotel hotel) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);

            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endDate);

            int totalCost = 0;

            while (startCalendar.before(endCalendar) || startCalendar.equals(endCalendar)) {
                int dayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK);
                int rate = (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
                        ? hotel.getWeekendRateForRegularCustomers() : hotel.getWeekdayRateForRegularCustomers();
                totalCost += rate;

                startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return totalCost;
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter dates in DD/MM/YYYY format");
            return -1;
        }
    }
    /**
     * Finds and returns the cheapest and best-rated hotel for the specified date range.
     *
     * @param startDate The check-in date in DD/MM/YYYY format.
     * @param endDate   The check-out date in DD/MM/YYYY format.
     * @return The cheapest and best-rated hotel, or null if no hotels are available.
     */
    public Hotel findCheapestBestRated(String startDate, String endDate) {
        List<Hotel> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .min(Comparator.comparingInt(hotel -> calculateTotalCost(startDate, endDate, hotel)))
                .orElse(null);
    }
    /**
     * Retrieves the list of available hotels.
     *
     * @param startDate The check-in date in DD/MM/YYYY format.
     * @param endDate   The check-out date in DD/MM/YYYY format.
     * @return The list of available hotels.
     */
    private List<Hotel> getAvailableHotels(String startDate, String endDate) {
        return hotels;
    }
    /**
     * Finds and returns the best-rated hotel for the specified date range.
     *
     * @param startDate The check-in date in DD/MM/YYYY format.
     * @param endDate   The check-out date in DD/MM/YYYY format.
     * @return The best-rated hotel, or null if no hotels are available.
     */
    public Hotel findBestRated(String startDate, String endDate) {
        List<Hotel> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }
}
