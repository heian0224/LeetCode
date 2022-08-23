package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem56</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/22
 */
public class Problem56 {

    /**
     * 56. Merge Intervals
     * <p>
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     * <p>
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));


        List<Integer> resStartList = new ArrayList<>();
        List<Integer> resEndList = new ArrayList<>();
        List<Integer> addedIndexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (addedIndexList.contains(i)) {
                continue;
            }
            int start = intervals[i][0];
            int end = intervals[i][1];
            int maxEnd = end;
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                int currentStart = intervals[j][0];
                int currentEnd = intervals[j][1];
                if (maxEnd >= currentStart) {
                    addedIndexList.add(j);
                    if (currentEnd > maxEnd) {
                        maxEnd = currentEnd;
                    }
                }


            }
            resStartList.add(start);
            resEndList.add(maxEnd);
            addedIndexList.add(i);
        }
        int[][] res = new int[resStartList.size()][2];
        for (int i = 0; i < resStartList.size(); i++) {
            res[i][0] = resStartList.get(i);
            res[i][1] = resEndList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {0,2}, {3,5} })));
    }
}
