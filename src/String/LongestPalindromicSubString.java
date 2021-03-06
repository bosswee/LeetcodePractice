package String;

/**
 * Created by Wee on 2015/4/4.
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindromicSubString {
    //思路1：最土的算法，将所有的子串求出来，再选出最长的回文子串。不用试，肯定超时。O(n^3)
    public String longestPalindrome(String s) {
        //思路2：挑出最短的回文串（单个字符，或者两个相邻的相同字符），
        // 然后向两端辐射，时间复杂度O(n^2)，空间复杂度可以优化到O(1)
        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s;
        }

        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }
    //思路3：DP
}
