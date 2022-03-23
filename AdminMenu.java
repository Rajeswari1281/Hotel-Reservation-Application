package api;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.*;

public class AdminMenu extends AdminMenuFunctions{
    static Scanner sc = new Scanner(System.in);
    public static void  adminMenu() throws Exception{
        AdminMenuFunctions admin=new AdminMenuFunctions();
        while (true) {
            System.out.println("Admin menu");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println("1. See all Customers\n2. See all Rooms\n3. See all Reservations\n4. Add a Room\n5. Back to Main Menu");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            int ch= sc.nextInt();
            switch (ch)
            {
                case 1: {
                    AdminMenuFunctions.seeAllCustomers();
                }
                    break;
                case 2:
                {
                    AdminMenuFunctions.seeAllRooms();
                }
                    break;
                case 3:
                {
                    AdminMenuFunctions.seeAllReservations();
                }
                    break;
                case 4: {
                    admin.addRooms();
                }
                    break;
                case 5:MainMenu.mainMenu();
                default:System.out.println("Enter a valid number between 1 and 5.");
            }
        }
    }
}