package BankManagemnetSystem;
import java.util.*;
public class Account {
	//instance variables
	protected float bal,with,dep;
	protected int accno,areaCode;
	//method to get balence
	public void enterBal() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter balance:");
		bal=sc.nextInt();
	}
}
