package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem69</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/9/10
 */
public class Problem69 {

    /**
     * 69. Sqrt(x)
     * <p>
     * Given a non-negative integer x, compute and return the square root of x.
     * <p>
     * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
     * <p>
     * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: x = 4
     * Output: 2
     * Example 2:
     * <p>
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= x <= 231 - 1
     *
     * @param x non-negative integer
     * @return the square root of x
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
         long res=0;
        for (int i = 0; i <=x ; i++) {
            if((long) i *i> (long) x){
                res=i;
                break;
            }
        }
        return (int) (res-1);
    }
}
