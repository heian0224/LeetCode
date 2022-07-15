package com.liucongblog.leetcode;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * <p>
 * Return the sum of the three integers.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * <p>
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class Problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int index1 = i + 1;
            int index2 = nums.length - 1;
            while (index1 < index2) {
                int sum = nums[i] + nums[index1] + nums[index2];
                if (sum == target) {
                    closestNum=0;
                    res = sum;
                    break;
                }

                if (sum > target) {
                    index2--;
                } else {
                    index1++;
                }
                int val = Math.abs(sum - target);
                if (closestNum > val) {
                    closestNum = val;
                    res = sum;
                }

            }



            if (closestNum == 0) {
                res = target;
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-763, 567, 885, -628, -530, -468, 549, -341, 275, -282, 22, -448, -804, -369, 636, -677, -907, 898, 8, -643, 213, 245, 756, -328, -987, -433, 639, -18, -104, -439, 715, -145, -703, 299, -84, 767, 818, -300, -374, 232, 962, -289, 638, 144, -508, 870, 480, -70, -576, 661, -808},-2145))
        ;
    }
}
