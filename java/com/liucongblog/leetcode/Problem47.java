package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem47</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/13
 */
public class Problem47 {
    /**
     * 47. Permutations II
     * <p>
     * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,1,2]
     * Output:
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * Example 2:
     * <p>
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[0]);
            res.add(sub);
            return res;
        }
        List<List<Integer>> subResList = permuteUnique(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> subRes : subResList) {
            for (int j = 0; j < nums.length; j++) {
                if (j < subRes.size() && subRes.get(j) == nums[0]) {
                    continue;
                }
                List<Integer> copied = new ArrayList<>(List.copyOf(subRes));
                copied.add(j, nums[0]);
                res.add(copied);
            }
        }


        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }


}
