package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem63</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/30
 */
public class Problem63 {
    /**
     * 63. Unique Paths II
     * <p>
     * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
     * <p>
     * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
     * <p>
     * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     * <p>
     * The testcases are generated so that the answer will be less than or equal to 2 * 109.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: 2
     * Explanation: There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     * Example 2:
     * <p>
     * <p>
     * Input: obstacleGrid = [[0,1],[0,0]]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == obstacleGrid.length
     * n == obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] is 0 or 1.
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    temp[j] = dp[j] + ((j > 0) ? temp[j - 1] : 0);
                }
            }

            dp = temp;
        }

        return dp[n - 1];
    }

}
