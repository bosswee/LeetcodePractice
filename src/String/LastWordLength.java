package String;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class LastWordLength {
    public int lengthOfLastWord(String s) {
      int len =s.length(),lastLength=0;
        while (len>0&&s.charAt(len-1)==' '){
            len--;
        }
        while(len>0&&s.charAt(len-1)!=' '){
            lastLength++;
            len--;
        }

        return lastLength;
        // return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
    public int lengthOfLastWord2(String s) {
        String[] parts = s.split(" ");
        if (parts.length == 0) return 0;
        return parts[parts.length - 1].length();
    }
}
