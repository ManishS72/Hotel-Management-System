package com.hotelManagementSystem;

public class Bill {
    private int billID;
    private Booking booking;
    private double amount;
    private boolean paymentStatus;

    public Bill(int billID, Booking booking) {
        this.billID = billID;
        this.booking = booking;
        this.amount = booking.getTotalAmount();
        this.paymentStatus = false; // Payment is pending by default
    }

    public int getBillID() {
        return billID;
    }

    public Booking getBooking() {
        return booking;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void processPayment() {
        this.paymentStatus = true;
    }

    public String getBillDetails() {
        return "Bill ID: " + billID + ", Booking ID: " + booking.getBookingID() + ", Amount: " + amount + ", Payment Status: " + (paymentStatus ? "Paid" : "Pending");
    }
}
