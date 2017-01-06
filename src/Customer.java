
import java.util.*;
public abstract class Customer {
    public Customer(int S, String N, double w){
        name = N;
        SSN = S;
        weight = w;
        initialWeight = w;
    }
    public void getMembership(){
        double pay = prices[0];
        if(pay > 0){
            //Adds to bill
            bill.add("MEMBERSHIP\t"+ (String.valueOf(pay)));
            paid.add(pay);
            //makes sure that employees get the best of both if they upgrade
            for(int i = 0; i < prices.length; i++) {
                if (mPrices[i] < prices[i]) {
                    prices[i] = mPrices[i];
                }
            }
        }
    }
    public void loseMembership(){
        if(employed){
            System.arraycopy(ePrices, 0, prices, 0, prices.length); //is employee
        }
        else{
            System.arraycopy(rPrices, 0, prices, 0, prices.length);
        }
    }
    public void getEmployed(){
        bill.add("EMPLOYEE\t0");
        for(int i = 0; i < prices.length; i++) {
            if (mPrices[i] < prices[i]) {
                prices[i] = mPrices[i];
            }
        }
        employed = true;
    }
    public void getFired(){
        if(prices[0] < 0){
            System.arraycopy(mPrices, 0, prices, 0, prices.length); //is member
        }
        else{
            System.arraycopy(rPrices, 0, prices, 0, prices.length);
        }
    }
    public void purchaseRetail(double salePrice){
        double actualPrice = salePrice * (1 + prices[2]);
        bill.add("RETAIL\t" + (String.valueOf(actualPrice)));
        paid.add(actualPrice);
        visits++;
        visitLengths.add(10.0);
    }
    public void takeClass(double classLength){//classLength is in hours
        bill.add("CLASS\t" + (String.valueOf(prices[1])));
        paid.add(prices[1]);
        visits++;
        visitLengths.add(classLength);
        weight -= .11*classLength; //assuming approx. 400 calories burned in 1 hour of generic gym class, 400/3500=.11
    }
    public void aquatics(double aquaticLength){ //aquaticLength is in hours (not necessarily whole number)
        bill.add("AQUATICS\t" + (String.valueOf(prices[3])));
        paid.add(prices[3]);
        visits++;
        visitLengths.add(aquaticLength);
        weight -= .17 * aquaticLength; //1 hour of swimming burns around 600 calories, 3500 calories loses a pound, 600/3500=.17
    }
    public void personalTrainer(){
        bill.add("PESRONAL TRAINER\t" + (String.valueOf(prices[4])));
        paid.add(prices[4]);
        visits++;
        visitLengths.add(60.0);
        weight -= 0.07; //1 hour burns around 250 calories, 250/3500 = 0.07
    }
    public void printBill(){
        double total = 0;
        for(int i = 0; i < paid.size(); i++){
            total += paid.get(i);
        }
        bill.add("\n TOTAL\t" + (String.valueOf(total)));
        for(int i = 0; i < bill.size(); i++){
            System.out.println(bill.get(i));
        }
    }
    public void printVisits(){
        double total = 0;
        for(int i = 0; i < visitLengths.size(); i++){
            total+=visitLengths.get(i);
            System.out.println(visitLengths.get(i));
        }
        System.out.println("TOTAL NUMBER: "+ visits);
        System.out.println("TOTAL TIME: " + total);
    }
    public double weightLost(){
        return weight - initialWeight;
    }
    public String name;
    public int SSN;
    public final double initialWeight;
    public double weight; //in pounds
    public int visits;
    public boolean employed;
    public ArrayList<Double> visitLengths = new ArrayList<Double>();
    public ArrayList<String> bill = new ArrayList<String>();
    public ArrayList<Double> paid = new ArrayList<Double>();
    public String[] items = {"Membership", "Classes", "Retail", "Aquatics", "Personal Trainer"};

    public double[] prices = new double[5]; //current prices for customer
    //constants, -1 means not available, prices[2] is the percent off
    public final double[] mPrices = {-1, 8, -0.2, 10, 20};
    public final double[] ePrices = {1,  3, -0.1,  7, 15};
    public final double[] rPrices = {65, 10, 0, -1, 25};
}
