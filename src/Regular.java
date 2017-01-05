/**
 * Created by Nilxam on 1/4/17.
 */
public class Regular extends Customer{
    public final double[] rPrices = {65, 10, 1, -1, 25};
    public Regular(int S, double w){
        super(S,w);
        System.arraycopy(rPrices,0,prices,0,prices.length);
        /*membership = 65;
        classes = 10;
        retail = 1;
        aquatics = -1;
        trainer = 25;*/
    }
    public void getMembership(){

    }
    public void getEmployed(){

    }
}
