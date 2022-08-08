package com.liucongblog.leetcode;

import java.util.Stack;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem41</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/7
 */
public class Problem41 {
    /**
     * 41. First Missing Positive
     * Given an unsorted integer array nums, return the smallest missing positive integer.
     * <p>
     * You must implement an algorithm that runs in O(n) time and uses constant extra space.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,0]
     * Output: 3
     * Example 2:
     * <p>
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Example 3:
     * <p>
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 5 * 105
     * -231 <= nums[i] <= 231 - 1
     *
     * @param nums an unsorted integer array nums
     * @return the smallest missing positive integer
     */
    public static int firstMissingPositive(int[] nums) {
        if(nums.length==1){
            return nums[0]==1?2:1;
        }
        //Cyclic Sort
        int index = 0;
        while (index < nums.length) {
            int current = nums[index];
            if (current < 0 || current > nums.length - 1 || current == index) {
                index++;
            } else {
                //swap index and current
                int tmp = nums[current];
                nums[current] = current;
                nums[index] = tmp;
            }
        }
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
    }
}