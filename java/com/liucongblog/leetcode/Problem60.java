package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem60</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/27
 */
public class Problem60 {
    /**
     * 60. Permutation Sequence
     * <p>
     * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
     * <p>
     * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * Given n and k, return the kth permutation sequence.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 3, k = 3
     * Output: "213"
     * Example 2:
     * <p>
     * Input: n = 4, k = 9
     * Output: "2314"
     * Example 3:
     * <p>
     * Input: n = 3, k = 1
     * Output: "123"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= n <= 9
     * 1 <= k <= n!
     *
     * @param n
     * @param k
     * @return
     */
    public  static String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            list.add(i);
        }
        int count=k-1;
        int divisor=1;

        for (int i = 1; i <=n ; i++) {
            divisor=divisor*i;
        }
        StringBuilder res =new StringBuilder();
        for (int i = n; i >0 ; i--) {
            if(i==1){
                res.append(list.get(0));
                continue;
            }
            divisor=divisor/i;
            int divided=count/divisor;
            count=count%divisor;
            res.append(list.get(divided));
            list.remove(divided);
        }



        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }
}
