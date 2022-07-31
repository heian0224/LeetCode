package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem32</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/31
 */
public class Problem32 {
    /**
     * 32. Longest Valid Parentheses
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     * <p>
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * Example 3:
     * <p>
     * Input: s = ""
     * Output: 0
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= s.length <= 3 * 104
     * s[i] is '(', or ')'.
     *
     * @param s to be valid string
     * @return the longest valid (well-formed) parentheses substring
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Data> stack = new Stack<>();
        List<Integer> indexList= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            Data currentData= new Data(i,current);
            if (current == '(') {
                stack.push(currentData);
            } else if (current == ')') {
                if (stack.isEmpty()) {
                    stack.push(currentData);

                } else {
                    Data before = stack.peek();
                    if (before.current == '(') {
                        stack.pop();
                        indexList.add(i);
                    } else {
                        stack.push(currentData);
                    }
                }

            }
        }
        if (stack.isEmpty()){
            return s.length();
        }
        int endIndex=s.length();
        int res=0;
        while (!stack.isEmpty()){
            Data currentData= stack.pop();
            int dataRange=endIndex-currentData.index-1;
            if(dataRange>res){
                res=dataRange;
            }
            endIndex=currentData.index;
        }
        if(endIndex>res){
            res=endIndex;
        }

        return res;
    }
    static class Data {

        private int index;
        private char current;

        public Data(int index, char current) {
            this.index = index;
            this.current = current;
        }
    }
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(())"));
    }
}
