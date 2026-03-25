package service;
import model.Account;
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
}
