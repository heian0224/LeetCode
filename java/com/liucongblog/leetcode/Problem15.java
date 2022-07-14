package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[1] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Problem15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3)
            return null;
        List<Integer> oldList = Arrays.stream(nums).sorted().boxed().toList();
        List<Integer> numList = new ArrayList<>();
        Integer countInt = oldList.get(0);
        int count = 1;
        numList.add(countInt);
        for (int i = 1; i < oldList.size(); i++) {
            Integer current = oldList.get(i);
            if (current == 0) {
                count++;
                numList.add(current);
                continue;
            }
            if(current.equals(countInt)){
                if(count == 2){
                    continue;
                }else {
                    count++;
                    numList.add(current);
                }
            }else {
                count = 1;
                countInt=current;
                numList.add(current);
            }

        }
        Integer previousMatchFirst = null;
        Integer previousMatchSecond = null;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < numList.size() - 2; i++) {

            for (int j = i + 1; j < numList.size() - 1; j++) {

                List<Integer> subList = numList.subList(j + 1, numList.size());
                Integer value = -(numList.get(i) + numList.get(j));
                if (subList.contains(value)) {
                    if (Objects.equals(numList.get(i), previousMatchFirst) && Objects.equals(numList.get(j), previousMatchSecond)) {
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(numList.get(i));
                        list.add(numList.get(j));
                        list.add(value);
                        resultList.add(list);
                        previousMatchFirst = numList.get(i);
                        previousMatchSecond = numList.get(j);
                    }
                }

            }

        }

        return resultList;


    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}
