package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problemj40</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/7
 */
public class Problem40 {
    /**
     * 40. Combination Sum II
     * <p>
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
     * <p>
     * Each number in candidates may only be used once in the combination.
     * <p>
     * Note: The solution set must not contain duplicate combinations.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8
     * Output:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,5,2,1,2], target = 5
     * Output:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= candidates.length <= 100
     * 1 <= candidates[i] <= 50
     * 1 <= target <= 30
     *
     * @param candidates a collection of candidate numbers
     * @param target     target number
     * @return all unique combinations in candidates where the candidate numbers sum to target（Each number in candidates may only be used once in the combination）
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null | candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 1) {
            if (target == candidates[0]) {
                List<Integer> sub = new ArrayList<>();
                sub.add(candidates[0]);
                res.add(sub);
                return res;
            } else {
                return new ArrayList<>();
            }
        }
        Integer previous = null;
        for (int i = 0; i < candidates.length; i++) {
            int current = candidates[i];
            if (previous!=null&&current == previous) {
                continue;
            }
            previous = current;
            if (target == current) {
                List<Integer> sub = new ArrayList<>();
                sub.add(current);
                res.add(sub);
            }
            int subTarget = target - current;
            int finalI = i;
            int[] subCandidates = IntStream.range(0, candidates.length)
                    .filter(index -> index > finalI)
                    .map(index -> candidates[index]).toArray();
            if (subTarget > 0) {
                List<List<Integer>> subResult = combinationSum2(subCandidates, subTarget);
                if (subResult.size() > 0) {
                    for (List<Integer> currentSubRes : subResult) {
                        currentSubRes.add(current);
                        res.add(currentSubRes);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
