package api;

import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.*;

public class AdminMenuFunctions extends AdminResource{
    static Scanner s=new Scanner(System.in);
    double price=0;
    static Character ch2;
    protected static void seeAllCustomers() {
        int i=0;
        System.out.println("Here is the data of Customers.\n");
        System.out.println("---------------------------------------------");
        Collection<Customer> c = AdminResource.getAllCustomers();
        for (Customer c2 : c) {
            System.out.println(i+".\t"+c2.toString());
        }
        System.out.println("---------------------------------------------");
    }
    protected static void seeAllRooms()
    {
        System.out.println("Available rooms and details are\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Collection<IRoom> r=AdminResource.getAllRooms();
        for(IRoom r2:r)
            System.out.println(r2.toString());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    void oneMoreRoom()
    {
        System.out.println("Enter a valid letter y for yes n for no");
        ch2 = s.next().charAt(0);
        if(!(ch2.equals('y')|| ch2.equals('Y') && ch2.equals('N')||ch2.equals('n'))) {
            oneMoreRoom();
        }
        else
        {
            return;
        }
    }
    void readPrice()
    {
        try {
            System.out.println("Enter price per night : ");
            price = Double.parseDouble(s.next());
        }
        catch(Exception ex) {
            System.out.println("Please enter a valid value as price");
            readPrice();
        }
    }
    protected static void seeAllReservations()
    {
        System.out.println("Reservations till date : ");
        AdminResource.displayAllReservations();
    }
    protected  void addRooms()
    {
        //Scanner sc=new Scanner(System.in);
        List<IRoom> room=new ArrayList<IRoom>();
        do{
            System.out.println("Enter Room number : ");
            String roomNo = s.next();
            System.out.println("Provide type of room 1->Single 2->Double ");
            int type = s.nextInt();
            readPrice();
            RoomType t;
            t = (type == 1) ? RoomType.SINGLE : RoomType.DOUBLE;
            Room r=new Room(roomNo,price,t);
            room.add(r);
            System.out.println("Type \'y\' to add one more room or \'n\' to stop");
            ch2=s.next().charAt(0);
            if(!(ch2.equals('y')|| ch2.equals('Y') && ch2.equals('N')||ch2.equals('n'))) {
                oneMoreRoom();
            }
        }while(ch2.equals('y') || ch2.equals('Y'));
        System.out.println("You have added following rooms : \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        AdminResource.addRoom(room);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}