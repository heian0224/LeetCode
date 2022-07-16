package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem5</p>
 * <p>Description: Solution for Problem 5</p>
 *
 * @author Cong
 * @date 2022/7/5
 */
public class Problem5 {
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < s.length()-1; i++) {
            //expand to use i as center, contains right index.
            int leftIndex=i;
            int rightIndex=i;
            while(leftIndex>=0 && rightIndex<s.length()){
                if(s.charAt(leftIndex)==s.charAt(rightIndex)){
                    if(rightIndex-leftIndex+1>maxLen){
                        maxLen=rightIndex-leftIndex+1;
                        res=s.substring(leftIndex,rightIndex+1);
                    }
                    leftIndex--;
                    rightIndex++;
                }else{
                    break;
                }
            }
            //expand to use i and i+1 as center,contains right index.
            leftIndex=i;
            rightIndex=i+1;
            while(leftIndex>=0 && rightIndex<s.length()){
                if(s.charAt(leftIndex)==s.charAt(rightIndex)){
                    if(rightIndex-leftIndex+1>maxLen){
                        maxLen=rightIndex-leftIndex+1;
                        res=s.substring(leftIndex,rightIndex+1);
                    }
                    leftIndex--;
                    rightIndex++;
                }else{
                    break;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
    }
}
