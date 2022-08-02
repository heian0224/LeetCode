package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem34</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/2
 */
public class Problem34 {
    /**
     * 34. Find First and Last Position of Element in Sorted Array
     * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
     * <p>
     * If target is not found in the array, return [-1, -1].
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Example 3:
     * <p>
     * Input: nums = [], target = 0
     * Output: [-1,-1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums is a non-decreasing array.
     * -109 <= target <= 109
     *
     * @param nums   an array of integers nums sorted in non-decreasing order
     * @param target target value.
     * @return the starting and ending position of a given target value. If target is not found in the array, return [-1, -1].
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1,-1};
        }
        if(target<nums[0]|| target>nums[nums.length-1]){
            return new int[]{-1,-1};
        }



        return new int[]{1};
    }
}
