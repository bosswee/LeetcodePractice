package BitManioulation;

/**
 * Created by Wee on 2015/4/5.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 这个题有类似于single number的解法，即通过位运算，一遍扫描得到结果。还是读书的时候见过，大概是两个变量，相互做异或、补之类的运算，早不记得详情了。

 现在的解法是比较普通的。因为题目已经说了，除了一个数字以外，其他的都出现了3次，如果我们把那个特殊的数剔除，并把剩下的数于每一位来加和的话，每一位上1出现的次数必然都是3的倍数。所以，解法就在这里，将每一位数字分解到32个bit上，统计每一个bit上1出现的次数。最后对于每一个bit上1出现的个数对3取模，剩下的就是结果。


 */
public class SingleNumberTwo {
    public int singleNumber(int[] A) {
         /*
        element in A is 32bit,
        sum corresponding bits from all elements and mod each by 3 then should left the single number
        */
        int[] sum=new int[32];
        int res=0;
        for(int i=0;i<32;i++)
        {
            for(int j=0;j<A.length;j++)
            {
                sum[i]+=((A[j]>>>i)&1);//sum every bit of all numbers
            }
            sum[i]%=3;
            res+=((sum[i]&1)<<i);// recover the single number
        }
        return res;

    }


}
