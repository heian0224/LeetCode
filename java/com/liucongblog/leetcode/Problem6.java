package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem6</p>
 * <p>Description: Solution for Problem 6</p>
 *
 * @author Cong
 * @date 2022/7/5
 */
public class Problem6 {
    public static String convert(String s, int numRows) {
        if(s==null || s.length()==0 || numRows>=s.length() ||numRows==1){
            return s;
        }
        int count=(s.length()-1)/(numRows-1);
        int reminder= (s.length()-1)%(numRows-1);
        if(reminder!=0){
            count++;
        }
        char[][] matrix=new char[numRows][count];
        matrix[0][0]=s.charAt(0);

        for (int i = 1; i <s.length() ; i++) {
            int currCount= i/(numRows-1);
            int currReminder= i%(numRows-1);
            int columnIndex= currCount-1;
            int rowIndex;
            if(currReminder>0){
                columnIndex++;

            }
            if(currCount%2==0){
                rowIndex=currReminder;
            }else {
                rowIndex=numRows-1-currReminder;
            }
            matrix[rowIndex][columnIndex]=s.charAt(i);
        }
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < count; j++) {
                // character init value is \u0000
                if(matrix[i][j]!='\u0000'){

                    res.append(matrix[i][j]);
                }

            }

        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
