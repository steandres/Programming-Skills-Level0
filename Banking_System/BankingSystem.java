package Banking_System;
import java.util.Scanner;

/*
* 1. Create an online banking system with the following features:

 * Users must be able to log in with a username and password.
 * If the user enters the wrong credentials three times, the system must lock them out.
 * The initial balance in the bank account is $2000.
 * The system must allow users to deposit, withdraw, view, and transfer money.
 * The system must display a menu for users to perform transactions.   2.
* */
public class BankingSystem {
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {


        String username = "";
        String password = "";

        String validUser = "test101";
        String validPassword = "1234";

        username = testName(validUser);
        password = testPassword(validPassword);

        if(username.equals(validUser) & password.equals(validPassword)){
            System.out.println("You are now in the system 👍");
            double bankAccount = 2000;
            double newValue = 0;
            byte option = 0;

            do{
                System.out.println("Menu ");
                System.out.println("Select one of the next options: ");
                System.out.println("1- Deposit");
                System.out.println("2- Withdraw");
                System.out.println("3- View");
                System.out.println("4- Option");

                option = read.nextByte();

                switch(option){
                    case 1:
                        newValue = deposit(bankAccount);
                        break;

                    case 2:
                        //withdraw
                        break;

                    case 3:
                        viewAccount(newValue);
                        break;

                    case 4:
                        option = 4;
                        break;

                    default:
                        System.out.println("choose a number between 1-4");
                }
            }while(option != 4);

        }else{
            System.out.println("Sorry, but it seams you are not user of this system 🤔");
        }

        System.out.println("Thanks for using our services 🤗");

    }

    public static String testName(String validUser){

        byte tryUser = 0;
        String username = "";

        while( tryUser < 3 ){

            if(tryUser == 0){
                System.out.println("Please, Introduce your username: ");
                username = read.nextLine();
            }else{
                System.out.println("Incorrect");
                System.out.println("Please, Introduce your username: ");
                username = read.nextLine();
            }

            tryUser++;
            if( username.equals(validUser)){
                    tryUser = 3;
                }
            }
            return username;
    }

    public static String testPassword(String validPassword){

        byte tryPassword = 0;

        String password = "";

        while( tryPassword < 3 ){

            if(tryPassword == 0){
                System.out.println("Please, Introduce your password: ");
                password = read.nextLine();
            }else{
                System.out.println("Incorrect");
                System.out.println("Please 🙏, Introduce your password: ");
                password = read.nextLine();
            }

            tryPassword++;
            if( password.equals(validPassword)){
                tryPassword = 3;
            }
        }
        //read.close();
        return password;
    }

    public static double deposit( double bankAccount){
        double newValue = 0;
        double actualValue = 0;
        System.out.println("How much do you want to deposit");
        newValue = read.nextDouble();
        if(newValue > bankAccount){
            System.out.println("You cannot do this transaction.");
            actualValue = bankAccount;
        }else{
            actualValue = bankAccount - newValue;
        }
        return actualValue;
    }

    public static void viewAccount( double money){
        System.out.println("You got "+money+" in your bank account");
    }

}
