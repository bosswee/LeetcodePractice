package TwoPointers;

/**
 * Created by Wee on 2015/5/18.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap
 * after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 �ǳ�����˼��һ���⣬�ؼ����ҵ���ˮ���Ĺ�ʽ��ͬʱӦ��DP
 1. ��������ɨ��һ�飬����ÿһ�����꣬��ȡ������ֵ��
 2. ��������ɨ��һ�飬����ÿһ�����꣬�������ֵ��
 3. ��ɨ��һ�飬��ȡ�ݻ����Ӻ͡�
 #2��#3���Ժϲ���һ��ѭ����
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//		int[] A = {2,0,2};
        System.out.println(trap(A));
    }

    // �ؼ��������ҵ����ɣ�
    // ����i��ط��Ĵ�ˮ�� = min(��i�������ߵ�bar�߶�, ��i���ұ���ߵ�bar�ĸ߶�) - ��i��ط�bar�ĸ߶�
    // ����ͼ�У���5��ط��Ĵ�ˮ�� = min(2,3)-0 = 2
    // 2Ϊ�������ߵ�bar������3��ط���bar
    // 3Ϊ���ұ���ߵ�bar������7��ط���bar��
    // 0Ϊ�������bar�߶�
    public static int trap(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        // ����DP���left, right����
        // left�����¼����ǰiΪֹ�������ߵ�bar
        // right�����¼����ǰiΪֹ���ұ���ߵ�bar
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        left[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        right[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }

//		System.out.println(Arrays.toString(left));
//		System.out.println(Arrays.toString(right));

        int sum = 0;
        for (int i = 1; i < A.length - 1; i++) {
            sum += Math.min(left[i], right[i]) - A[i];//�ڶ���ɨ���ʱ��Ϳ��Լ����ˣ�������������
        }

        return sum;
    }
}
