import java.util.Stack;

/**
 * Created by Wee on 2015/5/21.
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * http://www.cnblogs.com/lichen782/p/leetcode_maximal_rectangle.html
 */
public class MaximalRectangle {

    //O(n3)解法：遍历，求每个点的最大面积
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {//row
            for (int j = 0; j < n; j++) {//col
                if (matrix[i][j] == '1') {
                    int area = maxRectangle(matrix, i, j);
                    if (area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }
    private int maxRectangle(char[][] matrix, int row, int col) {
        int minWidth = Integer.MAX_VALUE;
        int maxArea = 0;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
            int width = 0;
            while (col + width < matrix[row].length
                    && matrix[i][col + width] == '1') {
                width++;
            }
            if (width < minWidth) {// 如果当前宽度小于了以前的最小宽度，更新它，为下面的矩形计算做准备
                minWidth = width;
            }
            int area = minWidth * (i - row + 1);
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
        //Todo:采用上一题的做法，把求每个点的maxarea的复杂度降低到O(n)
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];
        //actually we know that height can just be a int[n+1],
        //however, in that case, we have to write the 2 parts together in row traverse,
        //which, leetcode just doesn't make you pass big set
        //所以啊，leetcode是喜欢分开写循环的，即使时间复杂度一样，即使可以节约空间
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}
