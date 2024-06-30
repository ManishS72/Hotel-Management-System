package com.hotelManagementSystem;

import java.util.Date;

public class Booking {
    private int bookingID;
    private Guest guest;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalAmount;

    public Booking(int bookingID, Guest guest, Room room, Date checkInDate, Date checkOutDate) {
        this.bookingID = bookingID;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateTotalAmount();
    }

    public int getBookingID() {
        return bookingID;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void updateBooking(Date checkInDate, Date checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = calculateTotalAmount();
    }

    public void cancelBooking() {
        room.releaseRoom();
    }

    private double calculateTotalAmount() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        int days = (int) (diff / (1000 * 60 * 60 * 24));
        return days * room.getPrice();
    }

    public String getBookingDetails() {
        return "Booking ID: " + bookingID + ", Guest: " + guest.getName() + ", Room: " + room.getRoomNumber() + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate + ", Total Amount: " + totalAmount;
    }
}
