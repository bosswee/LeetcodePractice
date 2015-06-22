package String;

/**
 * Created by Wee on 2015/3/29.
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 */
public class ReverseString {
    public String reverseWords(String s) {

        String[] parts = s.trim().split("\\s+");
        String out = "";
        if (parts.length > 0) {
            for (int i = parts.length - 1; i > 0; i--) {
                out += parts[i] + " ";
            }
            out += parts[0];
        }
        return out;//use stringbuilder优化


    }



}
