package model;

import java.util.regex.Pattern;

public class Customer {
    public String firstName,lastName,email;
   public Customer(String firstName,String lastName,String email)
    {
        String regex_="^(.+)@(.+).(.+)$";
        Pattern email_pattern=Pattern.compile(regex_);
        if(email_pattern.matcher(email).matches()) {
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException("Please enter a valid email address");
    }
    @Override
    public String toString()
    {
        return firstName+" "+lastName+" "+email;
    }
}
