import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/22.
 */
public class NQueensTwo {

    private static List<String[]> list = new ArrayList<String[]>();
    public int totalNQueens(int n) {
        int[][] b = new int[n][n];
        dfs(b, 0, n);
        return list.size();
    }

    private static void dfs(int[][] b, int col, int n) {
        if (col == n) {
            list.add(printS(b, n));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(b, row, col, n)) {
                b[row][col] = 1;
                dfs(b, col + 1, n);
                b[row][col] = 0;
            }
        }
    }

    private static String[] printS(int[][] b, int n) {
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {


                if (b[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            strings[i] = sb.toString();
            sb.delete(0, sb.length() - 1);
        }
        return strings;
    }

    private static boolean isSafe(int[][] b, int x, int y, int n) {

        for (int i = 0; i < n; i++) {
            if (b[x][i] == 1 || b[i][y] == 1) {
                return false;//同行同列不存在皇后
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if ((i + j == x + y) && b[i][j] == 1) {
                    return false;
                }//左对角线不存在
            }
        for (int i = 0; i < n; i++) {
            if (x - i >= 0 && y - i >= 0 && b[x - i][y - i] == 1) {
                return false;
            }
            if (x + i < n && y + i < n && b[x + i][y + i] == 1) {
                return false;
            }//右对角线不存在
        }
        return true;




    }
}
