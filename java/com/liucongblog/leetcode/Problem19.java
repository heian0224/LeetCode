package com.liucongblog.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem19</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/18
 */
public class Problem19 {
    class ListNode {
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
     * 19. Remove Nth Node From End of List
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: head = [1,2,3,4,5], n = 2
     * Output: [1,2,3,5]
     * Example 2:
     * <p>
     * Input: head = [1], n = 1
     * Output: []
     * Example 3:
     * <p>
     * Input: head = [1,2], n = 1
     * Output: [1]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the list is sz.
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     *
     * @param head previous linked list
     * @param n    the nth node to be removed
     * @return removed linked list
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        List<ListNode> nodeList = new ArrayList();
        ListNode tmp = head;
        nodeList.add(head);
        while (tmp.next != null) {
            nodeList.add(tmp.next);
            tmp = tmp.next;
        }
        int size = nodeList.size();
        if(size ==1 && n==1){
            return null;
        }
        if(n==1 ){
            ListNode previousNode=nodeList.get(size-2);
            previousNode.next=null;
            return head;
        }
        if(n==size){
            return nodeList.get(1);
        }
        ListNode previousNode=nodeList.get(size-n-1);
        previousNode.next= nodeList.get(size-n+1);
        return head;
    }
}
