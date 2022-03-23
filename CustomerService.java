package service;

import model.Customer;

import java.util.*;

public class CustomerService {
   public static HashMap<String,Customer> customers=new HashMap<String,Customer>();
    static Scanner s=new Scanner(System.in);
    public static void addCustomer(String firstName,String lastName,String email) {
        try {
            Customer d = new Customer(firstName, lastName, email);
            if(customers.containsKey(d.email))
            {
                System.out.println("An account exist with this email "+d.email+"\nwould you like to update your details y/n");
                String s2=s.next();
                if(s2.equals("y")) {
                    customers.put(d.email, d);
                    System.out.println("Your account has been updated successfully!");
                }
            }
            else
            {customers.put(d.email, d);
            System.out.println("Welcome "+d.firstName+" "+d.lastName+"\nYour account has been created successfully");
            }
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getLocalizedMessage());
            String em=s.next();
            addCustomer(firstName,lastName,em);
        }
    }
    public  static Customer getCustomer(String customerEmail) {
        return customers.get(customerEmail)==null?null:customers.get(customerEmail);
    }
    public static Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}