import java.util.LinkedList;
import java.util.Set;

/**
 * Created by We
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
    //bfs Todo:逻辑没搞懂，一个字符串如何转变为... TLE??
    public int ladderLength(String start, String end, Set<String> dict) {
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.add(end);
        int step = 0;
        while (!queue.isEmpty()) {
            LinkedList<String> level = new LinkedList<String>();
            step++;
            while (!queue.isEmpty()) {
                String q = queue.pollFirst();
                if (q.equals(end))
                    return step;
                for (int i = 0; i < start.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String s = q.substring(0, i) + c + q.substring(i + 1, start.length());
                        if (dict.contains(s)) {
                            level.add(s);
                            dict.remove(s);
                        }
                    }
                }
            }
            queue = level;
        }
        return 0;
    }
}
