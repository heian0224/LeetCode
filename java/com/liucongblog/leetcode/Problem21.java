package com.liucongblog.leetcode;

/**
 * <p>Project: LeetCode</p>
 * <p>File: com.liucongblog.leetcode.Problem21</p>
 * <p>Description: </p>
 *
 * @author Cong
 * @date 2022/7/20
 */
public class Problem21 {
    /**
     * 21. Merge Two Sorted Lists
     * You are given the heads of two sorted linked lists list1 and list2.
     * <p>
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Return the head of the merged linked list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     * <p>
     * Input: list1 = [], list2 = []
     * Output: []
     * Example 3:
     * <p>
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null ||list2==null){
            return list1==null?list2:list1;
        }
        ListNode loopNode;
        ListNode tmp1  =list1;
        ListNode tmp2 =list2;
        if(list1.val<= list2.val){
            loopNode=new ListNode(list1.val);
            tmp1=list1.next;
        }else {
            loopNode=new ListNode(list2.val);
            tmp2=list2.next;
        }
        ListNode startNode=loopNode;
        while (tmp1 != null || tmp2 != null) {
            ListNode tmpNode;
            if (tmp1==null) {
                tmpNode=new ListNode(tmp2.val);
                tmp2=tmp2.next;
                loopNode.next=tmpNode;
                loopNode=tmpNode;
                continue;
            }

            if (tmp2==null) {
                tmpNode=new ListNode(tmp1.val);
                tmp1=tmp1.next;
                loopNode.next=tmpNode;
                loopNode=tmpNode;
                continue;
            }
            if(tmp1.val<= tmp2.val){
                tmpNode=new ListNode(tmp1.val);
                tmp1=tmp1.next;
            }else {
                 tmpNode=new ListNode(tmp2.val);
                tmp2=tmp2.next;

            }
            loopNode.next=tmpNode;
            loopNode=tmpNode;
        }
        return startNode;
    }

    public static void main(String[] args) {

    }
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

}
