package BankManagemnetSystem;

import java.util.*;

public class Bank {

    public static void main(String[] args) {
        Deposit d = new Deposit();
        Withdraw w[] = new Withdraw[100]; // Array of Withdraw objects (accounts)
        Scanner sc = new Scanner(System.in);

        int ch1, ch2, ch3, ch4, n = 0, i = 0, j, k, flag = 0, mpin, del, an, disp;
        char ans1, ans2;

        do {
            d.Text(); // Show welcome menu (Manager / Customer)
            ch3 = sc.nextInt();

            // ------------------- Manager Section -------------------
            if (ch3 == 1) {
                do {
                    System.out.println("Enter your pin:");
                    mpin = sc.nextInt();

                    if (mpin == 123) {
                        System.out.println("Welcome Back Manager");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Incorrect PIN. Try again");
                        System.out.println();
                    }

                } while (mpin != 123);

                d.menuManager(); // Show manager menu
                ch4 = sc.nextInt();

                switch (ch4) {
                    case 1: // Delete account
                        if (n == 0) {
                            System.out.println("Add Account Holder data First");
                        } else {
                            System.out.println("Enter account number of client to be deleted:");
                            del = sc.nextInt();
                            for (j = 0; j <= n - 1; j++) {
                                if (w[j].search(del)) {
                                    flag = 1;
                                    // Shift array elements left after deletion
                                    for (k = j; k <= n - 2; k++) {
                                        w[k] = w[k + 1];
                                    }
                                    n--;
                                    break;
                                }
                            }
                        }

                        if (flag == 1) {
                            System.out.println("Account Holder data has been deleted");
                            flag = 0;
                        } else
                            System.out.println("Account Holder data does not exist");
                        break;

                    case 2: // Display account
                        System.out.println("Enter account number whose data is to be displayed:");
                        disp = sc.nextInt();
                        for (j = 0; j <= n - 1; j++) {
                            if (w[j].search(disp)) {
                                w[j].displayData(); // FIXED: use w[j], not w[i]
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 0) {
                            System.out.println("Account Holder data does not exist");
                        }
                        flag = 0;
                        break;

                    case 3: // Exit
                        System.out.println("Thank you! Have a Good day!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            // ------------------- Customer Section -------------------
            else if (ch3 == 2) {
                do {
                    d.menuCustomer(); // Show customer menu
                    ch1 = sc.nextInt();

                    switch (ch1) {
                        case 1: // Create new account
                            n++;
                            w[i] = new Withdraw();
                            w[i].accDetails();
                            i++;
                            break;

                        case 2: // Banking operations
                            System.out.println("Enter account number:");
                            an = sc.nextInt();
                            flag = 0;

                            for (j = 0; j <= n - 1; j++) {
                            	if (w[j].search(an)) {
                            	    flag = 1;
                            	    if (w[j].enterPin()) {   // assume enterPin() returns true if correct
                            	        do {
                            	            d.menu2(); // Banking menu
                            	            System.out.println("\nEnter your choice:");
                            	            ch2 = sc.nextInt();

                            	            switch (ch2) {
                            	                case 1:
                            	                    w[j].checkBal();
                            	                    break;
                            	                case 2:
                            	                    w[j].withdraw();
                            	                    break;
                            	                case 3:
                            	                    w[j].deposit();
                            	                    break;
                            	                case 4:
                            	                    System.out.println("Thank You! Have A Good Day!");
                            	                    break;
                            	                default:
                            	                    System.out.println("Incorrect option. Try again.");
                            	            }
                            	        } while (ch2 != 4);
                            	    } else {
                            	        System.out.println("Incorrect PIN. Returning to main menu.");
                            	    }
                            	    break;
                            	}
                            }
                            if (flag == 0) {
                                System.out.println("Account does not exist");
                                System.out.println();
                            }
                            break;

                        case 3: // Display account data
                            System.out.println("Enter account number whose data is to be displayed:");
                            disp = sc.nextInt();
                            flag = 0;
                            for (j = 0; j <= n - 1; j++) {
                                if (w[j].search(disp)) {
                                    w[j].displayData();
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 0)
                                System.out.println("Account Holder Data Does Not Exist.");
                            break;

                        case 4: // Exit
                            System.out.println("Thank You! Have A Good Day!");
                            break;

                        default:
                            System.out.println("Incorrect option. Try Again.");
                            break;
                    }

                } while (ch1 != 4);
            }

            // ------------------- Invalid Choice -------------------
            else {
                System.out.println("Incorrect Option. The Program Has Been Terminated.");
            }

            // Ask if user wants to continue
            System.out.println("Would you like to perform another operation? (Y/N)");
            ans2 = sc.next().charAt(0);

            if (ans2 != 'y' && ans2 != 'Y') {
                System.out.println("Thank You For Using The System! Have A Great Day!");
            }

        } while (ans2 == 'y' || ans2 == 'Y');
    }
}
