package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem61</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/8/28
 */
public class Problem61 {

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

    /**
     * 61. Rotate List
     * Given the head of a linked list, rotate the list to the right by k places.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], k = 2
     * Output: [4,5,1,2,3]
     * Example 2:
     * <p>
     * <p>
     * Input: head = [0,1,2], k = 4
     * Output: [2,0,1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is in the range [0, 500].
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        ListNode loopNode = head;

        while (loopNode != null) {
            listNodes.add(loopNode);
            loopNode = loopNode.next;
        }
        int reminder = k % listNodes.size();
        if (reminder == 0) {
            return head;
        }
        int startIndex = listNodes.size() - reminder;
        ListNode previousNode = listNodes.get(startIndex - 1);
        previousNode.next = null;
        ListNode lastNode = listNodes.get(listNodes.size() - 1);
        lastNode.next = head;

        return listNodes.get(startIndex);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode startNode = rotateRight(a, 2);
        while (startNode != null) {
            System.out.println(startNode.val);
            startNode = startNode.next;
        }
    }


}
