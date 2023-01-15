package p3linklist;

import java.awt.*;

public class T12ReverseList_LC206 {
    public static void main(String[] args) {

    }

    // 解法1：三指针
    public static ListNode method1(ListNode head){

        if(head == null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while(cur != null){

            next = cur.next;

            cur.next = pre;

            pre = cur;

            cur = next;

        }



        return pre;

    }


    // 解法2：递归
    public static ListNode method2(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = method2(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;

    }
}
