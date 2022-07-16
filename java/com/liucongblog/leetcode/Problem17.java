package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem17</p>
 * <p>Description: Solution for Problem 17</p>
 *
 * @author Cong
 * @date 2022/7/16
 */
public class Problem17 {

    /**
     * 17. Letter Combinations of a Phone Number
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
     *
     * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     *
     *
     *
     * Example 1:
     *
     * Input: digits = "23"
     * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * Example 2:
     *
     * Input: digits = ""
     * Output: []
     * Example 3:
     *
     * Input: digits = "2"
     * Output: ["a","b","c"]
     *
     *
     * Constraints:
     *
     * 0 <= digits.length <= 4
     * digits[i] is a digit in the range ['2', '9'].
     *
     * @param digits a string containing digits from 2-9 inclusive
     * @return all possible letter combinations
     */
    public static List<String> letterCombinations(String digits) {
        List<StringBuilder> res=new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] currentChar= map.get(  digits.charAt(i));
            if(res.isEmpty()){
                for (int j = 0; j < currentChar.length; j++) {
                    StringBuilder stringBuilder=new StringBuilder( ).append(currentChar[j]);
                    res.add(stringBuilder);
                }
            }else {
                List<StringBuilder> newList=new ArrayList<>();
                for (int j = 0; j < res.size(); j++) {
                    for (int k = 0; k < currentChar.length; k++) {
                        StringBuilder stringBuilder=new StringBuilder( ).append(res.get(j)).append(currentChar[k]);
                        newList.add(stringBuilder);
                    }
                }
                res=newList;
            }

        }

        return  res.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
    private final static Map<Character,char[]> map =Map.of('2',new char[]{'a','b','c'},
            '3',new char[]{'d','e','f'},
            '4',new char[]{'g','h','j'},
            '5',new char[]{'j','k','l'},
            '6',new char[]{'m','n','o'},
            '7',new char[]{'p','q','r','s'},
            '8',new char[]{'t','u','v'},
            '9',new char[]{'w','x','y','z'}
            );

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
