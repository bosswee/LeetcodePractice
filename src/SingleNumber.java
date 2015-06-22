/**
 * Created by Wee on 2015/4/5.
 * 　0^0=0,0^1=1 0异或任何数＝任何数

 　　　1^0=1,1^1=0 1异或任何数－任何数取反

 　　　任何数异或自己＝把自己置0
 Given an array of integers,
 every element appears twice except for one. Find that single one.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int x=0;

        for(int a: A){
            x = x ^ a;
        }

        return x;

    }
}
