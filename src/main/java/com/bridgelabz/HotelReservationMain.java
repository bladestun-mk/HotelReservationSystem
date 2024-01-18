package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HotelReservationMain {

        Hotel lakewood = new Hotel("Lakewood", 110);
        Hotel bridgewood = new Hotel("Bridgewood", 160);
        Hotel ridgewood = new Hotel("Ridgewood", 220);
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
                int rate = hotel.getWeekdayRateForRegularCustomers();
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
        int lakewoodCost = calculateTotalCost(startDate, endDate, lakewood);
        int bridgewoodCost = calculateTotalCost(startDate, endDate, bridgewood);
        int ridgewoodCost = calculateTotalCost(startDate, endDate, ridgewood);

        if (lakewoodCost <= bridgewoodCost && lakewoodCost <= ridgewoodCost)
            return lakewood;
        else if (bridgewoodCost <= lakewoodCost && bridgewoodCost <= ridgewoodCost)
            return bridgewood;
        else
            return ridgewood;
    }

}
