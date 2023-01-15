package p3linklist;

import java.util.List;
import java.util.Stack;

public class T13IsPalindrome {
    public static void main(String[] args) {

    }


    // 解法1:使用双指针，其中一个两倍速，找到中间结点，将前半部分入栈，之后对比后半部分
    public static boolean method1(ListNode head){
        if(head == null ){
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode q = head;
        ListNode p = head;

        while(q != null && p!= null){
            stack.add(p.val);
            p = p.next;

            q = q.next;
            if(q == null){
                stack.pop();
                break;
            }
            q = q.next;
        }
        while(p != null){
            if(p.val != stack.pop()){
                return false;
            }
            p = p.next;
        }

        return true;
    }

    // 解法2：将前半部分反转，分裂为两个链表
    public static boolean method2(ListNode head){
        if(head == null ){
            return false;
        }


        ListNode q = head;
        ListNode p = head;

        while(q != null && p!= null){
            p = p.next;
            q = q.next;
            if(q == null){
                break;
            }
            q = q.next;

        }

        q = head;

        // 反转p指向的链表
        ListNode pre = null;
        ListNode cur = p;
        ListNode next = null;
        while (cur != null){

            next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }

        while(pre != null){
            if(pre.val != q.val){
                return false;
            }
            q = q.next;
            pre = pre.next;
        }

        return true;
    }
}
