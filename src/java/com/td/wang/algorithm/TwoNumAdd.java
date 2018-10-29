package com.td.wang.algorithm;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by shigen.wang 2018/10/29
 *
 * @author shigen.wang
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class TwoNumAdd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Next = new ListNode(4);
        l1.setNext(l1Next);
        l1Next.setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
        ListNode l2Next = new ListNode(6);
        l2.setNext(l2Next);
        l2Next.setNext(new ListNode(4));
        test1(l1, l2);
    }

    public static ListNode test1(ListNode l1, ListNode l2) {
        StringBuffer numStr1 = new StringBuffer(l1.getVal() + "");
        StringBuffer numStr2 = new StringBuffer(l2.getVal() + "");
        while (l1.getNext() != null) {
            l1 = l1.getNext();
            numStr1.append(l1.getVal());
        }
        numStr1 = numStr1.reverse();
        System.out.println();
        while (l2.getNext() != null) {
            l2 = l2.getNext();
            numStr2.append(l2.getVal());
        }
        numStr2 = numStr2.reverse();
        int num1 = Integer.parseInt(numStr1.toString());
        int num2 = Integer.parseInt(numStr2.toString());
        int sum = num1 + num2;
        String ss = sum + "";
        ListNode result = new ListNode(Integer.parseInt(ss.charAt(ss.length() - 1) + ""));
        ListNode pre = result;
        for (int i = ss.length() - 2; i >= 0; i--) {
            String s = ss.charAt(i) + "";
            ListNode node = new ListNode(Integer.parseInt(s));
            if (i == ss.length() - 2) {
                result.setNext(node);
            } else {
                pre.setNext(node);
            }
            pre = node;
        }
        System.out.println(result.getVal());
        while (result.getNext() != null){
            result = result.getNext();
            System.out.println(result.getVal());
        }
        return result;
    }

}

class ListNode {

    private Integer val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
