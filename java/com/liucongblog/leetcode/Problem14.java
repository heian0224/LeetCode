package com.liucongblog.leetcode;


/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem14</p>
 * <p>Description: Solution for Problem 14</p>
 *
 * @author Cong
 * @date 2022/7/13
 */
public class Problem14 {
    /**
     * 14. Longest Common Prefix
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters.
     */
    public String longestCommonPrefix(String[] strs) {

        int minLength = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
                minStr = strs[i];
            }
        }
        if (minStr.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minStr.length(); i++) {
            char currentChar = minStr.charAt(i);
            boolean allContain = true;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar) {
                    allContain = false;
                    break;
                }
            }
            if (!allContain) {
                break;
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
