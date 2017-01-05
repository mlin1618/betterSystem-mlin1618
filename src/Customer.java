/**
 * Created by Nilxam on 1/4/17.
 */
import java.util.*;
public abstract class Customer {
    public Customer(int S, double w){
        SSN = S;
        weight = w;
    }
    //public abstract void getMembership();
    //public abstract void getEmployed();
    private int SSN;
    private double weight;
    private int visits;
    private ArrayList<Integer> visitLengths = new ArrayList<Integer>();

   /* public String[] names = {"Membership", "Classes", "Retail", "Aquatics", "Personal Trainer"};
    public double[] prices = new double[5];
    /*public double membership;
    public double classes;
    public double retail;
    public double aquatics;
    public double trainer;*/

    //new plan: there is only one class
    //membership and employment are PROPERTIES of a customer, not classes of customers
    /*
    so here's the idea:
    you make a generic Customer class, like we have now
    make a method to getMembership, another to getEmployed
    if a person starts out as an employee, just do getEmployed right off the bat, etc.
    within each, take the best savings between the new ones and the ones they have (so use math.min)

    then make methods visitGym() (records in variables visits and vistLength),
    purchase (get to buy something from retail)
    printBill (prints out what you've paid for, your weight, and your visits, and your current status)
     */
    public void getMembership(){

    }
    public void getEmployed(){

    }
    public void purchase(){

    }
    public void printBill(){
        
    }
}
