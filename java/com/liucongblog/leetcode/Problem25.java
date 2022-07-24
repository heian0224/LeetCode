package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem25</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/23
 */
public class Problem25 {

    /**
     * 25. Reverse Nodes in k-Group
     * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
     * <p>
     * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
     * <p>
     * You may not alter the values in the list's nodes, only nodes themselves may be changed.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [2,1,4,3,5]
     * Example 2:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], k = 3
     * Output: [3,2,1,4,5]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is n.
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     *
     * @param head to be reversed list node
     * @param k    reverse loop number
     * @return reversed list node
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null|| k==1) {
            return head;
        }
        ListNode loopNode = head;
        List<ListNode> listNodeList = new ArrayList<>();
        while (loopNode != null) {
            listNodeList.add(loopNode);
            loopNode = loopNode.next;
        }
        //k should less than
        int startIndex = k - 1;
        int currentIndex = startIndex;
        int count = listNodeList.size() / k;
        int reminder = listNodeList.size() % k;
        ListNode startNode = listNodeList.get(startIndex);
        int addedNum = 1;
        while (addedNum < listNodeList.size()) {
            ListNode currentNode = listNodeList.get(currentIndex);
            int nextIndex = getNextIndex(currentIndex, listNodeList.size(), reminder, k, addedNum);
            ListNode nextNode = listNodeList.get(nextIndex);
            currentNode.next = nextNode;
            currentIndex = nextIndex;
            addedNum++;
            if (addedNum == listNodeList.size()) {
                nextNode.next = null;
            }

        }


        return startNode;
    }

    private static int getNextIndex(int currentIndex, int size, int reminder, int k, int addedNum) {
        if (addedNum >= size - reminder) {
            return addedNum;
        }
        int indexReminder = (currentIndex + 1) % k;
        int indexCount = (currentIndex + 1) / k;
        if (indexReminder == 0) {
            return currentIndex - 1;
        } else if (indexReminder == 1) {
            return (indexCount + 2) * k - 1;
        } else {
            return currentIndex - 1;
        }

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

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);
        ListNode reversedNode =reverseKGroup(e,2);
        while (reversedNode !=null){
            System.out.println("current val:"+reversedNode.val);
            reversedNode=reversedNode.next;
        }
    }

}
