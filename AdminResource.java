package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.ReservationService;
import service.CustomerService;
import java.util.Collection;
import java.util.List;

public class AdminResource {
    protected static Customer getCustomer(String email)
    {
        return CustomerService.getCustomer(email);
    }
    protected static void addRoom(List<IRoom> rooms)
    {
        for(IRoom ir:rooms)
        ReservationService.addRoom((Room)ir);
    }
    protected static Collection<IRoom> getAllRooms()
    {
        return ReservationService.rooms.values();
    }
    protected static Collection<Customer> getAllCustomers()
    {
        return CustomerService.getAllCustomers();
    }
    protected static void displayAllReservations()
    {
        ReservationService.printAllReservation();
    }
}