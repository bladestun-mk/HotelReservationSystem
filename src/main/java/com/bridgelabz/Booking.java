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
        Hotel cheapAndBestRatedHotels = hotelReservation.findCheapest(startDateString, endDateString);
        Hotel bestRating = hotelReservation.findBestRated(startDateString, endDateString);

        if (bestRating != null) {
            System.out.println("Best Rated Hotel Is: " + bestRating.getName());
            System.out.println("With Rating: " + bestRating.getRating());
            System.out.println("Total Cost: " + hotelReservation.calculateTotalCost(startDateString, endDateString, bestRating));
        }

        sc.close();
    }
}

