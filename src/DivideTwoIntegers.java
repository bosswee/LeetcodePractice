/**
 * Created by Wee on 2015/4/8.
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 对于这道题目，因为不能用乘除法和取余运算，我们只能使用位运算和加减法。比较直接的方法是用被除数一直减去除数，直到为0，记录下被减的次数就是结果。这种方法的迭代次数是结果的大小，即比如结果为n，算法复杂度是O(n)。

 那么有没有办法优化呢？ 这个我们就得使用位运算。我们知道任何一个整数可以表示成以2的幂为底的一组基的线性组合，即num=a_0*2^0+a_1*2^1+a_2*2^2+…+a_n*2^n。基于以上这个公式以及左移一位相当于乘以2
 ，我们先让除数左移直到大于被除数之前得到一个最大的基。然后接下来我们每次尝试减去这个基，如果可以则结果增加加2^k,然后基继续右移迭代，直到基为0为止。因为这个方法的迭代次数是按2的幂知道超过结果，所以时间复杂度为O(logn)。

 需要注意的是，整数的溢出问题，例如 divide(-2147483648, 2)。我这里问了方便，直接使用了long类型，
 */
public class DivideTwoIntegers {


    public int divide2(int dividend, int divisor) {
        //转化为负数防止溢出
        if (divisor == 1) // Trival case 1
            return dividend;

        // Use negative integers to avoid integer overflow
        if (dividend > 0)
            return -divide2(-dividend, divisor);
        if (divisor > 0)
            return -divide2(dividend, -divisor);

        if (dividend > divisor) // Trivial case 2
            return 0;

        if ((dividend == Integer.MIN_VALUE) && (divisor == -1)) // Overflow case
            return Integer.MAX_VALUE;

        // Find the highest mult = (divisor * 2^shifts) which is <= dividend
        // by shifting mult to the left without causing an overflow.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations.
        int min_divisor = Integer.MIN_VALUE >> 1;
        int mult = divisor; // = divisor * 2^shifts
        int shifts = 0;
        while ((mult >= min_divisor) && (mult > dividend)) {
            mult <<= 1;
            ++shifts;
        }

        // Compute the result by shifting mult to the right.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the outer loop.
        // At most (log2(|dividend|) - log2(|divisor|) + 1) iterations for the inner loop
        // (in total, not per outer iteration).
        int result = 0;
        int power = 1 << shifts; // = 2^shifts
        while (dividend <= divisor) {
            shifts = 0;
            while (mult < dividend) {
                mult >>= 1;
                ++shifts;
            }
            dividend -= mult;
            power >>= shifts;
            result |= power; // Adds power to result
        }

        return result;
    }

}
