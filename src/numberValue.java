import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Wee on 2015/2/1.
 * 练习数值计算。找出一个整数数组中子数组之和的最大值，例如：数组[1, -2, 3, 5, -1]，
 * 返回8（因为符合要求的子数组是 [3, 5]）；数组[1, -2, 3, -8, 5, 1]，返回6（因为符合要求的子数组是 [5, 1]）;
 * 数组[1, -2, 3,-2, 5, 1]，返回7（因为符合要求的子数组是 [3, -2, 5, 1]）。
 */
public class numberValue {
    public static void main(String[] args) {
        int[] a = {1, -2, 8, 7, -1};
        List<Integer> tmp = new ArrayList();
        for (int i = 0; i < a.length; i++) {
            tmp.add(a[i]);
        }
        Collections.sort(tmp);
        int big1 = tmp.get(tmp.size() - 1);
        int big2 = tmp.get(tmp.size() - 2);

        System.out.println(big1 + big2);


    }
}

