package String;

/**
 * Created by Wee on 2015/5/17.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 方法一：大整数乘法，一位一位往上乘，注意进位的处理即可。此外，注意0的处理
 方法二：思路：
 1 翻转string
 2 建立数组，双层循环遍历两个string，把单位的乘积累加到数组相应的位置
 3 处理进位并输出
 4 注意前导零的corner case
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        //字符串化为整数要考虑溢出问题，递归的求出整数然后相乘×
        //把两个字符串放到数组里，直接从后往前进位相乘打印出来
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = product.length - 1; i > 0; i--) {
            if (stringBuilder.length() == 0 && product[i] == 0)
                continue;
            stringBuilder.append(product[i]);
        }
        stringBuilder.append(product[0]);
        return stringBuilder.toString();


    }


    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        System.out.println(multiply2(num1, num2));
    }

    //翻转的写法

    public static String multiply2(String num1, String num2) {
        // 先把string翻转
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[n1.length() + n2.length()];        // 构建数组存放乘积
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');        // 在正确位置累加乘积
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;        // 当前位
            int carry = d[i] / 10;        // 进位
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, digit);        // prepend
        }

        // 移除前导零
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
