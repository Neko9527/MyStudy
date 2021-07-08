package com.xcw.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuechao
 * @date 2021-05-31
 */
public class LC21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1,l2);
    }


    /**
     * 使用迭代法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null ) {
            return l2;
        }
        if(l2 == null ) {
            return l1;
        }
        ListNode preHead = new ListNode();
        ListNode prev = preHead;
        while (true) {
            int p1 = l1.val;
            int p2 = l2.val;
            if(p1 >= p2) {
                preHead.next = l2;
                l2 = l2.next;
            }else {
                preHead.next = l1;
                l1 = l1.next;
            }
            preHead = preHead.next;
            if(l1 == null) {
                preHead.next = l2;
                break;
            }
            if(l2 == null) {
                preHead.next = l1;
                break;
            }
        }
        return prev.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null ) {
            return l2;
        }
        if(l2 == null ) {
            return l1;
        }
        List<Integer> list = new ArrayList<>();
        int p1 = l1.val;
        int p2 = l2.val;

        while (true) {
            if(p1 == p2) {
                list.add(p1);
                list.add(p1);
                l1 = l1.next;
                l2 = l2.next;
                p1 = l1 == null ? -200 : l1.val;
                p2 = l2 == null ? -200 : l2.val;
            }
            if(p1 > p2) {
                if(p2 != -200) {
                    list.add(p2);
                    l2 = l2.next;
                    p2 = l2 == null ? -200 : l2.val;
                }else {
                    list.add(p1);
                    l1 = l1.next;
                    p1 = l1 == null ? -200 : l1.val;
                }
            }
            if(p1 < p2) {
                if(p1 != -200) {
                    list.add(p1);
                    l1 = l1.next;
                    p1 = l1 == null ? -200 : l1.val;
                }else {
                    list.add(p2);
                    l2 = l2.next;
                    p2 = l2 == null ? -200 : l2.val;
                }
            }
            if(l1 == null && l2 == null)
                break;
        }
        ListNode ret = new ListNode();
        ListNode next = ret;
        for (int i = 0; i < list.size(); i++) {
            ret.val = list.get(i);
            if(i < list.size() - 1) {
                ret.next = new ListNode();
            }
            ret = ret.next;
        }
        return next;
    }
}
