package DP;

/**
 * Created by Wee on 2015/5/18.
 * Follow up for "Unique Paths":
 * The robot can only move either down or right at any point in time.

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 ������Unique Paths�ǳ����ƣ�ֻ�������������˼����ϰ�������ÿ�ζ�������ѡ�����ң����£��ˡ���Ϊ�����������������Unique Paths�����һ��ֱ������ϵķ����Ͳ������ˣ�������õĽⷨ�����ö�̬�滮�ˡ�����ʽ���Ǹ�Unique
 Pathsһ����ֻ��ÿ������Ҫ�ж�һ���ǲ����ϰ�������ǣ���res[i][j]=0��������res[i][j]=res[i-1][j]+res[i][j-1]��ʵ���л���ֻ��Ҫһ��һά���飬��Ϊ���µ�ʱ������Ҫ����Ϣ�㹻�ˡ������ռ临�Ӷ�����O(n)����ͬUnique
 Paths�з����ģ����Ҫ�����Ͻ������ǿ���ȥ�к�����С���Ǹ���Ȼ���С�ķ����ڲ�ѭ�����ռ临�ӶȾ���O(min(m,n))��ʱ�临�ӶȻ���O(m*n)��
 */
public class UniquePathsTwo {
        public int uniquePathsWithObstacles ( int[][] obstacleGrid){
            //wrong
            if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
                return 0;
             int m = obstacleGrid.length;
             int n = obstacleGrid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                  if (obstacleGrid[i][j]==1){
                      obstacleGrid[i][j]=-1;
                  }
                }
            }

            
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][0] != -1)
                obstacleGrid[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[0][j] != -1)
                obstacleGrid[0][j] = 1;
            }
            if (m==1||n==1) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (obstacleGrid[i][j] == -1) {
                            return 0;
                        }
                    }

                }
                return 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] != -1){
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    }else{
                        obstacleGrid[i][j]=0;
                    }
                }
            }
            return obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {

        //Empty case
        if (obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if (i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if (i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;// For row 0, if there are no paths to left cell, then its 0,else 1
                else if (j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }

        return obstacleGrid[rows - 1][cols - 1];

    }


    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        //һά�������ⷽ�������о�
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int[] res = new int[obstacleGrid[0].length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else {
                    if (j > 0)
                        res[j] += res[j - 1];
                }
            }
        }
        return res[obstacleGrid[0].length - 1];
    }
}
