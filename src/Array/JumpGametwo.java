package Array;

/**
 * Created by Wee on 2015/5/19.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 �Ƚϵ��͵�̰�ġ�ά��һ�����䣬�����ʾ��i�����ܵ����������Χ�����Ƶķ���Ϊ��
 ÿ�ζ�����һ�鵱ǰ�����ڵ�����Ԫ�أ���һ��Ԫ�س�������Զ�ɴ������index+array[index]����ô��һ���������˵���ǵ�ǰ������Ҷ˵�+1����һ��������Ҷ˵���ǵ�ǰ�����max
 (index+array[index])���Դ����ƣ�ֱ������������յ㣬ͳ�Ƶ�ǰ�������ɡ�

 ʵ�ִ��룺
 */
public class JumpGametwo {

    public int jump(int[] A) {
            if (A.length == 1)
                return 0;
            int max = 0, count = 1, begin = 0, end = A[0];
            while (end < A.length - 1) {
                count++;
                int index = begin;//��Ϊindex֮��Ҫ�ã����Է���ѭ����
                for (; index <= end; index++) {
                    max = Math.max(max, index + A[index]);
                }
                begin = index;
                end = max;
            }
            return count;
        }

}
