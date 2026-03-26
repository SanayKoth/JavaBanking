package service;
import model.Account;
import model.Transaction;

import java.util.*;

public class Bank {
    private Map<String, Account> accounts;
    private Account currentAccount;
    //constructor
    public Bank(){
        accounts = new HashMap<>();
        currentAccount = null;
    }
    //Make a new account and add to list
    public boolean createAccount(String accountNumber, String name){
        if(accounts.containsKey(accountNumber)){
            return false;
        }
        accounts.put(accountNumber, new Account(accountNumber, name));
        return true;
    }
    //Look for an account within list of accounts
    public Account findAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
    //log into current account
    public boolean login(String accountNumber){
        Account acc = accounts.get(accountNumber);

        if(acc != null){
            currentAccount = acc;
            return true;
        }
        return false;
    }
    //logout of currentAccount
    public void logout(){
        currentAccount = null;
    }
    //Getter for current account
    public Account getCurrentAccount(){
        return currentAccount;
    }
    public Boolean eTransfer(double amt, String targetAccNum){
        Account target = accounts.get(targetAccNum);
        if(currentAccount == null){
            return false;
        } else if (target == null) {
            return false;
        } else if (target == currentAccount){
            return false;
        } else if (amt<0) {
            return false;
        } else if(currentAccount.getBalance() < amt){
            return false; // insufficient funds
        }
        //do the transfer
        currentAccount.withdraw(amt);
        target.deposit(amt);
        String time = java.time.LocalDateTime.now().toString();

        currentAccount.getTransactions().add(
                new Transaction("TRANSFER_OUT", amt, time, "To: " + target.getAccountNumber())
        );

        target.getTransactions().add(
                new Transaction("TRANSFER_IN", amt, time, "From: " + currentAccount.getAccountNumber())
        );
        return true;
    }
}
