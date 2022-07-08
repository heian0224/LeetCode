package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x<0) {
            return false;
        }
        if(x<10){
            return true;
        }
        List<Integer> digitList=new ArrayList<>();
        int loopInteger=x;
        while(loopInteger>=10){
            int count=loopInteger/10;
            int reminder=loopInteger%10;
            digitList.add(reminder);
            loopInteger=count;
        }
        digitList.add(loopInteger);
        for (int i = 0; i < digitList.size()/2; i++) {
            if(digitList.get(i)!=digitList.get(digitList.size()-1-i)){
                return false;
            }

        }
        return true;
    }
}
