package DP;

/**
 * Created by Wee on 2015/3/15.
 * You are climbing a stair case.
 * It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for(int i = 2; i < n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n-1];// arithmetic way. Find the inner logic relations and get the answer.
    }

    public int climbStairs2(int n) {
        if(n==0||n==1) return  1;
        int stepOne=1,stepTwo=1;
        int result=0;
        for(int i=2;i<=n;i++){
            result=stepOne+stepTwo;
            stepTwo=stepOne;
            stepOne=result;
        }
        return result;//solve this in o(n) and o(1)
    }
}
