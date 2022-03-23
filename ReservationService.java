package service;

import model.IRoom;
import model.Room;
import model.Reservation;
import model.Customer;

import java.util.*;

public  class ReservationService {
    public static HashMap<String,IRoom> rooms=new HashMap<String,IRoom>();
    public static ArrayList<Reservation> reservations=new ArrayList<Reservation>();

    public static void addRoom(Room room) {
            rooms.put(room.getRoomNumber(), room);
            System.out.println(room.toString());
    }
    public static IRoom getARoom(String roomId) {
        return rooms.get(roomId)==null?null:rooms.get(roomId);
    }
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation r=new Reservation(customer,room,checkInDate,checkOutDate);
        reservations.add(r);
        return r;
    }

    public static Collection<IRoom> findRooms(Date checkInDate,Date checkOutDate) {
        if(reservations.isEmpty())
            return rooms.values();
        else
        {
            ArrayList<String> rids=new ArrayList<String>();
            ArrayList<IRoom> r = new ArrayList<IRoom>();
            for(Reservation r1:reservations)
            {
                rids.add(r1.room.getRoomNumber());
            }
            for(String rid:rooms.keySet())
            {
                if(!rids.contains(rid))
                    r.add(getARoom(rid));
            }
            for(Reservation r2:reservations)
                {
                    if(r2.checkOutDate.before(checkInDate) && !(r.contains(r2.room)))
                        r.add(r2.room);
                }
            return r;
        }
    }
    public static Date getNearestDate()
    {
        Date date=new Date();
        Collection<Date> ar=new ArrayList<Date>();
        for(Reservation r:reservations)
        {
            ar.add(r.checkOutDate);
        }
        return (Date)Collections.min(ar);
    }
    public static Collection<Reservation> getCustomerReservation(Customer customer) {
        ArrayList<Reservation> cust=new ArrayList<Reservation>();
        for(Reservation r:reservations) {
            if(r.customer.email.equals(customer.email))
                cust.add(r);
        }
        return cust;
    }
    public static void printAllReservation() {
        int i=1;
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%4s %20s %15s %15s %15s %15s %23s %23s\n", "S.No","Name", "Email", "Room No","Room Type","Room Price","Check In","CheckOut");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for(Reservation r:reservations)
        {
            String c=r.checkInDate.toString().substring(0,10)+r.checkInDate.toString().substring(23);
            String c2=r.checkOutDate.toString().substring(0,10)+r.checkOutDate.toString().substring(23);
            System.out.format("%4s %20s %15s %15s %15s %15s %23s %23s\n",i,r.customer.firstName+" "+r.customer.lastName,r.customer.email,r.room.getRoomNumber(),r.room.getRoomType(),r.room.getRoomPrice(),c,c2);
            i++;
        }
        System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------");
    }
}