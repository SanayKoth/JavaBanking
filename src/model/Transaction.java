package model;

public class Transaction {
    private String type; //deposit or withdraw?
    private double amount; //how much was transferred?
    private String timestamp; //when was it transferred?
    //constructor
    public Transaction(String type, double amount, String timestamp){
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }
    public String toString(){
        return type + "     $" + amount + " at " + timestamp;
    }
}
