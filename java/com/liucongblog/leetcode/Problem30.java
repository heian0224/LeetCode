package com.liucongblog.leetcode;

import java.util.*;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem30</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/28
 */
public class Problem30 {
    /**
     * 30. Substring with Concatenation of All Words
     * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
     * <p>
     * You can return the answer in any order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "barfoothefoobarman", words = ["foo","bar"]
     * Output: [0,9]
     * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
     * The output order does not matter, returning [9,0] is fine too.
     * Example 2:
     * <p>
     * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * Output: []
     * Example 3:
     * <p>
     * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * Output: [6,9,12]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 104
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * s and words[i] consist of lowercase English letters.
     *
     * @param s     original string
     * @param words words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,List<Integer>> maps=  new HashMap<>();
        for (int i = 0; i <words.length ; i++) {
            String word= words[i];
            int[] positions=s.indexOf(word);
        }



        return null;
    }
}
