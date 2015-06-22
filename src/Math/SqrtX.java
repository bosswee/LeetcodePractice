package Math;

/**
 * Created by Wee on 2015/5/6.
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
public class SqrtX {
    public int mySqrt(int x) {

        //二分法提高效率，对于一个非负数n，注意不要溢出
        // 它的平方根不会小于大于（n/2+1）。在[0, n/2+1]这个范围内可以进行二分搜索，求出n的平方根。
        long i =0;
        long j = x/2+1;
        while (i<=j){
            long mid =(i+j)/2;
            long sq = mid*mid;
            if (sq==x)return (int)mid;
            else if(sq<x)i=mid+1;
            else j= mid-1;
        }
        return (int)j;
    }

    public int sqrt(int x) {
        //利用除法防止溢出
        if (x == 0)
            return 0;
        int left = 1, right = x/2+1;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    //2. 牛顿迭代法


}
