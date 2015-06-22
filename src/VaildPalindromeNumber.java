/**
 * Created by Wee on 2015/3/25.
 * iven a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class VaildPalindromeNumber {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Z^a-z^0-9]+", "");
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String reverseString = sb.toString();
        boolean result = s.equals(reverseString);
        return result;
    }
}
