package Array;

/**
 * Created by Wee on 2015/5/21.
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle
 * in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given height = [2,1,5,6,2,3],
 return 10.
 参考： http://blog.csdn.net/abcbc/article/details/8943485
 */
public class LargestRectangle {
    //O(n2)基本思想就是遍历所有[i, j]，并在过程中找出中间最矮的bar，得出从i到j的矩形面积。TLE
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] min = new int[height.length];
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] != 0 && maxArea / height[i] >= (height.length - i)) {
                continue;
            }
            for (int j = i; j < height.length; j++) {
                if (i == j) min[j] = height[j];
                else {
                    if (height[j] < min[j - 1]) {
                        min[j] = height[j];
                    } else min[j] = min[j - 1];
                }
                int tentativeArea = min[j] * (j - i + 1);
                if (tentativeArea > maxArea) {
                    maxArea = tentativeArea;
                }
            }
        }
        return maxArea;
    }

    //用剪枝勉强过


    // Todo:O(n^2) with pruning
    public int largestRectangleArea1(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] < height[k - 1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int lowest = height[i];
            for (int j = i; j >= 0; j--) {
                if (height[j] < lowest) {
                    lowest = height[j];
                }
                int currArea = (i - j + 1) * lowest;
                if (currArea > area) {
                    area = currArea;
                }
            }
        }
        return area;
    }


    //Todo:用stack
    // O(n^2) with pruning
    public int largestRectangleArea12(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int k = i + 1; k < height.length; k++) {
                if (height[k] < height[k - 1]) {
                    i = k - 1;
                    break;
                } else {
                    i = k;
                }
            }
            int lowest = height[i];
            for (int j = i; j >= 0; j--) {
                if (height[j] < lowest) {
                    lowest = height[j];
                }
                int currArea = (i - j + 1) * lowest;
                if (currArea > area) {
                    area = currArea;
                }
            }
        }
        return area;
    }

}
