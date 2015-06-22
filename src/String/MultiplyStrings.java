package String;

/**
 * Created by Wee on 2015/5/17.
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
 ����һ���������˷���һλһλ���ϳˣ�ע���λ�Ĵ����ɡ����⣬ע��0�Ĵ���
 ��������˼·��
 1 ��תstring
 2 �������飬˫��ѭ����������string���ѵ�λ�ĳ˻��ۼӵ�������Ӧ��λ��
 3 �����λ�����
 4 ע��ǰ�����corner case
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        //�ַ�����Ϊ����Ҫ����������⣬�ݹ���������Ȼ����ˡ�
        //�������ַ����ŵ������ֱ�ӴӺ���ǰ��λ��˴�ӡ����
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = product.length - 1; i > 0; i--) {
            if (stringBuilder.length() == 0 && product[i] == 0)
                continue;
            stringBuilder.append(product[i]);
        }
        stringBuilder.append(product[0]);
        return stringBuilder.toString();


    }


    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        System.out.println(multiply2(num1, num2));
    }

    //��ת��д��

    public static String multiply2(String num1, String num2) {
        // �Ȱ�string��ת
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[n1.length() + n2.length()];        // ���������ų˻�
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');        // ����ȷλ���ۼӳ˻�
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;        // ��ǰλ
            int carry = d[i] / 10;        // ��λ
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, digit);        // prepend
        }

        // �Ƴ�ǰ����
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
