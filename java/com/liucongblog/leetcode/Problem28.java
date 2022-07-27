package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem28</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/27
 */
public class Problem28 {

    /**
     * 28. Implement strStr()
     * Implement strStr().
     * <p>
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * Clarification:
     * <p>
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     * <p>
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     * <p>
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= haystack.length, needle.length <= 104
     * haystack and needle consist of only lowercase English characters.
     *
     * @param haystack original string
     * @param needle   need judge sub string
     * @return index of the need string
     */
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int position = -1;
        boolean startedMatch = false;
        while (firstIndex < haystack.length() && secondIndex < needle.length()) {
            char firstChar = haystack.charAt(firstIndex);
            char secondChar = needle.charAt(secondIndex);
            if (firstChar == secondChar) {
                if (!startedMatch) {
                    //first match
                    startedMatch = true;
                    position = firstIndex;
                }
                firstIndex++;
                secondIndex++;
            } else {
                startedMatch = false;
                if (position >= 0) {
                    firstIndex = position + 1;
                    position = -1;
                } else {

                    firstIndex++;
                }
                secondIndex = 0;

            }
        }
        if (firstIndex == haystack.length() && secondIndex != needle.length()) {
            return -1;
        }
        if (secondIndex == needle.length()) {
            return position;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aabaaabaaac"
               , "aabaaac"));
    }
}
