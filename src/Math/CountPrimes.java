package Math;

import java.util.ArrayList;

/**
 * Created by Wee on 2015/5/9.
 * Description:

 Count the number of prime numbers less than a non-negative number, n
 */
public class CountPrimes {
    //TLE，计算出每个素数，TLE
    public int countPrimes(int n) {
        n = n - 1;

        ArrayList<Integer> primes = new ArrayList<Integer>();

        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        primes.add(2);
        primes.add(3);

        for (int i = 4; i <= n; i++) {
            boolean isPrime = true;
            for (int p : primes) {
                int m = i % p;
                if (m == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        return primes.size();
    }

    //This solution
    //is the
    //implementation of
    //Sieve of
    ////Eratosthenes.
    //http://baike.baidu.com/view/1425379.htm
    //要得到自然数n以内的全部素数，必须把不大于的所有素数的倍数剔除，剩下的就是素数。
    //给出要筛数值的范围n，找出以内的素数。先用2去筛，即把2留下，把2的倍数剔除掉；再用下一个质数，
    // 也就是3筛，把3留下，把3的倍数剔除掉；接下去用下一个质数5筛，把5留下，把5的倍数剔除掉；不断重复下去......。
    public static int countPrimes2(int n) {
        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)//从2开始到根号N,每次把i和i的倍数去掉
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])//为true的位置就是素数

                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.print(countPrimes2(3));
    }
}
