package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem64</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/31
 */
public class Problem64 {
    /**
     * 64. Minimum Path Sum
     * <p>
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
     * <p>
     * Note: You can only move either down or right at any point in time.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
     * Output: 7
     * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
     * Example 2:
     * <p>
     * Input: grid = [[1,2,3],[4,5,6]]
     * Output: 12
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 100
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j > 0)    //top row value (except leftmost)
                    grid[i][j] += grid[i][j-1];
                if(i > 0 && j == 0)    //left column value (except top)
                    grid[i][j] += grid[i-1][j];
                if(i > 0 && j > 0)
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
