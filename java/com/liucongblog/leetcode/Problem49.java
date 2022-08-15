package com.liucongblog.leetcode;

import java.util.*;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem49</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/15
 */
public class Problem49 {
    /**
     * 49. Group Anagrams
     * <p>
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * <p>
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     * <p>
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     * <p>
     * Input: strs = ["a"]
     * Output: [["a"]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>   strMap=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(strMap.get(sorted)==null){
                List<String> added= new ArrayList<>();
                added.add(strs[i]);
                strMap.put(sorted,added);
            }else {
                List<String> added=strMap.get(sorted);
                added.add(strs[i]);
            }


        }
        return strMap.values().stream().toList();
    }
}
