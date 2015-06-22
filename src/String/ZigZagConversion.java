package String;

/**
 * Created by Wee on 2015/5/7.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a
 * fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 数学题。巨无聊的一道题，真正面试过程中，不大可能出这种问题。
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows <= 0)
            return "";
        if (nRows == 1)
            return s;
        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += size) {
                res.append(s.charAt(j));
                if (i != 0 && i != nRows - 1 && j + size - 2 * i < s.length())
                    res.append(s.charAt(j + size - 2 * i));
            }
        }
        return res.toString();
    }
}
