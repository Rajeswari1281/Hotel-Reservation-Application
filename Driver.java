package model;

public class Driver {
    public static void main(String...args)
    {
        try {
            Customer customer = new Customer("Rajeswari", "Pasupuleti", "email");
            System.out.println(customer);
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }

    }
}
