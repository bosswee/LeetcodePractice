import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wee on 2015/4/22.
 * Given an array of strings, return all groups of strings that are anagrams.

 Note: All inputs will be in lower-case.
 首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，比如“dormitory”颠倒字母顺序会变成“dirty room”，“tea”会变成“eat”。

 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。



 由此我们可以想到，只要将几个单词按照字母顺序进行排序，就可以通过比较判断他们是否是anagrams。
 思路：用map<string, int>记录排序后的字符串以及首次出现的位置。

 1. 从strs的第一个元素开始遍历，首先对元素进行排序得到s；

 2. 在map里查找s；

 3. 若不存在，将s以及该元素的下标存入map<string ,int>；

 4. 若存在，首先将第一次出现s时的原始字符串存入结果res，即strs[map[s]]，并将map[s]设置为-1（防止下次再存），再将该字符串本身存入结果res；

 5. 重复以上1-4步，直到遍历结束。

 具体代码如下：
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs.length <= 1) return res;
        //排序过的string作为key
        HashMap<String, Integer> anagram = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            String s = sorted(strs[i]);
            if (!anagram.containsKey(s)) {
                anagram.put(s, i);
            } else {
                if (anagram.get(s)!=-1) {
                    res.add(strs[anagram.get(s)]);//将第一次出现的存入res}
                    anagram.put(s, -1);//设置一个标志如果是-1，那么就不要再次添加了
                }
                res.add(strs[i]);
            }
        }
        return res;
    }


    private String sorted(String str) {
        char[] achar = str.toCharArray();
        Arrays.sort(achar);
        return new String(achar);
    }
}
