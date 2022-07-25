package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem26</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/25
 */
public class Problem26 {
    /**
     * 26. Remove Duplicates from Sorted Array
     * <p>
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
     * <p>
     * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
     * <p>
     * Return k after placing the final result in the first k slots of nums.
     * <p>
     * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     * <p>
     * Custom Judge:
     * <p>
     * The judge will test your solution with the following code:
     * <p>
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     * <p>
     * int k = removeDuplicates(nums); // Calls your implementation
     * <p>
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     * assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     * <p>
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] replaceNums = new int[nums.length];
        Integer loopNum = null;
        int result = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (loopNum == null || loopNum != nums[i]) {
                loopNum = nums[i];
                result++;
                replaceNums[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = replaceNums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tobeReplacedNums = new int[]{1, 1, 2};
        int result = removeDuplicates(tobeReplacedNums);
        System.out.println(result);
        System.out.println(Arrays.toString(tobeReplacedNums));
    }
}
