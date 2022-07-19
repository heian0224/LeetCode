package com.liucongblog.leetcode;

import java.util.Stack;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem20</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/19
 */
public class Problem20 {
    /**
     * 20. Valid Parentheses
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: s = "(]"
     * Output: false
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     *
     * @param s a string s containing just the characters '(', ')', '{', '}', '[' and ']'
     * @return if the input string is valid
     */
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar= s.charAt(i);
            if(currentChar=='('||currentChar=='['||currentChar=='{'){
                stack.add(currentChar);
            }else if(currentChar==')'||currentChar==']'||currentChar=='}'){
                if(stack.isEmpty()){
                    return false;
                }
                Character lastChar= stack.pop() ;
                if((currentChar==')'&&lastChar=='(')||(currentChar==']'&&lastChar=='[')||(currentChar=='}'&&lastChar=='{')){

                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.size()==0;
    }

}
