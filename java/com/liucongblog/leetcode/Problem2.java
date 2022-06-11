package com.liucongblog.leetcode;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1== null || l2 ==null)
            return l1==null?l2:l1;
        int val=(l1.val+l2.val)%10;
        int increment=(l1.val+l2.val)/10;

        ListNode resNode=new ListNode(val);
        ListNode loopNode1=l1.next;
        ListNode loopNode2=l2.next;
        ListNode loopResNode=resNode;
        while(loopNode1!=null || loopNode2!=null||increment>0){
            int value1=loopNode1==null? 0: loopNode1.val;
            int value2=loopNode2==null? 0: loopNode2.val;
            int internalVal=increment>0?value1+value2+increment:value1+value2;
            val=internalVal%10;
            increment=internalVal/10;
            loopNode1= loopNode1==null? null: loopNode1.next;
            loopNode2= loopNode2==null? null: loopNode2.next;
            ListNode nextNode=new ListNode(val);
            loopResNode.next=nextNode;
            loopResNode=nextNode;
        }
        return resNode;
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
