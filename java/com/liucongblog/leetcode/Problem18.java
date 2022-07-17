package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem18</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/17
 */
public class Problem18 {
    /**
     * 18. 4Sum
     * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,0,-1,0,-2,2], target = 0
     * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * Example 2:
     *
     * Input: nums = [2,2,2,2,2], target = 8
     * Output: [[2,2,2,2]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     *
     * @param nums
     * @param target
     * @return all  unique quadruplets sum is target
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null || nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        Integer previousFirst = null;
        Integer previousSecond = null;
        Integer previousI=null;
        Integer previousJ=null;
        for (int i = 0; i <nums.length-3 ; i++) {
            if(previousI!=null&& nums[i]==previousI){
                continue;
            }
            previousI=nums[i];
            for (int j = nums.length-1; j >i+2 ; j--) {
                if(previousJ!=null&& nums[j]==previousJ){
                    continue;
                }
                previousJ=nums[j];
                if(previousFirst!=null && previousSecond!=null && previousFirst==nums[i]&&previousSecond==nums[j]){
                    continue;
                }
                int leftIndex=i+1;
                int rightIndex=j-1;
                while (leftIndex<rightIndex){
                    long sum =(long)nums[i]+(long)nums[j]+(long)nums[leftIndex]+(long)nums[rightIndex];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[leftIndex],nums[rightIndex]));
                        previousFirst=nums[i];
                        previousSecond=nums[j];
                        while(rightIndex>=i+2&& nums[rightIndex]==nums[rightIndex-1]){rightIndex--;}
                        rightIndex--;
                    }else if(sum>target){
                        rightIndex--;
                    }else {
                        leftIndex++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{2,0,3,0,1,2,4},7));
    }
}
