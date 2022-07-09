package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem10 {
    public static boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return false;
        }
        if((p.equals(".")&&s.length()==1  )|| s.equals(p)){
            return true;
        }
        int matchIndex = 0;
         List<String> subPatterns= new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            if(i<p.length()-1 && p.charAt(i+1)=='*'){
                subPatterns.add(p.charAt(i)+"*");
            }else {
                subPatterns.add(String.valueOf(p.charAt(i)));
            }
        }
        for (int i = 0; i < subPatterns.size(); i++) {
            String subPattern= subPatterns.get(i);
            boolean singlePattern= subPattern.length()==1;
            if(singlePattern){
                boolean subMatch= isMatch(s.substring(matchIndex,matchIndex+1),subPattern);
                if(!subMatch){
                    return false;
                }
                matchIndex++;
            }else {

            }

        }

        int firstPoint = 0;
        int secondPoint = 0;
        if (s.charAt(secondPoint) == '*') {
            return false;
        }

        while (firstPoint < s.length() && secondPoint < p.length()) {
            if(secondPoint<p.length()-1){
                //current character use * pattern
                if(p.charAt(secondPoint+1)=='*'){
                    if(p.charAt(secondPoint)=='.'||p.charAt(secondPoint)==s.charAt(firstPoint)){
                        if(firstPoint==s.length()-1&& secondPoint==p.length()-2){
                            return true;
                        }
                        firstPoint++;
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

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }
}
