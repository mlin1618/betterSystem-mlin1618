
import java.util.*;
public class Regular extends Customer{
    public Regular(int S, String N,double w){
        super(S,N,w);
        System.arraycopy(rPrices,0,prices,0,prices.length);
    }
    public boolean aquatics(double aquaticLength){
        if(prices[3]>0){
            super.aquatics(aquaticLength);
            return true;
        }
        return false;
    }
}
