package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem66</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/9/1
 */
public class Problem66 {

    /**
     * 66. Plus One
     * <p>
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * <p>
     * Increment the large integer by one and return the resulting array of digits.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * Example 2:
     * <p>
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     * Example 3:
     * <p>
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= digits.length <= 100
     * 0 <= digits[i] <= 9
     * digits does not contain any leading 0's.
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        boolean addDigits=addOne(digits,digits.length-1);
        if(addDigits){
            int[] res=new int[digits.length+1];
            for (int i = 1; i < res.length; i++) {
                res[i]=0;
            }
            res[0]=1;
            return res;
        }

        return digits;
    }

    private static boolean addOne(int[] digits, int index) {
        int current=digits[index];
        if(current<9){
            digits[index]=current+1;
        }else {
            if(index==0){
                return true;
            }
            digits[index]=0;
            return addOne(digits,index-1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2})));
    }
}
