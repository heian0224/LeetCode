package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem58</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/25
 */
public class Problem58 {

    /**
     * 58. Length of Last Word
     * <p>
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "Hello World"
     * Output: 5
     * Explanation: The last word is "World" with length 5.
     * Example 2:
     * <p>
     * Input: s = "   fly me   to   the moon  "
     * Output: 4
     * Explanation: The last word is "moon" with length 4.
     * Example 3:
     * <p>
     * Input: s = "luffy is still joyboy"
     * Output: 6
     * Explanation: The last word is "joyboy" with length 6.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 104
     * s consists of only English letters and spaces ' '.
     * There will be at least one word in s.
     *
     * @param s a string s consisting of words and spaces
     * @return return the length of the last word in the string.
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            if (current == ' ') {
                break;
            }
            count++;

        }
        return count;
    }
}
