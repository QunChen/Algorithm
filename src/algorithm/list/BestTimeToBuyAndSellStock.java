package algorithm.list;

/**
 * Created by qun.chen on 21/5/17.
 * update a min value, than calculate the profit by current value minus current min
 * O(n)
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i:prices){
            if(i<min){
                min=i;
            }else{
                int profit=i-min;
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }

        return maxProfit;
    }
}
