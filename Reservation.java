package model;

import service.ReservationService;

import java.util.Date;

public class Reservation {
    public Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;
    public Reservation(Customer customer,IRoom room,Date checkInDate,Date checkOutDate)
    {
        this.customer=customer;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
    }
    @Override
    public String toString() {
        String c=checkInDate.toString().substring(0,10)+checkInDate.toString().substring(23);
        String c2=checkOutDate.toString().substring(0,10)+checkOutDate.toString().substring(23);
        if(room.isFree())
        return "Customer Name: "+customer.firstName+" "+customer.lastName+"\nEmail : "+customer.email+"\nRoom number : "+room.getRoomNumber()+"\nRoom Type : "+room.getRoomType()+"\nCheck in : "+c+"\nCheck out : "+c2+"\nCharges : Free room";
        else
            return "Customer Name: "+customer.firstName+" "+customer.lastName+"\nEmail : "+customer.email+"\nRoom number : "+room.getRoomNumber()+"\nRoom Type : "+room.getRoomType()+"\nCheck in : "+c+"\nCheck out : "+c2+"\nCharges :"+room.getRoomPrice();
    }
}