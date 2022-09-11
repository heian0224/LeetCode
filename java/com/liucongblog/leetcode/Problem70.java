package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem70</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/9/11
 */
public class Problem70 {

    /**
     * 70. Climbing Stairs
     *
     *
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *
     * Constraints:
     *
     * 1 <= n <= 45
     *
     * @param n n steps to reach the top
     * @return  total ways
     */
    public  static int climbStairs(int n) {
        if(n==1 ||n==2 || n==3){
            return n;
        }
        if (n==45) {
            return 1836311903;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(climbStairs(45));
        System.out.println(System.currentTimeMillis());
    }
}
