package com.liucongblog.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem22</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/20
 */
public class Problem22 {
    /**
     * 22. Generate Parentheses
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * Example 2:
     * <p>
     * Input: n = 1
     * Output: ["()"]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 8
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        HashSet<String> res = new HashSet<>();

        if (n == 1) {
            res.add("()");
            return res.stream().toList();
        }
        List<String> previousGenerated = generateParenthesis(n - 1);
        for (int i = 0; i < previousGenerated.size(); i++) {
            String previousStr = previousGenerated.get(i);
            for (int j = 0; j <= previousStr.length(); j++) {
                StringBuilder toBeAdded = new StringBuilder();
                if (j == 0) {
                    toBeAdded.append("()").append(previousStr);
                    res.add(toBeAdded.toString());
                    continue;
                }
                int index= j-1;
                toBeAdded.append(previousStr.substring(0,index+1));
                toBeAdded.append("()");
                toBeAdded.append(previousStr.substring(index+1,previousStr.length()));
                res.add(toBeAdded.toString());
            }

        }
        return res.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
