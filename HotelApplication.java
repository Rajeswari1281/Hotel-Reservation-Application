package api;

public class HotelApplication {
    static void hotel() throws Exception
    {
        MainMenu.mainMenu();
    }
    public static void main(String args[])
    {
        try {
            HotelApplication.hotel();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}
