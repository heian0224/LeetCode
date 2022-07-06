package com.liucongblog.leetcode;

import java.util.Stack;

public class Problem7 {
    public static int reverse(int x) {
        if(x==Integer.MAX_VALUE||x==Integer.MIN_VALUE){
            return 0;
        }
        int sign = (int) Math.signum(x);
        int abs = Math.abs(x);
        Stack numStack=new Stack();
        int temp= abs;
        while(temp>=10){
            int count=   (temp/10);
            int reminder=   (temp%10);
            numStack.push(reminder);
            temp=count;
        }
        numStack.push(temp);
        //use double because the res may exceed max integer value
        double res= (int) numStack.pop();
        int power=1;
        while(!numStack.empty()){
            int popValue= (int) numStack.pop();
            res= res+ Math.pow(10,power)*popValue;
            power++;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
            return 0;
        }
        return (int) (res*sign);
    }

    public static void main(String[] args) {
        System.out.println(reverse(12345));
    }
}
