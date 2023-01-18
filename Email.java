package emailApp;
import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defualtPassword = 8;
    private String department;
    private String email;
    private String companySuffix = "Hood.com";
    private int mailboxCapacity = 500;
    private String alternateEmail;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName; // (this.fistName) refers to the class level variable
        this.lastName = lastName;

        // call a method asking for the department - returns the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);
        this.password = randomPassword(defualtPassword);
        System.out.println("Your password:" + this.password);

        // combain elements to genarate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
        System.out.println("Your email : " + email);
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New employee: " + firstName + "." +" \nDEPARTMENT CODE: \n1 for Sales \n2 for Development\n3 for Accounting\n0 for None\n Enter Department Code:");

        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#";
        char[] password = new char[length];
        for (int i = 0; i < length; i++)
        {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternateEmail
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;

    }

    // change the company suffix
    public void changeCompanySuffix(String companySuffix){
        this.companySuffix = companySuffix;
    }


    // change the password
    public void changePassword(String password){
        this.password = password;
    }


    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }
    public String getCompanySuffix(){
        return companySuffix;
    }
    public String getEmail(){
        return email;
    }

    public String showInfo(){
        return "\nDISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY NAME: " + email +
                "\nMAIL CAPACITY: " + mailboxCapacity + "mb";
    }

}