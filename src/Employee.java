
public class Employee extends Customer{
    public Employee(int S, String N, double w){
        super(S,N,w);
        employed = true;
        System.arraycopy(ePrices,0,prices,0,prices.length);
    }
}
