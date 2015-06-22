/**
 * Created by Wee on 2015/4/24.
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?
 //这题C++的表达能力更强

 /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
 */
/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/

public class RotateImage {
    //留待研究


    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int y = 0; y < n / 2; y++) {
            for (int x = y; x < n - y - 1; x++) {
                int temp = matrix[y][x];
                temp = move(matrix, temp, (n - 1) - y, x);
                temp = move(matrix, temp, (n - 1) - x, (n - 1) - y);
                temp = move(matrix, temp, y, (n - 1) - x);
                temp = move(matrix, temp, x, y);
            }
        }
    }

    public int move(int[][] matrix, int val, int x, int y) {
        int store = matrix[y][x];
        matrix[y][x] = val;
        return store;
    }
}
