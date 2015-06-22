/**
 * Created by Wee on 2015/3/26.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //------------get shortestLength of strs thus, longest prefix
        int shortestLength = Integer.MAX_VALUE;
        for(String tem : strs){
            if(tem.length()< shortestLength){
                shortestLength = tem.length();
            }
        }

        breakable:  for(int i = 0; i < shortestLength; i++){
            char tem = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i)!=tem){
                    break ;
                }
            }
            sb.append(tem+"");
        }

        return sb.toString();
    }
}
