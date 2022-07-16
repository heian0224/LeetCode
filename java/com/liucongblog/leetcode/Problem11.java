package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem11</p>
 * <p>Description: Solution for Problem 11</p>
 *
 * @author Cong
 * @date 2022/7/10
 */
public class Problem11 {
    public static int maxArea(int[] height) {
        if (height== null){
            return 0;
        }
        int maxArea=0;
        int leftIndex=0;
        int rightIndex= height.length-1;
        while (leftIndex<rightIndex){
            int leftHeight= height[leftIndex];
            int rightHeight = height[rightIndex];

            if(leftHeight<rightHeight){
                int currentArea= (rightIndex-leftIndex)*leftHeight;
                if(currentArea>maxArea){
                    maxArea=currentArea;
                }

                    leftIndex++;

            }else {
                int currentArea= (rightIndex-leftIndex)*rightHeight;
                if(currentArea>maxArea){
                    maxArea=currentArea;
                }

                    rightIndex--;

            }

        }


        return maxArea;

    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,2,5,25,24,5}));
    }
}
