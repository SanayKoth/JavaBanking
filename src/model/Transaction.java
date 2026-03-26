package model;

public class Transaction {
    private String type; //deposit or withdraw?
    private double amount; //how much was transferred?
    private String timestamp; //when was it transferred?
    private String details;
    //constructor
    public Transaction(String type, double amount, String timestamp, String details){
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.details = details;
    }
    public String toString(){
        return type + " $" + amount + " | " + details + " | " + timestamp;
    }
}
