package model;

public class Room implements IRoom{
    String roomNumber;
    Double price;
    RoomType enumeration;
    public Room(String roomNumber,Double price,RoomType enumeration)
    {
        this.price=price;
        this.roomNumber=roomNumber;
        this.enumeration=enumeration;
    }
    public String getRoomNumber()
    {
        return this.roomNumber;
    }
    public Double getRoomPrice()
    {
        return this.price;
    }
    public RoomType getRoomType()
    {
        return this.enumeration;
    }
    public boolean isFree() {

        return (price==0)?true:false;
    }
    @Override
    public String toString() {
        if(this.isFree())
            return "Room number -- "+roomNumber+" -- "+enumeration+" room -- Free.";
        else
        return "Room number -- "+roomNumber+" -- "+enumeration+" room -- charges Rs "+price+" per night.";
    }
}