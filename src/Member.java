
public class Member extends Customer{
    public Member(int S, String N, double w){
        super(S,N,w);
        System.arraycopy(mPrices,0,prices,0,prices.length);
    }
    public boolean getMembership(){
        if(prices[0] > 0){
            super.getMembership();
            return true;
        }
        return false;
    }
}
