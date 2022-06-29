package com.liucongblog.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.isEmpty() ? 0 : 1;
        }
        int maxSubString = 0;
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
                deque.removeFirst();
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
}
