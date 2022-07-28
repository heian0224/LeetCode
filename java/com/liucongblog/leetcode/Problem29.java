package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem29</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/27
 */
public class Problem29 {

    /**
     * 29. Divide Two Integers
     * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
     * <p>
     * The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
     * <p>
     * Return the quotient after dividing dividend by divisor.
     * <p>
     * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: dividend = 10, divisor = 3
     * Output: 3
     * Explanation: 10/3 = 3.33333.. which is truncated to 3.
     * Example 2:
     * <p>
     * Input: dividend = 7, divisor = -3
     * Output: -2
     * Explanation: 7/-3 = -2.33333.. which is truncated to -2.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * -231 <= dividend, divisor <= 231 - 1
     * divisor != 0
     *
     * @param dividend dividend integer
     * @param divisor  divisor integer
     * @return quotient
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        if (dividend == -2147483648 && divisor == 1) {
            return -2147483648;
        }
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        boolean position = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);


        return position ? calculate(dividendAbs, divisorAbs) : -calculate(dividendAbs, divisorAbs);
    }

    private int calculate(long dividendAbs, long divisorAbs) {
        if (dividendAbs < divisorAbs) {
            return 0;
        }
        if (divisorAbs == 1) {
            return dividendAbs > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) dividendAbs;
        }
        int count = 1;
        long cut=divisorAbs;
        while(cut+cut<=dividendAbs){
            count=count+count;
            cut=cut+cut;
        }
        return count + calculate(dividendAbs - cut, divisorAbs);
    }

    public static void main(String[] args) {

    }
}


