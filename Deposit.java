package BankManagemnetSystem;
import java.util.*;
public class Deposit extends Account{
	Scanner sc=new Scanner(System.in);
	//text menu
	public void Text() {
		System.out.println("*****FUN MODE WORLD BANK****");
		System.out.println("Welcome! Please enter your details below:");
		System.out.println("Enter 1 for if you are a manager\n 2 if you are customer");
		System.out.println();
		
	}
	//menu for customer
	public void menuCustomer() {
		System.out.println("Customer Main Menu\n\n Choose One Option To Be Procced");
		System.out.println("1.Add Acccount\n 2.Access Existing Account \n3.Print Account Data\n4.Exit Program");
		System.out.println("Enter your choice:");
		System.out.println();
	}
	//menu to perform operations
	public void menu2() {
		System.out.println("Account Menu\n\n Choose one Option to be proceed");
		System.out.println("1.Check Bank balence\n 2.Withdraw Funds\n3.Deposit Funds \n4.Exit Program");
		
	}
	//menu for manager
	public void menuManager() {
		System.out.println("Manager Main Menu \n\n Choose one option to be proceed");
		System.out.println("1.Delete account\n 2.View Account Data\n3.Exit Program");
		System.out.println("Enter your choice");
		System.out.println();
	}
	
	
}
