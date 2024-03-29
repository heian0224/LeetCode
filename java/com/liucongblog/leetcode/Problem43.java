package com.liucongblog.leetcode;

import java.math.BigInteger;
import java.util.Objects;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem43</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/10
 */
public class Problem43 {
    /**
     * 43. Multiply Strings
     * <p>
     * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
     * <p>
     * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: num1 = "2", num2 = "3"
     * Output: "6"
     * Example 2:
     * <p>
     * Input: num1 = "123", num2 = "456"
     * Output: "56088"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= num1.length, num2.length <= 200
     * num1 and num2 consist of digits only.
     * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
     *
     * @param num1 number one string
     * @param num2 number two string
     * @return multiply result string for these two numbers
     */
    public static String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return String.valueOf(0);
        }
        StringBuilder res = new StringBuilder();
        int previousAdded=0;
        int loopCount=num1.length()+num2.length();
        for (int i = 2; i <=loopCount; i++) {
            int tmpRes=previousAdded;
            for (int j = 1; j < i&&j<=num1.length(); j++) {
                int index1=num1.length()-j;
                int index2=num2.length()-(i-j);
                if(index2>=0){
                    int currentPos1=num1.charAt(index1)-'0';
                    int currentPos2=num2.charAt(index2)-'0';
                    tmpRes+=currentPos1*currentPos2;
                }

            }
            int reminder=tmpRes%10;
            previousAdded= tmpRes/10;
            res.append(reminder);
        }
        if(previousAdded>0){
            res.append(previousAdded);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("12",
                "12"));
    }
}
