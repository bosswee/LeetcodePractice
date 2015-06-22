package String;

/**
 * Created by Wee on 2015/3/28.
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.

 判断一个字符串是否是另一个字符串的子串。这个题目最经典的算法应该是KMP算法，不熟悉的朋友可以参见Knuth–Morris–Pratt
 algorithm。KMP算法是最优的线性算法，复杂度已经达到这个问题的下限。但是KMP算法比较复杂，
 很难在面试的短时间里面完整正确的实现。所以一般在面试中并不要求实现KMP算法。
 下面我们先说说brute force的算法，
 假设原串的长度是n，匹配串的长度是m。思路很简单，就是对原串的每一个长度为m的字串都判断是否跟匹配串一致。总共有n-m+1个子串，所以算法时间复杂度为O((n-m+1)*m)=O(n*m)，空间复杂度是O(1)。
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();//暴力匹配，两个指针分别遍历
        int nlen = needle.length();
        int i =0;
        int j =0;
        while (i<hlen &&j<nlen){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else{
                i=i-j+1;
                j=0;


            }
        }

        if (j==nlen)
            return i-j;
        else
            return  -1;

    }//可以使用KPM算法优化
}
