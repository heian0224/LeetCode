package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem59</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/29
 */
public class Problem59 {
    private static final int RIGHT_DIRECTION=1;
    private static final int BOTTOM_DIRECTION=2;
    private static final int LEFT_DIRECTION=3;
    private static final int TOP_DIRECTION=4;


    /**
     * 59. Spiral Matrix II
     * <p>
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     * Example 2:
     * <p>
     * Input: n = 1
     * Output: [[1]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 20
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int direction=RIGHT_DIRECTION;
        int[][] res=new int[n][n];
        int val=1;
        int firstIndex=0;
        int secondIndex=0;
        while (val<=n*n){
            res[firstIndex][secondIndex]=val;
            //next
            val++;
            //next direction
            if(direction==RIGHT_DIRECTION&&firstIndex+secondIndex==n-1){
                direction=BOTTOM_DIRECTION;
            }
            if(direction==BOTTOM_DIRECTION&&firstIndex==secondIndex){
                direction=LEFT_DIRECTION;
            }

            if(direction==LEFT_DIRECTION&&firstIndex+secondIndex==n-1){
                direction=TOP_DIRECTION;
            }
            if(direction==TOP_DIRECTION&&firstIndex-1==secondIndex){
                direction=RIGHT_DIRECTION;
            }

            //next index
            if(direction==RIGHT_DIRECTION){
                secondIndex++;
            }

            if(direction==BOTTOM_DIRECTION){
                firstIndex++;
            }
            if(direction==LEFT_DIRECTION){
                secondIndex--;
            }
            if(direction==TOP_DIRECTION){
                firstIndex--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }
}
