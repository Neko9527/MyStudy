package com.xcw.practice;

/**
 * @author wangxuechao
 * @date 2021-05-13
 */
public class LC2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        addTwoNumbers(l1,l2);



    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int p1, p2, plus = 0;
        ListNode node;
        ListNode next = new ListNode();
        node = next;
        while (true) {
            p1 = l1 != null ? l1.val : 0;
            p2 = l2 != null ? l2.val : 0;
            next.val = (p1 + p2 + plus) % 10;

            plus = (p1 + p2 + plus) / 10;

            l1 = l1.next;
            l2 = l2.next;
            if(l1 == null && l2 == null){
                if(plus > 0) {
                    next.next = new ListNode(plus);
                }
                break;
            }else {
                l1 = l1 == null ? new ListNode() : l1;
                l2 = l2 == null ? new ListNode() : l2;
                next.next = new ListNode();
                next = next.next;
            }
        }
        return node;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
