package String;

/**
 * Created by Wee on 2015/3/28.
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int aPtr = a.length() - 1;
        int bPtr = b.length() - 1;
        int carry = 0;//标志是否进位
        int count = 0;//计算是否进位
        while(aPtr >= 0 || bPtr >= 0) {
            if(aPtr >= 0) {
                if(a.charAt(aPtr) == '1') {
                    count ++;
                }
            }
            if(bPtr >= 0) {
                if(b.charAt(bPtr) == '1') {
                    count ++;
                }
            }
            if(carry == 1) {
                count++;
            }
            carry = (count > 1 ? 1 : 0);
            str.insert(0, ((count == 0 || count == 2)? '0' : '1'));
            count = 0;
            aPtr--;
            bPtr--;
        }
        if(carry == 1) {
            str.insert(0, '1');
        }
        return str.toString();
    }
}
