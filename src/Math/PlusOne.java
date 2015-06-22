package Math;

/**
 * Created by Wee on 2015/3/11.
 * given a non-negative number represented as
 an array of digits, plus one to the number. The digits are stored such that the most significant digit is
 at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            if (carry == 0)
                break;
            digits[i] = 0;//��Ϊֻ��+1�����Խ�λ�Ļ�ԭʼλֻ����0������Ļ���carry%10��ʾ�Ϳ�����
        }
        // after loop, if carry is 1, create a new array with size + 1
        // e.g. 999 + 1 -> 1000
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}