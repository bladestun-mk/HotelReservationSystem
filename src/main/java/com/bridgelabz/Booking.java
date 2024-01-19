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

        if (cheapAndBestRatedHotels!=null) {
            System.out.println("Cheapest and Best Rated Hotels:");
            System.out.println("Hotel: " + cheapAndBestRatedHotels.getName()+" Rating: " + cheapAndBestRatedHotels.getRating());
            System.out.println("Total Cost: " + hotelReservation.calculateTotalCost(startDateString, endDateString, cheapAndBestRatedHotels));
        }
        sc.close();
    }
}

