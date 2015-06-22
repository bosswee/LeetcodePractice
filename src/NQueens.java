import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wee on 2015/4/18.
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space
 respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:
 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */
public class NQueens {
    //这种棋盘类的题目一般是回溯法,依次放置每行的皇后。在放置的时候，要保持当前的状态为合法，
    // 即当前放置位置的同一行、同一列、两条对角线上都不存在皇后。
    //其实本质还是DFS,只是加一个判断，然后把结果转化成string
   private static List<String[]> list = new ArrayList<String[]>();


    public static List<String[]> solveNQueens(int n) {

        int[][] b = new int[n][n];
      dfs(b,0,n);
        return list;
    }
    
    private static void dfs(int[][] b,int col,int n){
        if (col==n){
            list.add(printS(b,n));
            return;
        }
        for(int row=0;row<n;row++){
            if (isSafe(b,row,col,n)){
                b[row][col]=1;
                dfs(b,col+1,n);
                b[row][col]=0;
            }
        }
    }

    private static String[] printS(int[][] b, int n) {
        String[] strings = new String[n];

        for (int i = 0; i <n ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <n ; j++) {


                if(b[i][j]==1){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            strings[i]= sb.toString();
            sb.delete(0,sb.length()-1);
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

    public static void main(String[] args) {
        System.out.print((solveNQueens(4)).toString());
    }


}
