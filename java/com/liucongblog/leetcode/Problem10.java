package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem10</p>
 * <p>Description: Solution for Problem 10</p>
 *
 * @author Cong
 * @date 2022/7/9
 */
public class Problem10 {
    public static boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return false;
        }
        int firstPoint = 0;
        int secondPoint = 0;
        if (s.charAt(secondPoint) == '*') {
            return false;
        }
        int secondCount = 0;
        while (firstPoint < s.length() && secondPoint < p.length()) {
            if(secondPoint<p.length()-1){
                //current character use * pattern
                if(p.charAt(secondPoint+1)=='*'){
                    if(p.charAt(secondPoint)=='.'||p.charAt(secondPoint)==s.charAt(firstPoint)){
                        if(firstPoint==s.length()-1&& secondPoint+1+secondCount==p.length()-1){
                            return true;
                        }
                        firstPoint++;
                        if(secondPoint+1+secondCount+1<=p.length()-1 &&p.charAt(secondPoint+1+secondCount+1)==p.charAt(secondPoint) ){
                            secondCount++;
                        }
                        continue;
                    } else {
                        secondPoint=secondPoint+2;
                        continue;
                    }

                }

            }
             if(p.charAt(secondPoint)=='.'||p.charAt(secondPoint)==s.charAt(firstPoint)){
                firstPoint++;
                secondPoint++;
            }else {
                break;
            }
        }
        // match all
        if(firstPoint==s.length()&& secondPoint==p.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }
}
