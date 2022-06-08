package sample.Bills;

import javafx.collections.ObservableList;

import java.awt.*;

public class Bills  {
    private String name;
    private String status;
    private int number;
    private int amount ;

    public Bills(String name,int amount, String status,  int number){
        this.name=name;
        this.amount =amount;
        this.status=status;
        this.number=number;
    }

    public String getName() {
        return name;
    }
    public String getStatus() {
        return status;
    }
    public int getNumber() {
        return number;
    }
    public int getAmount() {
        return amount;
    }




}
