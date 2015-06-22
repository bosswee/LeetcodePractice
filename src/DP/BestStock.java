package DP;

/**
 * Created by Wee on 2015/3/13.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BestStock {
    public int maxProfit(int[] prices) {
        //一维DP,维护一个maxProfit和一个前i时间段内的最小值，
        // 可以复用前i-1时间段内最小值的重复计算，时间n；


        if (prices.length == 0) {

            return 0;
        }

        int max = 0, min = prices[0];
        int profit = 0;

        for (
                int i = 1;
                i < prices.length; i++)

        {
            if (prices[i] < min) {

                min = prices[i];
            } else {
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }

            }
        }


        return profit;
    }

}
