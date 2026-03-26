package model;
import java.util.*;
import java.time.LocalDateTime;
public class Account {
    private String accountNumber; //encapsulation
    private String name;
    private double balance;
    private List<Transaction> transactions;//keep track of each transaction
    //constructor
    public Account(String accountNumber, String name){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance=0;
        transactions = new ArrayList<>();
    }
    public boolean deposit(double amount){//deposit to current bank account
        if(amount>0){
            balance+=amount;
            transactions.add(new Transaction(//log transactions
                    "DEPOSIT",
                    amount,
                    LocalDateTime.now().toString(),
                    "Cash deposit"
            ));
            return true;
        }else {
            return false;
        }
    }
    public boolean withdraw(double amount){//withdraw from current bank account
        if(amount>0 && amount<=balance){
            balance-=amount;
            transactions.add(new Transaction(//log transactions
                    "WITHDRAW",
                    amount,
                    LocalDateTime.now().toString(),
                    "Cash withdraw"
            ));
            return true;
        }else{
            return false;
        }
    }
    //getters to access private variables
    public double getBalance(){
        return balance;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getName(){
        return name;
    }
    public List<Transaction> getTransactions(){
        return Collections.unmodifiableList(transactions);//better for security
    }
}
