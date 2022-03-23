package api;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {
    static Scanner sc = new Scanner(System.in);
    static void mainMenu() throws Exception{
        System.out.println("Welcome to Hotel Phantastic!!");
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. Find and reserve a room\n2. See my reservations\n3. Create an account\n4. Admin\n5. Exit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Enter an option from menu ");
            int choice;
            try {
                choice = Integer.parseInt(sc.next());
                switch (choice) {
                    case 1:
                    {
                        System.out.println("Please ensure your checkin and checkout dates to be in dd/MM/yyyy format eg 10/09/2022\n");
                        System.out.println("Enter checkin date : ");
                        MainMenuFunctions.findAndReserveARoom();
                    }
                    break;
                    case 2:
                    {
                        MainMenuFunctions.seeMyReservations();
                    }
                    break;
                    case 3:
                    {
                        MainMenuFunctions.createAnAccount();
                    }
                    break;
                    case 4:
                    {
                        AdminMenu.adminMenu();
                    }
                    break;
                    case 5:System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter number between 1 and 5.");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Invalid input .Please enter a valid input");
            }

        }
    }
}