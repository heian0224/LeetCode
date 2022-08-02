package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem35</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/3
 */
public class Problem35 {
    /**
     * 35. Search Insert Position
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * <p>
     * You must write an algorithm with O(log n) runtime complexity.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     * <p>
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     * <p>
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     *
     * @param nums a sorted array of distinct integers
     * @param target target value
     * @return the index if the target is found
     */
    public int searchInsert(int[] nums, int target) {
        if(nums==null ||target<nums[0]){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        int leftIndex=0;
        int rightIndex=nums.length-1;
        if(target==nums[leftIndex]||target==nums[rightIndex]){
            return target==nums[leftIndex]?leftIndex:rightIndex;
        }
        int foundedIndex=-1;
        while (leftIndex+1<rightIndex){
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
        if(foundedIndex!=-1){
            return foundedIndex;
        }else {
            return rightIndex;
        }

    }
}
