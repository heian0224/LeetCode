package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem38</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/6
 */
public class Problem38 {
    /**
     * 38. Count and Say
     * <p>
     * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
     * <p>
     * countAndSay(1) = "1"
     * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
     * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
     * <p>
     * For example, the saying and conversion for digit string "3322251":
     * <p>
     * <p>
     * Given a positive integer n, return the nth term of the count-and-say sequence.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 1
     * Output: "1"
     * Explanation: This is the base case.
     * Example 2:
     * <p>
     * Input: n = 4
     * Output: "1211"
     * Explanation:
     * countAndSay(1) = "1"
     * countAndSay(2) = say "1" = one 1 = "11"
     * countAndSay(3) = say "11" = two 1's = "21"
     * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 30
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previousStr=countAndSay(n-1);
        //count and say logic
        StringBuilder result=new StringBuilder();
        Character loopChar=null;
        int count=0;
        for (int i = 0; i < previousStr.length() ; i++) {
            char current=previousStr.charAt(i);
            if(loopChar==null){
                loopChar=current;
                count++;
                continue;
            }
            if (current==loopChar){
                count++;
            }else {
                result.append(count).append(loopChar);
                loopChar=current;
                count=1;
            }
        }
        result.append(count).append(loopChar);


        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }
}
