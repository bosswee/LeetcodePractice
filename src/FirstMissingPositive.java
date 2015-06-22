/**
 * Created by Wee on 2015/5/20.
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 [����˼·]
 //��ʵ����Ͱ����ֻ���������ö���ռ䡣
 �����������Ŀ���ҪO(n)�ⷨ����Ҫ�õ�hash table��������Ҫ��constant space�����Կ��������鱾����Ϊһ��"hash table"��A[0] = 1, A[1] = 2, ....
 A[n-1] = n��Ŀ���Ǿ����ܽ�����i�ŵ������i-1��λ�á�
 ɨ��������ÿ������
 1. ���A[i]<1����A[i]>n��˵��A[i]һ������first missing positive������
 2. ���A[i] = i+1��˵��A[i]�Ѿ�����ȷ��λ�ã�����
 3. ���A[i]!=i+1����0<A[i]<=n��Ӧ����A[i]�ŵ�A[A[i]-1]��λ�ã����Կ��Խ���������
 ����ע�⣬��A[i] = A[A[i]-1]ʱ��������ѭ�������������ֱ��������


 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] >=1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;//���A[i] = i+1��˵��A[i]�Ѿ�����ȷ��λ�ã�����
        }
        for (i = 0; i < A.length; i++) {
            if (A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }
}
