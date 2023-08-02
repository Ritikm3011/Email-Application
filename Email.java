package emailApp;

import java.util.*;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String Email;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private final int defaultPasswordLength = 8;
    private String companySuffix = "xyzcompany.com";

    // Constructor to receive the firstName and lastName
    public Email() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Fist Name: ");
        this.firstName = sc.nextLine();
        System.out.print("Last Name: ");
        this.lastName = sc.nextLine();
       

        // Call a method for department .. it will return the department as String
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // call a method, which create a random password
        this.password = randPasswrod(defaultPasswordLength);
        // System.out.println("password: " + this.password);

        // combine elements to generate email
        this.Email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + "."
                + companySuffix;
        // System.out.println("Email: " + this.Email);

    }

    // Ask for the department
    private String setDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Departments....\n1.Sales\n2.Development\n3.Accounting\n0.None\n");
        System.out.print("Enter Department: ");
        int depChoice = sc.nextInt();

        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Development";
        } else if (depChoice == 3) {
            return "Accounting";
        } else {
            return "";
        }

    }

    // Genrate a random password
    private String randPasswrod(int passLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789abcdefghijklmnopqrstuwxyz!@#$%^&*()_+=-";
        char[] password = new char[passLength];

        for (int i = 0; i < passLength; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set mailbox Capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set the Alternate Email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // change the password
    public void changePassword(String password) {
        this.password = password;
    }

    // get methods
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String showInfo() {
        return ("\nName: " + this.firstName + " " + this.lastName + "\nDepartment: " + this.department + "\nEmail: "
                + this.Email +"\nPassword: "+this.password+ "\nMail Box Capacity: " + this.mailboxCapacity + "MB\n");
    }
}
