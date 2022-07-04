package com.liucongblog.leetcode;

public class Problem5 {
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            for (int j = i+1; j < s.length(); j++) {
                String subStr=s.substring(i,j);
                if(isPalindromicString(subStr)&&subStr.length()>maxLen){
                    maxLen= subStr.length();
                    res=subStr;
                }
            }
        }

        return res;
    }

    private  static boolean isPalindromicString(String subStr) {
        for (int i = 0; i < subStr.length()/2; i++) {
            if(subStr.charAt(i)!= subStr.charAt(subStr.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
