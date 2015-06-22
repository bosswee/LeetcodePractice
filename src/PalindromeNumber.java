/**
 * Created by Wee on 2015/3/15.
 *   大家对回文串不陌生吧？一个字符串从前看和从后看如果一样的话，就是回文串。比如“上海自来水来自海上”就是一个回文串。现在我们的问题来了,把一个数字看成字符串,问它是不是一个回文数？这么简单的题目对想要成为小米工程师的你来说肯定不是问题。不过提醒一下哦：时间复杂度和空间复杂度越低的算法，得分越高。
 C++：
 bool isPalindromeNumber(long num)
 Java:
 boolean isPalindromeNumber(long num)
 示例：12321 ->  true
 3     ->  true 
 133434->  false
 */
public class PalindromeNumber {
     boolean isPalindromeNumber(long num){
        String str = num +"";
        int start = 0;
        int end = str.length()-1;

        while (start<=end){
            char c = str.charAt(start);
            char s = str.charAt(end);
            if (c!=s){
                return false;
            }else{
                start++;
                end--;
            }

        }
       return true;
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.print(p.isPalindromeNumber(123321));
        System.out.print(p.isPalindromeNumber(1));
        System.out.print(p.isPalindromeNumber(123871));
    }
}
