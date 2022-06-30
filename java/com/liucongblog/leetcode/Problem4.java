package com.liucongblog.leetcode;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArr=new int[nums1.length+nums2.length];
        int index1=0;
        int index2=0;
        for (int i = 0; i < newArr.length; i++) {
            if(index1>=nums1.length){
                newArr[i]=nums2[index2];
                index2++;
                continue;
            }
            if(index2>=nums2.length){
                newArr[i]=nums1[index1];
                index1++;
                continue;
            }
            if(nums1[index1]<= nums2[index2]){
                newArr[i]=nums1[index1];
                index1++;
            }else {
                newArr[i]=nums2[index2];
                index2++;
            }
        }
        if(newArr.length%2==0){
            double res=newArr[newArr.length/2-1]+ newArr[newArr.length/2];
            return res/2;
        }else {
            return newArr[newArr.length/2];
        }
    }
}
