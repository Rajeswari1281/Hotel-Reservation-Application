package api;

import model.Customer;
import java.util.Calendar;
import model.IRoom;
import model.Reservation;
import service.CustomerService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenuFunctions {
    static Scanner sc=new Scanner(System.in);
    static String now;
    static Date checkIn;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static Date checkOut;
    public static void seeMyReservations()
    {
        System.out.println("Enter your email");
        String email=sc.next();
        Customer c= CustomerService.getCustomer(email);
        if(c!=null)
        {
        Collection<Reservation> res=HotelResource.getCustomerReservations(email);
        if(res.isEmpty())
        {
            System.out.println("You don\'t have any reservations yet.");
        }
        else
        {
            System.out.println("Dear "+c.firstName+" "+c.lastName+".\nThese are your reservations till date.");
            for(Reservation r2:res)
            {
                System.out.println(r2.toString());
            }
        }
        }
        else
        {
            System.out.println("You don\'t have an account with us.We recommend you to create one now.");
        }
    }
    public static void findAndReserveARoom() throws Exception
    {
            checkIn = readCheckIn();
            checkOut = readCheckOut();
            Collection<IRoom> r1=HotelResource.findARoom(checkIn,checkOut);
            if(r1.isEmpty())
            {
                try {
                    Date d = HotelResource.getNearestDate();
                    System.out.println("Sorry no rooms available between " + checkIn.toString().substring(0, 10) + checkIn.toString().substring(23) + " " + checkOut.toString().substring(0, 10) + checkOut.toString().substring(23));
                    System.out.println("The nearest date to obtain a room is " + d.toString().substring(0, 10) + d.toString().substring(23));
                }
                catch (NoSuchElementException ex)
                {
                    System.out.println("No rooms are added yet");
                }
            }
            else{
                System.out.println("Available rooms are : ");
                for(IRoom r:r1)
                {
                    System.out.println(r.toString());
                }
                System.out.println("\nEnter your email to reserve a room.");
                String email= sc.next();
                Customer c=HotelResource.getCustomer(email);
                if(c==null)
                    System.out.println("You don\'t have an account with us. You can create one now.");
                else {
                    System.out.println("Please enter the room number you like to stay in");
                    String roomNo = sc.next();
                    IRoom r = HotelResource.getRoom(roomNo);
                    Reservation r2=HotelResource.bookARoom(email, r, checkIn, checkOut);
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Booked a room successfully. Here are the details of booking.");
                    System.out.println(r2.toString());
                    System.out.println("Thank you. Have a happy stay.");
                }
        }
    }
    public static Date readCheckIn()
    {
        String cIn;
        Date checkIn;
            try {
                cIn = sc.next();
                checkIn = new SimpleDateFormat("dd/MM/yyyy").parse(cIn);
                Date date = new Date();
                now=formatter.format(date).toString();
                if(!isValidCombo(date,checkIn))
                {
               while (!isValidCombo(date,checkIn))
                {
                    System.out.println("Your have entered a past date "+checkIn.toString().substring(0,10)+checkIn.toString().substring(23));
                    System.out.println("Please enter a valid future or present date");
                    cIn=sc.next();
                    checkIn = new SimpleDateFormat("dd/MM/yyyy").parse(cIn);
                    System.out.println("Enter checkout date : ");
                }
                }
                else{System.out.println("Enter checkout date : ");}
            }
            catch (ParseException ex)
            {
                System.out.println("Please enter a valid checkin date");
                return readCheckIn();
            }
            return checkIn;
    }

    static boolean isValidCombo(Date d1,Date d2)
    {
        try {

            if(formatter.format(d2).toString().equals(formatter.format(d1).toString()))
            {
                return true;
            }
            else
            return d1.before(new SimpleDateFormat("dd/MM/yyyy").parse(formatter.format(d2).toString())) ? true:false;
        }
        catch (ParseException ex) {
            System.out.println("Enter valid one");
            return isValidCombo(d1,d2);
        }
    }
    public static Date readCheckOut()
    {
        String cOut;
        Date checkOut;
        try {
            cOut = sc.next();
            checkOut = new SimpleDateFormat("dd/MM/yyyy").parse(cOut);
            while (!isValidCombo(checkIn, checkOut)) {
                System.out.println("Your checkin date is " + checkIn.toString().substring(0,10)+checkIn.toString().substring(23));
                System.out.println("Please enter a valid date after your checkin date.");
                cOut = sc.next();
                checkOut = new SimpleDateFormat("dd/MM/yyyy").parse(cOut);
            }

        }
        catch(ParseException ex)
        {
        System.out.println("Please enter a valid check out date");
        return readCheckOut();
        }
        return checkOut;
    }
    public static void createAnAccount() {
        String email,fname,lname;
        System.out.println("Enter your first name : ");
        fname=sc.next();
        System.out.println("Enter your last name : ");
        lname=sc.next();
        System.out.println("Enter your mail id : ");
        email=sc.next();
        HotelResource.createACustomer(fname, lname, email);
    }
}