/**
 * Created by Wee on 2015/5/17.
 * 解题思路：
 * 基数排序（radix sort）/桶排序（bucket sort）
 * 1,桶排序是稳定的
 * <p/>
 * 2,桶排序是常见排序里最快的一种,比快排还要快…大多数情况下
 * <p/>
 * 3,桶排序非常快,但是同时也非常耗空间,基本上是最耗空间的一种排序算法
 * 桶排序按下面4步进行：
 * <p/>
 * 1. 设置固定数量的空桶。
 * 2. 把数据放到对应的桶中。
 * 3. 对每个不为空的桶中数据进行排序。
 * 4. 拼接从不为空的桶中数据，得到结果。
 * 桶排序，主要适用于小范围整数数据，且独立均匀分布，可以计算的数据量很大，而且符合线性期望时间
 * 4. 案例：桶排序统计高考分数
 * <p/>
 * 桶排序最出名的一个应用场景，就是统计高考的分数。一年的全国高考考生人数为900万人，分数使用标准分，最低200 ，最高900 ，没有小数，如果把这900万数字进行排序，应该如何做呢？
 * iven an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * <p/>
 * Try to solve it in linear time/space.
 * <p/>
 * Return 0 if the array contains less than 2 elements.
 * <p/>
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
    class Bucket {
        int low;
        int high;

        public Bucket() {
            low = -1;
            high = -1;
        }
    }

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }

        int max = num[0];
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }

        // initialize an array of buckets
        Bucket[] buckets = new Bucket[num.length + 1]; //project to (0 - n)
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        double interval = (double) num.length / (max - min);
        //distribute every number to a bucket array
        for (int i = 0; i < num.length; i++) {
            int index = (int) ((num[i] - min) * interval);

            if (buckets[index].low == -1) {
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, num[i]);
                buckets[index].high = Math.max(buckets[index].high, num[i]);
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                result = Math.max(result, buckets[i].low - prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }
}
