/**
 * Created by Wee on 2015/5/7.
 * Implement pow(x, n).
 * http://www.programcreek.com/2012/12/leetcode-powx-n/
 * Naturally, we next may think how to do it in O(logn).
 * We have a relation that x^n = x^(n/2) * x^(n/2) * x^(n%2).
 * The accepted solution is also recursive, but does division first. Time complexity is O(nlog(n)).
 *
 * The most understandable solution I have found so far.
 * The key part of solving this problem is
 * the while loop.
 */
public class Pow {


    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }

    }


    public double power(double x, int n) {
        if (n == 0)
            return 1;

        double v = power(x, n / 2);

        //x^n = x^(n/2) * x^(n/2) * x^(n%2).

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }

}
