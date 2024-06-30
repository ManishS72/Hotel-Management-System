package com.hotelManagementSystem;

public class Guest {
    private int guestID;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Guest(int guestID, String name, String address, String phoneNumber, String email) {
        this.guestID = guestID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getGuestID() {
        return guestID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void updateGuestDetails(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getGuestDetails() {
        return "Guest ID: " + guestID + ", Name: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
