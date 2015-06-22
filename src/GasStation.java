/**
 * Created by Wee on 2015/5/9.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the
 journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
思路：
 To solve this problem, we need to understand:
 1) if sum of gas[] >= sum of cost[], then there exists a start index to complete the circle.
 2) if A can not read C in a the sequence of A-->B-->C, then B can not make it either.

 Proof:

 If gas[A] < cost[A], then A can not go to B. Therefore, gas[A] >=cost[A].
 We already know A can not go to C, we have gas[A] + gas[B] < cost[A] + cost[B]
 And gas[A] >=cost[A],
 Therefore, gas[B] < cost[B], i.e., B can not go to C.
 In the following solution, sumRemaining tracks the sum of remaining to the current index. If sumRemaining < 0,
 then every index between old start and current index is bad, and we need to update start to be the current index.

 You can use the following example to visualize the solution.
 leetcode-gas-station-java
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }

}
