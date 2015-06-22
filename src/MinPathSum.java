/**
 * Created by Wee on 2015/4/12.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers
 * along its path.

 Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {


    public int minPathSum(int[][] grid) {
        //求到每个节点的最短路径，重复子问题，二维DP
        int m =grid.length;
        int n = grid[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (j==0&&i==0){
                    grid[i][j]= grid[i][j];
                }else if(j==0&&i!=0){
                    grid[i][j]=grid[i][j]+grid[i-1][j];
                }else if(j!=0&&i==0){
                    grid[i][j]=grid[i][j]+grid[i][j-1];
                }else {
                    grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }

        }
        return  grid[m-1][n-1];

    }
}