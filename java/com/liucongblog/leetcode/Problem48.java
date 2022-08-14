package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem48</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/14
 */
public class Problem48 {
    /**
     * 48. Rotate Image
     * <p>
     * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
     * <p>
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: matrix = [[1,2,3},{4,5,6},{7,8,9]]
     * Output: [[7,4,1},{8,5,2},{9,6,3]]
     * Example 2:
     * <p>
     * <p>
     * Input: matrix = [[5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16]]
     * Output: [[15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        if(matrix.length==1){
            return;
        }
        int n = matrix.length;
        for (int i = 0; i <= n/2-1; i++) {
            for (int j = i; j <n-1-i ; j++) {
                int num1=matrix[i][j];
                int num2=matrix[j][n-1-i];
                int num3=matrix[n-1-i][n-1-j];
                int num4=matrix[n-1-j][i];
                //switch numbers
                matrix[i][j]=num4;
                matrix[j][n-1-i]=num1;
                matrix[n-1-i][n-1-j]=num2;
                matrix[n-1-j][i]=num3;
            }
        }
    }

    public static void main(String[] args) {
        int[][] toBeRotated=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        System.out.println(Arrays.deepToString(toBeRotated));
        rotate(toBeRotated);
        System.out.println("After Rotated:");
        System.out.println(Arrays.deepToString(toBeRotated));
    }
}
