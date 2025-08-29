package BankManagemnetSystem;
import java.util.*;

public class Withdraw extends Account {
    // instance variables of user
    protected int dob, pin, mainPin;
    protected String name, fullName, surname;
    Scanner sc = new Scanner(System.in);

    // method to get details
    public void accDetails() {
        System.out.println("Account Holder Details:");
        
        // first name
        System.out.print("First Name: ");
        name = sc.nextLine();
        
        // last name
        System.out.print("Last Name: ");
        surname = sc.nextLine();
        
        // full name
        fullName = name + " " + surname;
        
        // account no
        System.out.print("Account No (5 digits): ");
        accno = sc.nextInt();
        
        // dob
        System.out.print("Enter DOB (DDMMYYYY): ");
        dob = sc.nextInt();
        
        // mainpin = DOB for testing
        mainPin = dob;
        
        // area code
        System.out.print("Area Code: ");
        areaCode = sc.nextInt();
        System.out.println("\nAccount created successfully!\n\n");
    }

    // method to display data
    public void displayData() {
        System.out.println("\n--- Account Holder Details ---");
        System.out.println("Name: " + fullName);
        System.out.println("Account Number: " + accno);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Area Code: " + areaCode);
        System.out.println("Balance: " + bal);
    }

    // method to check balance
    public void checkBal() {
        System.out.println("Your account balance is " + bal);
    }

    // method to withdraw money
    public void withdraw() {
        System.out.print("Enter amount to be withdrawn: ");
        with = sc.nextInt();

        if (with > bal) {
            System.out.println("Insufficient balance! Your balance is " + bal);
        } else if (with > 50000) {
            System.out.println("Error: Prior Notice not submitted (limit 50,000).");
        } else {
            bal = bal - with;
            System.out.println("Rupees " + with + " withdrawn. New Balance = " + bal);
        }
    }

    // method to deposit money
    public void deposit() {
        System.out.print("Enter amount to be deposited: ");
        dep = sc.nextInt();
        bal = bal + dep;
        System.out.println("Deposit successful. New Balance = " + bal);
    }

    // method to enter pin
    public boolean enterPin() {
        System.out.print("Enter your pin: ");
        pin = sc.nextInt();
        if (pin == mainPin) {
            System.out.println("Welcome Back...");
            return true;
        } else {
            System.out.println("Incorrect PIN.");
            return false;
        }
    }

    // method to search account number
    public boolean search(int x) {
        return accno == x;
    }
}
