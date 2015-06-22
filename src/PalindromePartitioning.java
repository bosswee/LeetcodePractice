import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/17.
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning {
    public static List<ArrayList<String>> partition(String s) {
        List<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (s == null || s.length() == 0) return result;
           ArrayList<String> partition = new ArrayList<String>();
           addPalindrome(s,0,partition,result);
        return result;
    }
            //返回所有组合的问题一般都是DFS
    private static void  addPalindrome(String s, int start, ArrayList<String> partition, List<ArrayList<String>> result) {
        //stop condition
        if (start==s.length()){
            ArrayList<String> temp = new ArrayList<String>(partition);//这样算是深拷贝吧
            result.add(temp);
            return;
        }
        for (int i=start+1;i<=s.length();i++){
            String str = s.substring(start,i);
            if (isPalindrome(str)){
                partition.add(str);
                addPalindrome(s,i,partition,result);
                partition.remove(partition.size()-1);//partition用完之后其他其他结果还要重复利用
            }
        }

    }

    private static boolean isPalindrome(String str) {
        int left=0;
        int right =str.length()-1;

        while (left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return  true;

    }

    public static void main(String[] args) {
        String s = "aac";
        System.out.print(partition(s));
    }
}
