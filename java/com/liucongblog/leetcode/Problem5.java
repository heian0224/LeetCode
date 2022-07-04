package com.liucongblog.leetcode;

public class Problem5 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = 1; j < s.length(); j++) {
                String subStr=s.substring(i,j);
                if(isPalindromicString(subStr)&&subStr.length()>maxLen){
                    res=subStr;
                }
            }
        }

        return res;
    }

    private boolean isPalindromicString(String subStr) {
        for (int i = 0; i < subStr.length()/2; i++) {
            if(subStr.charAt(i)!= subStr.charAt(subStr.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
