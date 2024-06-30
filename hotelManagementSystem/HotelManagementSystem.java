package com.hotelManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelManagementSystem {
    private List<Room> rooms;
    private List<Guest> guests;
    private List<Booking> bookings;
    private List<Bill> bills;
    private int roomCounter;
    private int guestCounter;
    private int bookingCounter;
    private int billCounter;

    public HotelManagementSystem() {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        bookings = new ArrayList<>();
        bills = new ArrayList<>();
        roomCounter = 1;
        guestCounter = 1;
        bookingCounter = 1;
        billCounter = 1;
    }

    public void addRoom(String roomType, double price) {
        Room room = new Room(roomCounter++, roomType, price);
        rooms.add(room);
    }

    public void addGuest(String name, String address, String phoneNumber, String email) {
        Guest guest = new Guest(guestCounter++, name, address, phoneNumber, email);
        guests.add(guest);
    }

    public void createBooking(int guestID, int roomNumber, Date checkInDate, Date checkOutDate) {
        Guest guest = findGuestByID(guestID);
        Room room = findRoomByNumber(roomNumber);
        if (guest != null && room != null && room.getIsAvailable()) {
            Booking booking = new Booking(bookingCounter++, guest, room, checkInDate, checkOutDate);
            bookings.add(booking);
            room.bookRoom();
        } else {
            System.out.println("Booking failed: Invalid guest ID, room number, or room not available.");
        }
    }

    public void updateBooking(int bookingID, Date checkInDate, Date checkOutDate) {
        Booking booking = findBookingByID(bookingID);
        if (booking != null) {
            booking.updateBooking(checkInDate, checkOutDate);
        } else {
            System.out.println("Booking update failed: Invalid booking ID.");
        }
    }

    public void cancelBooking(int bookingID) {
        Booking booking = findBookingByID(bookingID);
        if (booking != null) {
            booking.cancelBooking();
            bookings.remove(booking);
        } else {
            System.out.println("Booking cancellation failed: Invalid booking ID.");
        }
    }

    public void generateBill(int bookingID) {
        Booking booking = findBookingByID(bookingID);
        if (booking != null) {
            Bill bill = new Bill(billCounter++, booking);
            bills.add(bill);
        } else {
            System.out.println("Bill generation failed: Invalid booking ID.");
        }
    }

    private Guest findGuestByID(int guestID) {
        for (Guest guest : guests) {
            if (guest.getGuestID() == guestID) {
                return guest;
            }
        }
        return null;
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private Booking findBookingByID(int bookingID) {
        for (Booking booking : bookings) {
            if (booking.getBookingID() == bookingID) {
                return booking;
            }
        }
        return null;
    }

    public void displayRooms() {
        for (Room room : rooms) {
            System.out.println(room.getRoomType());
        }
    }

    public void displayGuests() {
        for (Guest guest : guests) {
            System.out.println(guest.getGuestDetails());
        }
    }

    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking.getBookingDetails());
        }
    }

    public void displayBills() {
        for (Bill bill : bills) {
            System.out.println(bill.getBillDetails());
        }
    }
}
