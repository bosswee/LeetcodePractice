package String;

/**
 * Created by Wee on 2015/3/26.
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge,
 please do not see below and ask yourself what are the possible input cases.
 1. null or empty string
 2. white spaces
 3. +/- sign
 4. calculate real value
 5. handle min & max
 */
public class StringToInteger {
    public int atoi(String str){
        if(str==null||str.length()<1)
            return 0;
        //trim white spaces
        str=str.trim();
        char flag ='+';
        //check negative or positive
        int i =0;
        if(str.charAt(0)=='-'){
            flag='-';
            i++;
        } else if (str.charAt(0)=='+'){
            i++;
        }
        //use double to store result
        double result =0;

        //calculate value
        while(str.length()>i&&str.charAt(i)>'0'&&str.charAt(i)<='9'){
            result = result*10+(str.charAt(i)-'0');
            i++;
        }
        if(flag=='-')
            result =-result;
        //handle amx and min
        if(result>Integer.MAX_VALUE)
            return  Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE)
            return  Integer.MIN_VALUE;

        return  (int) result;
    }
}
