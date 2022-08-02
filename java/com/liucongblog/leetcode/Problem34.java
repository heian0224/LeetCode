package com.liucongblog.leetcode;

import java.util.Arrays;

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
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        if (target == nums[0] && target == nums[nums.length - 1]) {
            return new int[]{0, nums.length - 1};
        }
        if (nums.length == 2) {
            if (nums[0] == target && nums[1] != target) {
                return new int[]{0, 0};
            }
            if (nums[0] == target && nums[1] == target) {
                return new int[]{0, 1};
            }
            if (nums[0] != target && nums[1] == target) {
                return new int[]{1, 1};
            }
        }
        int foundedIndex = -1;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        if (nums[leftIndex] == target || nums[rightIndex] == target) {
            foundedIndex = nums[leftIndex] == target ? leftIndex : rightIndex;
        } else {
            while (leftIndex + 1 < rightIndex) {
                int middleIndex = (leftIndex + rightIndex) / 2;
                int middleNum = nums[middleIndex];
                if (target == middleNum) {
                    foundedIndex = middleIndex;
                    break;
                }
                if (middleNum < target) {
                    leftIndex = middleIndex;
                } else {
                    rightIndex = middleIndex;
                }
            }
        }
        if (foundedIndex == -1) {
            return new int[]{-1, -1};
        }
        int resStartIndex = foundedIndex;
        int resEndIndex = foundedIndex;
        if (foundedIndex == leftIndex) {
            resStartIndex = leftIndex;
        } else {
            int startIndex = leftIndex;
            int endIndex = foundedIndex;
            if (endIndex == startIndex + 1) {
                resStartIndex = endIndex;
            } else {
                // find first one that equal target and previous one less than target.
                while (startIndex + 1 < endIndex) {
                    int middleIndex = (startIndex + endIndex) / 2;
                    int middleNum = nums[middleIndex];

                    if (target == middleNum && (middleIndex == 0 || nums[middleIndex - 1] < target)) {
                        resStartIndex = middleIndex;
                        break;
                    }
                    if (middleNum < target) {
                        startIndex = middleIndex;
                    } else {
                        endIndex = middleIndex;
                    }
                }
            }

        }
        if (foundedIndex == rightIndex) {
            resEndIndex = rightIndex;
        } else {
            int startIndex = foundedIndex;
            int endIndex = rightIndex;
            if (endIndex == startIndex + 1) {
                resEndIndex = startIndex;
            } else {
                // find first one that equal target and follow one greater than target.
                while (startIndex + 1 < endIndex) {
                    int middleIndex = (startIndex + endIndex) / 2;
                    int middleNum = nums[middleIndex];

                    if (target == middleNum && (middleIndex == nums.length - 1 || nums[middleIndex + 1] > target)) {
                        resEndIndex = middleIndex;
                        break;
                    }
                    if (middleNum > target) {
                        endIndex = middleIndex;
                    } else {
                        startIndex = middleIndex;
                    }
                }
            }
        }
        return new int[]{resStartIndex, resEndIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{3, 3, 3}, 3)));
    }
}
