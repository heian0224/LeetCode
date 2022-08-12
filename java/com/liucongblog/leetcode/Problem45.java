package com.liucongblog.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem45</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/12
 */
public class Problem45 {

    /**
     * 45.  Jump to Game II
     * <p>
     * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
     * <p>
     * Each element in the array represents your maximum jump length at that position.
     * <p>
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p>
     * You can assume that you can always reach the last index.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: nums = [2,3,0,1,4]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     *
     * @param nums an array
     * @return
     */
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] == 0) {
            return Integer.MAX_VALUE;
        }
        int first = nums[0];
        if (first >= nums.length - 1) {
            return 1;
        }
        //minimal index to end.
        int minIndex=Integer.MAX_VALUE;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]+i>=nums.length-1&&i<minIndex){
                minIndex=i;
            }
        }


        return jump(Arrays.copyOfRange(nums,0,minIndex+1))+1;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{4,0,6,2,3,7,2,4,0}));
    }
}
