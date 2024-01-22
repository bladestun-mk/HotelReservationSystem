package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservationMain {
    private List<Hotel> hotels;
    HotelReservationMain(){
        hotels = new ArrayList<>();
        hotels.add(new Hotel("Lakewood", 110, 90,80,80, 3));
        hotels.add(new Hotel("Bridgewood", 150, 50,110,50, 4));
        hotels.add(new Hotel("Ridgewood", 220, 150,100,40, 5));
    }

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
    public Hotel findCheapestBestRated(String startDate, String endDate) {
        List<Hotel> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .min(Comparator.comparingInt(hotel -> calculateTotalCost(startDate, endDate, hotel)))
                .orElse(null);
        }

    private List<Hotel> getAvailableHotels(String startDate, String endDate) {
        return hotels;
    }
    public Hotel findBestRated(String startDate, String endDate) {
        List<Hotel> availableHotels = getAvailableHotels(startDate, endDate);
        return availableHotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }
}
