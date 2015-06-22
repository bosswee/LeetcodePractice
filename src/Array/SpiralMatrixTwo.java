package Array;

/**
 * Created by Wee on 2015/4/26.
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 与Spriral Matrix（
 http://fisherlei.blogspot.com/2013/01/l
 eetcode-spiral-matrix.html）类似，
 区别在于一个用递归来剥皮，一个用递归来构造。Code可以复用。

 */
public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int num = 1;
        int level = (int) Math.ceil(n / 2.);

        for (int i = 0; i < level; i++) {

            // top left -> right, shown as #
            for (int j = i; j < n - i; j++)
                res[i][j] = num++;

            // top right + 1 -> bot, shown as $
            for (int j = i + 1; j < n - i; j++)
                res[j][n - i - 1] = num++;

            // bot right - 1 -> left, shown as &
            for (int j = n - i - 2; j >= i; j--)
                res[n - i - 1][j] = num++;

            // bot left -1 -> top + 1, shown as %
            for (int j = n - i - 2; j > i; j--)
                res[j][i] = num++;
        }
        return res;

    }

    public int[][] generateMatrix2(int n) {
        if (n < 0)
            return null;
        int[][] res = new int[n][n];
        int levelNum = n / 2;
        int num = 1;
        for (int l = 0; l < levelNum; l++) {
            for (int i = l; i < n - l; i++) {
                res[l][i] = num++;
            }
            for (int i = l + 1; i < n - l; i++) {
                res[i][n - 1 - l] = num++;
            }
            for (int i = n - 2 - l; i >= l; i--) {
                res[n - 1 - l][i] = num++;
            }
            for (int i = n - 2 - l; i > l; i--) {
                res[i][l] = num++;
            }
        }
        if (n % 2 == 1) {
            res[levelNum][levelNum] = num;
        }
        return res;
    }
}
