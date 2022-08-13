package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem46</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/12
 */
public class Problem46 {
    /**
     * 46. Permutations
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     * <p>
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * Example 3:
     * <p>
     * Input: nums = [1]
     * Output: [[1]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * All the integers of nums are unique.
     *
     * @param nums
     * @return
     */
    public  static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length==0){
            return res;
        }

        if(nums.length==1){
            List<Integer> sub=new ArrayList<>();
            sub.add(nums[0]);
            res.add(sub);
            return res;
        }
        List<List<Integer>> subResList=permute(Arrays.copyOfRange(nums,1,nums.length));
        for (List<Integer> subRes : subResList) {
            for (int j = 0; j < nums.length; j++) {
                List<Integer> copied = new ArrayList<>(List.copyOf(subRes));
                copied.add(j, nums[0]);
                res.add(copied);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{0,1,2}));
    }
}
