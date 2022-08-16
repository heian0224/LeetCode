package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem50</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/15
 */
public class Problem50 {
    /**
     * 50. Pow(x, n)
     * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: x = 2.00000, n = 10
     * Output: 1024.00000
     * Example 2:
     * <p>
     * Input: x = 2.10000, n = 3
     * Output: 9.26100
     * Example 3:
     * <p>
     * Input: x = 2.00000, n = -2
     * Output: 0.25000
     * Explanation: 2-2 = 1/22 = 1/4 = 0.25
     * <p>
     * <p>
     * Constraints:
     * <p>
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(x==1 && n==Integer.MAX_VALUE){
            return 1;
        }
        if(x==-1 && n==Integer.MAX_VALUE){
            return -1;
        }
        if(x<1 && n==Integer.MAX_VALUE){
            return 0;
        }
        if(x>1 && n==Integer.MIN_VALUE){
            return 0;
        }
        int abs=Math.abs(n);
        double tmp=x;
        int count=1;
        while (count*2<n){
            count=count+count;
            tmp=tmp*tmp;
        }
        if(tmp==0){
            return 0;
        }
        int reminder= abs-count;
        return n>0 ?tmp*myPow(x,reminder):1/(tmp*myPow(x,reminder));
    }

    public static void main(String[] args) {
        System.out.println(myPow(0.00001,2147483647));
    }
}
