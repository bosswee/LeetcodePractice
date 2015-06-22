import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/5/25.
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must
 begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 gray code�������и����룬һ�����֪����ģ�����ͣ�д�������ӳ����ҹ��ɡ�
 ��3λ������Ϊ����
 0 0 0
 0 0 1
 0 1 1
 0 1 0
 1 1 0
 1 1 1
 1 0 1
 1 0 0
 ���Կ�����nλ�ĸ������������ֹ��ɣ�һ������n-1λ�����룬�ټ��� 1<<(n-1)��n-1λ�����������ĺ͡�

 �ҵ����ɺ�ͺð��ˣ�����AC��
 n = 1

 0
 1

 n=2

 0 0
 0 1
 1 1
 1 0

 n=3

 0 0 0
 0 0 1
 0 1 1
 0 1 0
 1 1 0
 1 1 1
 1 0 1
 1 0 0
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
            if (n == 0) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(0);
                return result;
            }

            List<Integer> tmp = grayCode(n - 1);//�ݹ����
            int addNumber = 1 << (n - 1);
            ArrayList<Integer> result = new ArrayList<Integer>(tmp);
            for (int i = tmp.size() - 1; i >= 0; i--) {
                result.add(addNumber + tmp.get(i));
            }
            return result;
        }

}
