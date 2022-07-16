package com.liucongblog.leetcode;

import java.util.Deque;
import java.util.LinkedList;
/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem3</p>
 * <p>Description: Solution for Problem 3</p>
 *
 * @author Cong
 * @date 2022/6/29
 */
public class Problem3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.isEmpty() ? 0 : 1;
        }
        int maxSubString = 1;
        Deque deque = new LinkedList<>();
        deque.add(s.charAt(0));
        int leftCursor = 0;
        int rightCursor = 1;
        while (rightCursor < s.length()) {
            if (leftCursor == rightCursor) {
                deque.push(s.charAt(rightCursor));
                rightCursor++;
                continue;
            }
            if (deque.contains(s.charAt(rightCursor))) {
                deque.removeLast();
                leftCursor++;
            } else {
                deque.push(s.charAt(rightCursor));
                rightCursor++;
            }
            if (deque.size() > maxSubString) {
                maxSubString = deque.size();
            }


        }

        return maxSubString;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
