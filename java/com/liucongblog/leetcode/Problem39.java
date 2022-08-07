package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem39</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/6
 */
public class Problem39 {
    /**
     * 39. Combination Sum
     * <p>
     * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     * <p>
     * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     * <p>
     * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7
     * Output: [[2,2,3],[7]]
     * Explanation:
     * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
     * 7 is a candidate, and 7 = 7.
     * These are the only two combinations.
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8
     * Output: [[2,2,2,2],[2,3,3],[3,5]]
     * Example 3:
     * <p>
     * Input: candidates = [2], target = 1
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * All elements of candidates are distinct.
     * 1 <= target <= 500
     *
     * @param candidates candidate array
     * @param target     target integer
     * @return a list of all unique combinations of candidates where the chosen numbers sum to target
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null | candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 1) {
            if (target % candidates[0] == 0) {
                List<Integer> sub = new ArrayList<>();
                int count = target / candidates[0];
                for (int i = 0; i < count; i++) {
                    sub.add(candidates[0]);
                }
                res.add(sub);
                return res;
            } else {
                return new ArrayList<>();
            }
        }
        for (int i = 0; i < candidates.length; i++) {
            int current = candidates[i];
            int count = target / current;
            if (target % current == 0) {
                List<Integer> sub = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    sub.add(current);
                }
                res.add(sub);
            }
            for (int j = 1; j <= count; j++) {
                int subTarget = target - j * current;
                int finalI = i;
                int[] subCandidates = IntStream.range(0, candidates.length)
                        .filter(index -> index > finalI)
                        .map(index -> candidates[index]).toArray();
                if (subTarget > 0) {
                    List<List<Integer>> subResult = combinationSum(subCandidates, subTarget);
                    if (subResult.size() > 0) {
                        if (j > 0) {
                            for (List<Integer> currentSubRes : subResult) {
                                for (int l = 0; l < j; l++) {
                                    currentSubRes.add(current);
                                }
                                res.add(currentSubRes);
                            }
                        } else {
                            res.addAll(subResult);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9));
    }
}
