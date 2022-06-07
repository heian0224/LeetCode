package com.liucongblog.leetcode;

import java.util.HashMap;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> searchMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target- nums[i];
            if(searchMap.containsKey(another)){
                return  new int[]{i,searchMap.get(another)};
            }else {
                searchMap.put(nums[i],i);
            }
        }
        return null;
    }
}
