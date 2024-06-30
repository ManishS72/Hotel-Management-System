package com.hotelManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        HotelManagementSystem hms = new HotelManagementSystem();

        
        hms.addRoom("Single", 3000);
        hms.addRoom("Double", 6000);
        hms.addRoom("Suite", 1000);

       
        hms.addGuest("Manish", "BTM Layout 1st Stage Bangalore", "7250505723", "Manishkr6272@gmail.com");
        hms.addGuest("Vishnu", "BTM Layout 2st Stage Bangalore", "6200630793", "vishnuprakash123@gmail.com");
        hms.addGuest("Bhaskar", "HSR Layout Bangalore", "969398047", "bhaskar123@gmail.com");

        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date checkIn = sdf.parse("2024-07-01");
            Date checkOut = sdf.parse("2024-07-05");

            hms.createBooking(1, 1, checkIn, checkOut);
            hms.createBooking(2, 2, checkIn, checkOut);

            
            hms.generateBill(1);
            hms.generateBill(2);

            
            hms.displayRooms();
            hms.displayGuests();
            hms.displayBookings();
            hms.displayBills();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
