package com.bridgelabz;

import java.util.*;
/**
 * The `Booking` class serves as the entry point for the hotel booking application. It takes user input for
 * check-in and check-out dates and utilizes the HotelReservationMain class to find the cheapest and best-rated hotel
 * for the specified date range. It then displays relevant information about the selected hotel, including its name,
 * rating, and the total cost for reward program customers.
 */
public class Booking {
    /**
     * The main method of the booking application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Scanner for user input
        Scanner sc = new Scanner(System.in);
        // Create an instance of HotelReservationMain to handle hotel-related operations
        HotelReservationMain hotelReservation = new HotelReservationMain();
        System.out.println("Select Customer Type:");
        System.out.println("1 for Regular Customer");
        System.out.println("2 for Reward Customer");
        int customerType = sc.nextInt();
        sc.nextLine();
        // Prompt the user to enter the check-in date
        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = sc.nextLine();
        // Prompt the user to enter the check-out date
        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = sc.nextLine();
        // Find the cheapest and best-rated hotel for the specified date range
        Hotel cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDateString, endDateString,customerType);
        // Display information about the selected hotel, if available
        if (cheapestBestRatedHotel != null) {
            System.out.println("Cheapest Best Rated Hotel: " + cheapestBestRatedHotel.getName());
            System.out.println("Rating: " + cheapestBestRatedHotel.getRating());
            System.out.println("Total Reward Cost: " +
                    hotelReservation.calculateTotalCost(startDateString, endDateString, cheapestBestRatedHotel,customerType));
        } else {
            // Inform the user if no hotels are available for the specified date range
            System.out.println("No hotels available for the specified date range.");
        }
        // Close the Scanner to avoid resource leakage
        sc.close();
    }
}

