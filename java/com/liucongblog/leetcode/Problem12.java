package com.liucongblog.leetcode;

public class Problem12 {
    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param num roman number
     * @return roman string
     */
    public static String intToRoman(int num) {
        int[] romanArr = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] romanCharArr = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int index = 0;
        StringBuilder result = new StringBuilder();
        int loopNum = num;
        while (index < 7) {
            boolean isLast = index == 6;
            int currRomanInt = romanArr[index];
            if (isLast) {
                int count = loopNum / currRomanInt;
                for (int i = 0; i < count; i++) {
                    result.append(romanCharArr[index]);
                }
            } else {
                int nextRomanIndex = index % 2 == 0 ? index + 2 : index + 1;
                int nextRomanInt = romanArr[nextRomanIndex];

                int count = loopNum / currRomanInt;
                loopNum = loopNum % currRomanInt;
                for (int i = 0; i < count; i++) {
                    result.append(romanCharArr[index]);
                }
                if (loopNum >= currRomanInt - nextRomanInt) {
                    loopNum = loopNum - currRomanInt + nextRomanInt;
                    result.append(romanCharArr[nextRomanIndex]).append(romanCharArr[index]);
                }
            }
            index++;
        }


        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
