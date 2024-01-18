package com.bridgelabz;
import java.util.Scanner;
public class Booking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the check-in date (DD/MM/YYYY): ");
        String startDateString = sc.nextLine();

        System.out.print("Enter the check-out date (DD/MM/YYYY): ");
        String endDateString = sc.nextLine();

        HotelReservationMain hotelReservation = new HotelReservationMain();
        Hotel cheapestHotel = hotelReservation.findCheapest(startDateString, endDateString);

        if (cheapestHotel != null) {
            System.out.println("Cheapest Hotel: " + cheapestHotel.getName());
            System.out.println("Total Cost: " + hotelReservation.calculateTotalCost
                    (startDateString, endDateString, cheapestHotel));
        }
        sc.close();
    }
}

