package Array;

/**
 * Created by Wee on 2015/5/20.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 This is a typical problem of binary search.

 You may try to solve this problem by finding the row first and then the column. There is no need to do that. Because of the matrix's special
 features, the matrix can be considered as a sorted array. Your goal is to find one element in this sorted array by using binary search.
 方法2：做两次二分就好了，首先二分第一列，找出target所在的行，然后二分该行。
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row_num = matrix.length;
        int col_num = matrix[0].length;

        int begin = 0, end = row_num * col_num - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;
            int mid_value = matrix[mid / col_num][mid % col_num];

            if (mid_value == target) {
                return true;

            } else if (mid_value < target) {
                //Should move a bit further, otherwise dead loop.
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int l = 0;
        int r = matrix.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int row = r;
        if (row < 0)
            return false;
        l = 0;
        r = matrix[0].length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
