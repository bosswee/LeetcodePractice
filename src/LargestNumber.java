import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Wee on 2015/4/2.
 * Given a list of non negative integers,
 * arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
            //本来以为依次拿出每个数的第一个数作比较，然后第二个数。。。
        //然后发现可以利用Compator的性质排序然后输出23333
        if(num==null || num.length==0)
            return "";
        String[] Snum = new String[num.length];//感觉Just write a Comparator to sort the list with Collections.sort.不用数组更好一点
        for(int i=0;i<num.length;i++)
            Snum[i] = num[i]+"";

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(Snum, comp);
        if(Snum[Snum.length-1].charAt(0)=='0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for(String s: Snum)
            sb.insert(0, s);

        return sb.toString();

    }
}
