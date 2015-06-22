package Array;

/**
 * Created by Wee on 2015/3/14.
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int max_pro=0;
        for(int i=prices.length-1;i>0;i--){
            if(prices[i]-prices[i-1]>0) max_pro+=prices[i]-prices[i-1];
        }
        return max_pro;
    }
}
