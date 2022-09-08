package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem67</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/9/2
 */
public class Problem67 {
    /**
     * 67. Add Binary
     * <p>
     * Given two binary strings a and b, return their sum as a binary string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     * <p>
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= a.length, b.length <= 104
     * a and b consist only of '0' or '1' characters.
     * Each string does not contain leading zeros except for the zero itself.
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int len= Math.max(a.length(), b.length());
        int addToNext=0;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index1=a.length()-1-i;
            int index2=b.length()-1-i;
            int num1=index1>=0?a.charAt(index1)=='0'?0:1:0;
            int num2=index2>=0?b.charAt(index2)=='0'?0:1:0;
            int res=num1+num2+addToNext;
            addToNext=res/2;
            int current=res%2;
            stringBuilder.append(current);
        }
        if (addToNext!=0) {
            stringBuilder.append(addToNext);
        }


        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010","1011"));
    }
}
