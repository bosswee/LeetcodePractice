package Math;

import java.util.HashMap;

/**
 * Created by Wee on 2015/5/9.
 * *
 http://blog.csdn.net/ljiabin/article/details/42025037
 * *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 难点：如何识别循环体？

 解决方法：用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。

 示例：1/13=0.076923076923076923...，当小数部分第二次出现0时，就意味着开始了循环，那么需要把076923用括号括起来，结果为0.(076923)。

 涉及技巧：1）在不断相除的过程中，把余数乘以10再进行下一次相除，保证一直是整数相除；2）HashMap的key和value分别是<当前余数, 对应结果下标>，这样获取076923时就可根据value值来找。

 注意点1：考虑正负数，先判断符号，然后都转化为正数；

 注意点2：考虑溢出，如果输入为Integer.MIN_VALUE，取绝对值后会溢出。

 一定要先把 int 转为 long，然后再取绝对值。如果写成 long num = Math.abs(numerator) 就会有问题，因为这句代码在 numerator=Integer.MIN_VALUE 时相当于 long num = Math.abs
 (-2147483648)，这样得到的 num还是 -2147483648。

 */
public class FractionRecurring {

        public  static String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";
            if (denominator == 0) return "";

            String ans = "";

            //如果结果为负数
            if ((numerator < 0) ^ (denominator < 0)) {
                ans += "-";
            }

            //下面要把两个数都转为正数，为避免溢出，int转为long
            long num = numerator, den = denominator;
            num = Math.abs(num);
            den = Math.abs(den);

            //结果的整数部分
            long res = num / den;
            ans += String.valueOf(res);

            //如果能够整除，返回结果
            long rem = (num % den) * 10;
            if (rem == 0) return ans;

            //结果的小数部分
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            ans += ".";
            while (rem != 0) {
                //如果前面已经出现过该余数，那么将会开始循环
                if (map.containsKey(rem)) {
                    int beg = map.get(rem); //循环体开始的位置
                    String part1 = ans.substring(0, beg);
                    String part2 = ans.substring(beg, ans.length());//StringBuilder优化速度
                    ans = part1 + "(" + part2 + ")";
                    return ans;
                }

                //继续往下除
                map.put(rem, ans.length());
                res = rem / den;
                ans += String.valueOf(res);
                rem = (rem % den) * 10;
            }

            return ans;
        }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2,3));
    }
    }

