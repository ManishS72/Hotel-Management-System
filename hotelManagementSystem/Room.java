package com.hotelManagementSystem;

public class Room 
{
  private int roomNumber;
  private String roomType;
  private boolean isAvailable;
  private double price;
  
  public Room(int roomNumber, String roomType,double price )
  {
    this.roomNumber=roomNumber;
    this.roomType=roomType;
    this.isAvailable=true;
    this.price=price;
  }

  public int getRoomNumber()
  {
    return roomNumber;
  }
  public void setRoomNumber(int roomNumber)
  {
    this.roomNumber=roomNumber;
  } 
  public String getRoomType()
  {
    return roomType;
  }
  public void setRoomType(String roomType)
  {
    this.roomType=roomType;
  }
  public boolean getIsAvailable()
  {
    return isAvailable;
  }
  public double getPrice()
  {
    return price;
  }
  public void  setPrice(double price)
  {
    this.price=price;
  }

  public void bookRoom()
  {
    this.isAvailable=false;
  }
  public void releaseRoom()
  {
    this.isAvailable=true;
  }
  public void UpdateRoomDetails(String roomType, double price)
  {
    setRoomType(roomType);
    setPrice(price);
  }

@Override
public String toString() {
    return "Room Number=" + roomNumber + ", roomType=" + roomType + ", isAvailable=" + isAvailable + ", price=" + price;
}

}
