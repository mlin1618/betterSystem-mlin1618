/**
 * Created by Nilxam on 1/4/17.
 */
public class Member extends Customer{
    public final double[] cPrices = {-1, 8, .8, 10, 20};
    public Member(int S, double w){
        super(S,w);
        System.arraycopy(cPrices,0,prices,0,prices.length);
        /*membership = 0;
        classes = 8;
        retail = .8;
        aquatics = 10;
        trainer = 20;*/
    }
}
