package ui;
import model.*;
import service.Bank;
import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        while(true){
            //All options before login
            System.out.println("1. Create an account");
            System.out.println("2. Log into an account");
            System.out.println("3. Exit");
            int opt = sc.nextInt();
            sc.nextLine();
            if(opt == 1){//account creation
                System.out.println("Enter your name: ");
                String n1 = sc.nextLine();
                System.out.println("Enter a account number");
                String n2 = sc.nextLine();
                if(bank.createAccount(n2, n1)){
                    System.out.println("Account created successfully.");
                } else {
                    System.out.println("Account number already exists, creation unsuccessful.");
                }
            }
            else if (opt == 2) {//account login
                System.out.println("What is your account num?");
                String num = sc.nextLine();

                if(bank.login(num)){
                    System.out.println("Login Successful!");
                    while(true){//rest of app after login
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. View Transactions");
                        System.out.println("5. Logout");
                        //each option while logged in
                        int option = sc.nextInt();

                        Account current = bank.getCurrentAccount();//so you can reference the account you've logged into
                        if(option == 1){
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            sc.nextLine();
                            if(current.deposit(amt)){
                                System.out.println("Deposit successful");
                            }else{
                                System.out.println("Deposit unsuccessful; amount must be > 0");
                            }
                        }
                        else if(option == 2){
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            if(current.withdraw(amt)){
                                System.out.println("Withdraw successful");
                            }else{
                                System.out.println("Withdraw unsuccessful; insufficient funds");
                            }
                        }
                        else if(option == 3){
                            System.out.println("Balance: " + current.getBalance());
                        } else if (option == 4) {
                            for(Transaction t : current.getTransactions()){
                                System.out.println(t);
                            }
                        } else if(option == 5){
                            bank.logout();
                            break;
                        }
                    }
                }
                else{//if account is not found
                    System.out.println("Login unsuccessful.");
                }
            }
            else if(opt == 3){//if exit was chosen
                System.out.println("Program exited.");
                break;
            }
            else{//if user enters invalid choice
                System.out.println("Invalid option.");
            }
        }
    }
}
