package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem24</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/22
 */
public class Problem24 {

    /**
     * 24. Swap Nodes in Pairs
     * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
     * modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4]
     * Output: [2,1,4,3]
     * Example 2:
     * <p>
     * Input: head = []
     * Output: []
     * Example 3:
     * <p>
     * Input: head = [1]
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the ran
     * <p>
     * ge [0, 100].
     * 0 <= Node.val <= 100
     *
     * @param head to be swapped node
     * @return swapped node
     */
    public static ListNode swapPairs(ListNode head) {

        if (head.next == null) {
            return head;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode loopNode = head;
        while (loopNode != null) {
            listNodeList.add(loopNode);
            loopNode = loopNode.next;
        }
        //start swap?
        int toSwap = listNodeList.size() / 2 + 1;
        int startIndex = 1;
        ListNode startNode = listNodeList.get(startIndex);
        int currentIndex = 1;
        Integer nextNodeIndex = getNextIndex(currentIndex, listNodeList.size());
        int addedNum=1;
        while (addedNum<listNodeList.size()) {
            ListNode currentNode = listNodeList.get(currentIndex);
            ListNode nextNode=listNodeList.get(nextNodeIndex);
            currentNode.next = listNodeList.get(nextNodeIndex);
            currentIndex = nextNodeIndex;
            nextNodeIndex = getNextIndex(currentIndex, listNodeList.size());
            addedNum++;
            if(addedNum==listNodeList.size()){
                nextNode.next=null;
            }

        }

        return startNode;
    }

    private static Integer getNextIndex(int currentIndex, int size) {
        int modRes=currentIndex%2;

        if(modRes==1){
            return currentIndex-1;
        }else {
            int shouldReturn=currentIndex+3;
            if(shouldReturn>size-1){
                shouldReturn--;
            }
            return shouldReturn;
        }
    }

    public static void main(String[] args) {
        ListNode a = new  ListNode(2);
        ListNode b = new ListNode(1, a);
        ListNode c = new ListNode(2, b);
        ListNode d = new ListNode(1, c);
        System.out.println(swapPairs(b));
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


