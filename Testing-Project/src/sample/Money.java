package sample;

public class Money {
    public static int balance = 1500;
    public boolean canPayBill = false;
    public static int getBalance(){
        return balance;
    }
    public static void purchase(int amount){
        balance-=amount;
    }
    public static void transfer(int amount) {
        balance -=amount;
    }
    public static int AddToBalance(int amount){
        if(amount > 50000){
            System.out.println("Can't add more than 50000");
            return balance;
        }
        else if(amount > 50){
            balance+=amount;
            return balance;
        }
        else {
            System.out.println("Can't add less than 50");
            return balance;
        }

    }

    public static boolean canPurchase(int amount){
        if(amount <= balance){
            return true;}
        else{
            return false;}
    }
    public static boolean canTransfer(int amount){
        if(amount <= balance && amount >= 50){
            return true;
        }
        else{
            return false;
        }
    }

}
