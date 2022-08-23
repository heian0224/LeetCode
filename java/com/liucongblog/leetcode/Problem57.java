package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem57</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/24
 */
public class Problem57 {
    /**
     * 57. Insert Interval
     * <p>
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     * <p>
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     * <p>
     * Return intervals after the insertion.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     * <p>
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 0 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 105
     * intervals is sorted by starti in ascending order.
     * newInterval.length == 2
     * 0 <= start <= end <= 105
     *
     * @param intervals an array of non-overlapping intervals ,sorted in ascending order
     * @param newInterval a new interval that represents the start and end of another interval
     * @return intervals after the insertion.
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int []> merged =new ArrayList<>();
        for (int[] curr: intervals) {
            // no overlapping
            if(curr[0]>newInterval[1]||curr[1]<newInterval[0]){
                merged.add(curr);
                continue;
            }
            newInterval[0]=Math.min(newInterval[0],curr[0]);
            newInterval[1]=Math.max(newInterval[1],curr[1]);

        }
        merged.add(newInterval);
        int[][] res=merged.toArray(new int[][]{});
        Arrays.sort(res, Comparator.comparingInt(i->i[0]));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}
