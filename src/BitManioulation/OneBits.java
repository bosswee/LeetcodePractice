package BitManioulation;

/**
 * Created by Wee on 2015/3/23.
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class OneBits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //&：双目运算符，运算时均把运算数转换为二进制再做比较，规则：当相同的位上均为1时结果为1，否则结 果为0.如：1010&1101，转为二进制：
        // 10001001101&1111110010比较结果为：1000000转为十进制： 64所以1010&1101=64；
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }


}
