/**
 * Created by Nilxam on 1/4/17.
 */
public class Employee extends Customer{
    public final double[] ePrices = {1,3,.9,7,15};
    public Employee(int S, double w){
        super(S,w);
        System.arraycopy(ePrices,0,prices,0,prices.length);
        /*membership = 1;
        classes = 3;
        retail = .9;
        aquatics = 7;
        trainer = 15;*/
    }
}
