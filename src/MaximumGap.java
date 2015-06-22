/**
 * Created by Wee on 2015/5/17.
 * ����˼·��
 * ��������radix sort��/Ͱ����bucket sort��
 * 1,Ͱ�������ȶ���
 * <p/>
 * 2,Ͱ�����ǳ�������������һ��,�ȿ��Ż�Ҫ�졭����������
 * <p/>
 * 3,Ͱ����ǳ���,����ͬʱҲ�ǳ��Ŀռ�,����������Ŀռ��һ�������㷨
 * Ͱ��������4�����У�
 * <p/>
 * 1. ���ù̶������Ŀ�Ͱ��
 * 2. �����ݷŵ���Ӧ��Ͱ�С�
 * 3. ��ÿ����Ϊ�յ�Ͱ�����ݽ�������
 * 4. ƴ�ӴӲ�Ϊ�յ�Ͱ�����ݣ��õ������
 * Ͱ������Ҫ������С��Χ�������ݣ��Ҷ������ȷֲ������Լ�����������ܴ󣬶��ҷ�����������ʱ��
 * 4. ������Ͱ����ͳ�Ƹ߿�����
 * <p/>
 * Ͱ�����������һ��Ӧ�ó���������ͳ�Ƹ߿��ķ�����һ���ȫ���߿���������Ϊ900���ˣ�����ʹ�ñ�׼�֣����200 �����900 ��û��С�����������900�����ֽ�������Ӧ��������أ�
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
