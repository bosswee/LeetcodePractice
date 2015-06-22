import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/26.
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 Solution 1:

 使用递归，一次扫描一整圈，然后用x,y记录这个圈的左上角，递归完了都+1。rows, cols记录还没扫的有多少。思想比较简单，但相当容易出错。起码提交了5次才最后过。

 注意：1. 扫描第一行跟最后一行要扫到底部为止，而扫描左列和右列只需要扫中间的。

 1  2  3   4

 5  6  7   8

 9 10 11 12

 例如以上例子： 你要 先扫1234, 然后是8，然后是12 11 10 9 然后是 5.

 不能这样：123, 4 8, 12 11 10 , 9 5。 用后者的方法在只有一个数字 1的时候 就完全不会扫到它。
 */
public class SpiralMatrix {
    //留待研究，关于矩阵的问题，技巧好像都差不多。。。
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0
                || matrix[0].length == 0) {
            return ret;
        }

        rec(matrix, 0, 0, matrix.length, matrix[0].length, ret);

        return ret;
    }

    public static void rec(int[][] matrix, int x, int y, int rows, int cols, List<Integer> ret) {
        if (rows <= 0 || cols <= 0) {
            return;
        }

        // first line
        for (int i = 0; i < cols; i++) {
            ret.add(matrix[x][y + i]);
        }

        // right column
        for (int i = 1; i < rows - 1; i++) {
            ret.add(matrix[x + i][y + cols - 1]);
        }

        // down row
        if (rows > 1) {
            for (int i = cols - 1; i >= 0; i--) {
                ret.add(matrix[x + rows - 1][y + i]);
            }
        }

        // left column. GO UP.
        if (cols > 1) {
            for (int i = rows - 2; i > 0; i--) {
                ret.add(matrix[x + i][y]);
            }
        }

        rec(matrix, x + 1, y + 1, rows - 2, cols - 2, ret);
    }
}

