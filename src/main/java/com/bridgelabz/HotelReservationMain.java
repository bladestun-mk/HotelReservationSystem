package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservationMain {

    Hotel lakewood = new Hotel("Lakewood", 110, 90, 3);
    Hotel bridgewood = new Hotel("Bridgewood", 150, 50, 4);
    Hotel ridgewood = new Hotel("Ridgewood", 220, 150, 5);

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

    public Hotel findCheapest(String startDate, String endDate) {
        Map<Hotel, Integer> hotelCostMap = new HashMap<>();
        hotelCostMap.put(lakewood, calculateTotalCost(startDate, endDate, lakewood));
        hotelCostMap.put(bridgewood, calculateTotalCost(startDate, endDate, bridgewood));
        hotelCostMap.put(ridgewood, calculateTotalCost(startDate, endDate, ridgewood));

        int minCost = hotelCostMap.values().stream().min(Integer::compare).orElse(0);

        List<Hotel> cheapestHotels = new ArrayList<>();

        hotelCostMap.forEach((hotel, cost) -> {
            if (cost == minCost) {
                cheapestHotels.add(hotel);
            }
        });

        return bestRated(cheapestHotels);
    }
    private Hotel bestRated(List<Hotel> hotels) {
        return hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }


}
