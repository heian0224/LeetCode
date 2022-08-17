package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem51</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/16
 */
public class Problem51 {
    /**
     * 51. N-Queens
     * <p>
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * <p>
     * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
     * <p>
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: n = 4
     * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
     * Example 2:
     * <p>
     * Input: n = 1
     * Output: [["Q"]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 9
     *
     * @param n queen count
     * @return all distinct solutions to the n-queens puzzle
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            List<String> sub = new ArrayList<>();
            sub.add("Q");
            res.add(sub);
            return res;
        }
        List<List<String>> subResList = solveNQueens(n - 1);
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            for (int j = 0; j < subResList.size(); j++) {
                List<String> subRes = subResList.get(j);
                List<String> toBeAdded = new ArrayList<>();
                for (int k = 0; k < subRes.size(); k++) {
                    String current = subRes.get(k);
                    String addedStr = current.substring(0, i) +
                            "." +
                            current.substring(i);
                    toBeAdded.add(addedStr);
                }
                toBeAdded.add(stringBuilder.toString());
                res.add(toBeAdded);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(3));
    }
}
