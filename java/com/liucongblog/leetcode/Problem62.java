package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem62</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/29
 */
public class Problem62 {
    /**
     * 62. Unique Paths
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     * <p>
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     * <p>
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: m = 3, n = 7
     * Output: 28
     * Example 2:
     * <p>
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Down -> Down
     * 2. Down -> Down -> Right
     * 3. Down -> Right -> Down
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= m, n <= 100
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int sum = n - 1 + m - 1;
        int minVal = Math.min(m, n);
        if (minVal <= 2) {
            return minVal == 1 ? 1 : sum;
        }
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 2; i < minVal; i++) {
            divisorList.add(i);

        }
        List<Integer> dividedList = new ArrayList<>();
        for (int i = sum; i > sum - minVal + 1; i--) {
            dividedList.add(i);
        }
        for (int i = minVal - 1; i > 1; i--) {
            int index = getIndex(dividedList, i);
            if (index != -1) {
                handle(dividedList, i, index);
            } else {
                List<Integer> factors = new ArrayList<>();
                int nn=i;
                for (int j = 2; j <= i; j++) {
                    while (nn % j == 0) {
                        factors.add(j);
                        nn /= j;
                    }
                }
                 factors.forEach(factor -> {
                    int indexIn = getIndex(dividedList, factor);
                    handle(dividedList, factor, indexIn);
                });
            }

        }
        int res = 1;
        for (int i = 0; i < dividedList.size(); i++) {
            res *= dividedList.get(i);
        }

        return res;
    }

    private static void handle(List<Integer> dividedList, int i, int index) {
        int currentDivided = dividedList.get(index);
        int reminder = currentDivided / i;
        dividedList.remove(index);
        if (reminder != 1) {
            dividedList.add(reminder);
        }
    }

    private static int getIndex(List<Integer> dividedList, int i) {
        int index = -1;
        for (int j = 0; j < dividedList.size(); j++) {
            if (dividedList.get(j) % i == 0) {
                index = j;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(16, 16));
    }
}
