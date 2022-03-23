package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import java.util.Collection;
import java.util.Date;
import service.ReservationService;

public  class HotelResource {

    public static Date getNearestDate()
    {
        return ReservationService.getNearestDate();
    }
    public static Customer getCustomer(String email)
    {
        Customer c1=CustomerService.getCustomer(email);
        return c1;
    }
    public static void createACustomer(String firstName,String lastName,String email)
    {
    CustomerService.addCustomer(firstName,lastName,email);
    }
    public static IRoom getRoom(String roomNumber)
    {
        IRoom r2=ReservationService.getARoom(roomNumber);
        return r2;
    }
    public static Reservation bookARoom(String customerEmail,IRoom room,Date checkInDate,Date checkOutDate)
    {
     Customer c=getCustomer(customerEmail);
     //Reservation r1=ReservationService.reserveARoom(c,room,checkInDate,checkOutDate);
     return ReservationService.reserveARoom(c,room,checkInDate,checkOutDate);
    }
    public static Collection<Reservation> getCustomerReservations(String customerEmail)
    {
        Customer c=getCustomer(customerEmail);
        return ReservationService.getCustomerReservation(c);
    }
    public static Collection<IRoom> findARoom(Date checkIn,Date checkOut)
    {
        return ReservationService.findRooms(checkIn,checkOut);
    }
}
