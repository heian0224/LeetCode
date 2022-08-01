package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem33</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/31
 */
public class Problem33 {
    /***
     * 33. Search in Rotated Sorted Array
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * All values of nums are unique.
     * nums is an ascending array that is possibly rotated.
     * -104 <= target <= 104
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        if (target == nums[leftIndex]) {
            return leftIndex;
        }
        if (target == nums[rightIndex]) {
            return rightIndex;
        }

        while (leftIndex + 1 < rightIndex) {
            int leftNum = nums[leftIndex];
            int rightNum = nums[rightIndex];
            int middleIndex = (leftIndex + rightIndex) / 2;
            int middleNum = nums[middleIndex];
            if (target == leftNum) {
                return leftIndex;
            }
            if (target == rightNum) {
                return rightIndex;
            }
            if (target == middleNum) {
                return middleIndex;
            }
            if (target < leftNum && target > rightNum) {
                return -1;
            }
            if (middleNum > leftNum) {
                //rotate index in right area
                if (target > leftNum && target < middleNum) {
                    rightIndex = middleIndex;
                } else {
                    leftIndex = middleIndex;
                }

            } else {
                //rotate index in left area
                if (target < rightNum && target > middleNum) {
                    leftIndex = middleIndex;
                } else {
                    rightIndex = middleIndex;
                }
            }

        }


        return -1;

    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1}, 3));
    }
}
