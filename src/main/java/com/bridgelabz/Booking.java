package com.bridgelabz;

import java.util.*;

public class Booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = sc.nextLine();

        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = sc.nextLine();

        HotelReservationMain hotelReservation = new HotelReservationMain();
        Hotel cheapestBestRatedHotel = hotelReservation.findCheapestBestRated(startDateString, endDateString);
        if (cheapestBestRatedHotel != null) {
            System.out.println("Cheapest Best Rated Hotel: " + cheapestBestRatedHotel.getName());
            System.out.println("Rating: " + cheapestBestRatedHotel.getRating());
            System.out.println("Total Reward Cost: " +
                    hotelReservation.calculateTotalCost(startDateString, endDateString, cheapestBestRatedHotel));
        } else {
            System.out.println("No hotels available for the specified date range.");
        }
        sc.close();
    }
}

