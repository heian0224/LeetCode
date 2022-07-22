package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem23</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/22
 */
public class Problem23 {
    /**
     * 23. Merge k Sorted Lists
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * <p>
     * Merge all the linked-lists into one sorted linked-list and return it.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * merging them into one sorted list:
     * 1->1->2->3->4->4->5->6
     * Example 2:
     * <p>
     * Input: lists = []
     * Output: []
     * Example 3:
     * <p>
     * Input: lists = [[]]
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * k == lists.length
     * 0 <= k <= 104
     * 0 <= lists[i].length <= 500
     * -104 <= lists[i][j] <= 104
     * lists[i] is sorted in ascending order.
     * The sum of lists[i].length will not exceed 104.
     *
     * @param lists
     * @return merged list node
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> loopList = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                loopList.add(lists[i]);
            }
        }
        if (loopList == null || loopList.size() == 0) {
            return null;
        }
        ListNode startNode;
        int minVal = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < loopList.size(); i++) {
            if (loopList.get(i).val < minVal) {
                minVal = loopList.get(i).val;
                minIndex = i;
            }
        }
        ListNode loopNode = new ListNode(minVal);
        startNode = loopNode;
        ListNode removedNode = loopList.get(minIndex);
        loopList.remove(minIndex);
        if (removedNode.next != null) {
            loopList.add(removedNode.next);
        }
        while (!loopList.isEmpty()) {
            minVal = Integer.MAX_VALUE;
            minIndex = 0;
            for (int i = 0; i < loopList.size(); i++) {
                if (loopList.get(i).val < minVal) {
                    minVal = loopList.get(i).val;
                    minIndex = i;
                }
            }
            ListNode tmpNode = new ListNode(minVal);
            loopNode.next = tmpNode;
            loopNode = tmpNode;
            ListNode toBeRemovedNode = loopList.get(minIndex);
            loopList.remove(minIndex);
            if (toBeRemovedNode.next != null) {
                loopList.add(toBeRemovedNode.next);
            }
        }
        return startNode;
    }

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode[] arr = new ListNode[3];
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(1, b);
        arr[0] = c;
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(3, d);
        ListNode f = new ListNode(1, e);
        arr[1] = f;
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(2, g);
        arr[2] = h;
        System.out.println(mergeKLists(arr));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
