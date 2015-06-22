/**
 * Created by Wee on 2015/5/10.
 * There are two sorted arrays nums1 and nums2
 * of size m and n respectively. Find the median of the two sorted arrays. The overall run time
 * complexity should be O(log (m+n)).
 *
 * 寻找两个已排序数组的中位数，要求时间复杂度为 log(m+n).

 分析：

 此题看起来还是比较简单的，但是在leetcode是五星级的题了，可能是测试数据里面有 数组为空的情况，
 导致很多提交错误的。还有一个要注意的情况是，
 如果数组长度为偶数，需要取中间两个数的平均值。

 记得数据结构那本书就说个把两个排序数组合并为一个排序数据的问题。就是同时遍历两个数组，
 每次取两个数组开头小的那个放入新的数组，时间复杂度为 O(m+n)。

 解法一，直接遍历，复杂度O(m+n)


 */
public class MedianofTwoSortedArrays {
    //归并排序的简版

    double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int i = 0, j = 0, median = m + n;
        double prev = 0, last = 0;

        if (median < 2) {
            if (m == 0 && n == 0) return 0;
            if (m == 1) return A[0];
            else return B[0];
        }

        while ((i + j) <= (median / 2)) {
            prev = last;
            if (i >= m) //如果A中的元素已经用完，直接取B数组
            {
                last = B[j];
                j++;
            } else if (j >= n) //同上
            {
                last = A[i];
                i++;
            } else if (A[i] < B[j]) //取A[i] 和 B[j] 中较小的
            {
                last = A[i];
                i++;
            } else {
                last = B[j];
                j++;
            }
        }

        if ((median & 1) == 0) //偶数个
            return (prev + last) / 2.0;
        else //奇数个
            return last;
    }

    //解法二，使用二分查找，时间复杂度为log(m+n). 该方法的核心是将原问题转变成一个寻找第k小数
    // 的问题（假设两个原序列升序排列），这样中位数实际上是第(m+n)
    // /2小的数。所以只要解决了第k小数的问题，原问题也得以解决。
    // 首先假设数组A和B的元素个数都大于k/2，
    // 我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小
    // 的元素。这两个元素比较共有三种情况：>、<和=。如果A[k
    // /2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
    // 换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。

    public static double findMedianSortedArrays2(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 != 0) // odd
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        else { // even
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    public static int findKth(int A[], int B[], int k,
                              int aStart, int aEnd, int bStart, int bEnd) {

        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;

        // Handle special cases
        if (aLen == 0)
            return B[bStart + k];
        if (bLen == 0)
            return A[aStart + k];
        if (k == 0)
            return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

        int aMid = aLen * k / (aLen + bLen); // a's middle count
        int bMid = k - aMid - 1; // b's middle count

        // make aMid and bMid to be array index
        aMid = aMid + aStart;
        bMid = bMid + bStart;

        if (A[aMid] > B[bMid]) {
            k = k - (bMid - bStart + 1);
            aEnd = aMid;
            bStart = bMid + 1;
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }

        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }


}
