package DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wee on 2015/3/16.
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    //1.brute force will TLE.
    //just check
    //every substring
    //from index
    //0
    //to the
    //end.思路就是将dict不断的与s匹配，然后标记如果当匹配完成之后长度等于s则为true，TLE
    public static boolean wordBreak(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    public static boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    //Todo:DP方法留待研究
    public boolean wordBreak2(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];
        Arrays.fill(f, false);

        f[0] = true;


        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/

        //Second DP
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static boolean wordBreak3(String s, Set<String> dict) {


        StringBuilder sb = new StringBuilder();

        for (String q : dict) {
            sb.append(q + "|");
        }

        String pattern = sb.toString().substring(0, sb.length() - 1);
        pattern = "(" + pattern + ")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        return m.matches();

    }


    public static void main(String[] args) {
        String s ="leetcode";
        Set<String> dict =  new HashSet<String>();
        dict.add("de");
        dict.add("leet");
        dict.add("co");
       
        System.out.println(wordBreak3(s, dict));
        //-------------------------------------------------3 正则表达式的使用,我擦从来没用过Pattern
        HashSet<String> dict1 = new HashSet<String>();
        dict1.add("go");
        dict1.add("goal");
        dict1.add("goals");
        dict1.add("special");

        StringBuilder sb = new StringBuilder();

        for (String q : dict1) {
            sb.append(q + "|");
        }

        String pattern = sb.toString().substring(0, sb.length() - 1);
        pattern = "(" + pattern + ")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher("goalspecial");

        if (m.matches()) {
            System.out.println("match");
        }
    }
}
