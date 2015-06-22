package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Wee on 2015/4/22.
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 解题思路：一开始直接模拟，循环100次还不是1直接剪掉return false，也能AC，
 但是毕竟可能有情况覆盖不到，改用HastSet存放中间数就行了，
 如果得到的新结果在中间数集合中出现了，那么一定会陷入循环并且得到的不是1。
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<Integer>();
        int sum =n;
        while(sum!=1){
            n=sum;
            sum=0;
            while (n!=0){
                sum+=(n%10)*(n%10);
                n/=10;
            }
            if (res.contains(sum)){
                return false;
            }

            res.add(sum);
        }

        return true;
    }

}
