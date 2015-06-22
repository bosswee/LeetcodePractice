package DP;

/**
 * Created by Wee on 2015/5/7.
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob
 tonight without alerting the police.

 对于这类求极值的问题首先考虑动态规划Dynamic Programming来解
 */
public class HouseRobber {
    //DP
    public int rob(int[] num) {
        //越看越像数学归纳法，只要有初始条件和递推式就行
        int len = num.length;
        if (len == 0) return 0;
        if (len == 1) return num[0];
        if (len == 2) return Math.max(num[0], num[1]);
        if (len == 3) return Math.max(num[0] + num[2], num[1]);
        int[] dp = new int[len];
        dp[0] = num[0];
        dp[1] = num[1];
        dp[2] = num[0] + num[2];
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i - 3] + num[i], dp[i - 2] + num[i]);
            //状态转移公式为: dp[i]=Math.max(dp[i-3]+num[i], dp[i-2]+num[i])
        }
        return Math.max(dp[len - 1], dp[len - 2]);

    }

    //DP：我们维护一个一位数组dp，其中dp[i]
    //表示到达 index = i，
    //位置时不相邻数能形成的最大和，i不一定是最后一个rob的房子
    //
    //dp[0]=num[0];
    //
    //dp[i]=
    //
    //max(dp[i-1], i>=2?dp[i-2]+num[i]:num[i]);
    //
    //时间复杂度：
    //
    //O(N),空间复杂度
    //
    //：
    //
    //O(N)
    //
    //->
    //
    //O(1)


        public int rob2(int[] num) {
            if (num == null || num.length == 0) return 0;
            int[] res = new int[num.length];
            res[0] = num[0];
            for (int i = 1; i < num.length; i++) {
                res[i] = Math.max(res[i - 1], i >= 2 ? res[i - 2] + num[i] : num[i]);
            }
            return res[num.length - 1];
        }

    public int rob3(int[] num) {
        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for (int i = 0; i < num.length; i++) {
            int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }

}
