package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem31</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/30
 */
public class Problem31 {
    /**
     * 31. Next Permutation
     * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
     * <p>
     * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
     * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
     * <p>
     * For example, the next permutation of arr = [1,2,3] is [1,3,2].
     * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
     * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
     * Given an array of integers nums, find the next permutation of nums.
     * <p>
     * The replacement must be in place and use only constant extra memory.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [1,3,2]
     * Example 2:
     * <p>
     * Input: nums = [3,2,1]
     * Output: [1,2,3]
     * Example 3:
     * <p>
     * Input: nums = [1,1,5]
     * Output: [1,5,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     *
     * @param nums an array of integers nums,transfer it to next permutation
     */
    public static void nextPermutation(int[] nums) {
//        Integer[] intArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//        Arrays.sort(intArr, Collections.reverseOrder());
//        for (int i = 0; i < intArr.length; i++) {
//            nums[i] = intArr[i];
//        }
        if (nums.length == 1) {
            return;
        }
        int index = nums.length - 1;
        boolean found = false;
        while (index >= 1) {
            int current = nums[index];
            int next = nums[index - 1];
            if (next < current) {
                found = true;
                break;
            }
            index--;
        }
        if (!found) {
            Arrays.sort(nums);
            return;
        }
        int toBeReplacedIndex=nums.length-1;
        for (int i = nums.length-1; i >= index; i--) {
             if(nums[i]>nums[index-1]){
                 toBeReplacedIndex=i;
                 break;
             }
        }
        //switch index-1's integer and toBeReplacedIndex integer
        int tmp=nums[index-1];
        nums[index-1]=nums[toBeReplacedIndex];
        nums[toBeReplacedIndex]=tmp;
        Arrays.sort(nums,index,nums.length);


    }


    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 1};
        int[] nums = new int[]{1, 3,2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
