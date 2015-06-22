package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/6.
 * Given a digit string, return all possible
 * letter combinations that the number could represent.

 A mapping of digit to letters (just like
 on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Thought:先把对应关系存储起来，然后想办法遍历,DFS或者BFS，可以借助queue
 */
public class LetterCombinOfPhoneNumber {
    private static final String[] LETTERS = {
            "",       // 0
            "",       // 1
            "abc",    // 2
            "def",    // 3
            "ghi",    // 4
            "jkl",    // 5
            "mno",    // 6
            "pqrs",   // 7
            "tuv",    // 8
            "wxyz"   // 9
    };
    public List<String> letterCombinations(String digits) {


        ArrayList<String> result = new ArrayList<String>();
        if (digits==null||digits.length()<=0)return result;
        result.add("");
        for (char c : digits.toCharArray()){
            String letter = LETTERS[c-'0'];
        ArrayList<String> newResult= new ArrayList<String>();
            for (char l:letter.toCharArray()){
                for (String s :result){
                    newResult.add(s+l);
                }

            }
            result = newResult;
        }
        return  result;
    }
}
