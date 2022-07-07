package com.liucongblog.leetcode;

public class Problem8 {
    public static int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        int sign = 1;
        String trimmedStr = s.trim();
        String readStr = trimmedStr;
        if (trimmedStr.isEmpty()) {
            return 0;
        }
        if (trimmedStr.charAt(0) == '+' || trimmedStr.charAt(0) == '-') {
            sign = trimmedStr.charAt(0) == '+' ? 1 : -1;
            readStr = trimmedStr.substring(1);
        }
        StringBuilder integerStr = new StringBuilder();
        boolean startRead = false;
        for (int i = 0; i < readStr.length(); i++) {
            char readChar = readStr.charAt(i);
            if (Character.isDigit(readChar)) {
                if (readChar == '0' &&!startRead) {
                    continue;
                } else {
                    startRead = true;
                    integerStr.append(readChar);
                }
            } else {
                break;
            }
        }
        if (integerStr.isEmpty()) {
            return 0;
        }
        if (integerStr.length() > 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            Long longVal = Long.parseLong(integerStr.toString());
            if (longVal > Integer.MAX_VALUE && sign == 1) {
                return Integer.MAX_VALUE;
            } else if (longVal - 1 > Integer.MAX_VALUE && sign == -1) {
                return Integer.MIN_VALUE;
            } else {
                return (int) (longVal * sign);
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf(String.valueOf(myAtoi("42")));
    }
}
