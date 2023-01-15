package p3linklist;

import java.util.HashSet;

public class T10CirCleLink2_LC142 {
    public static void main(String[] args) {

    }

    // 解法1：hash辅助
    public static ListNode method1(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();

        while (head != null) {
            if (map.contains(head)) {
                return head;
            } else {
                map.add(head);
            }
            head = head.next;
        }

        return null;

    }


    // 解法2：双指针，先两倍速，相遇后，一个指针回到head，再同步
    public static ListNode method2(ListNode head) {
        ListNode q = head;
        ListNode p = head;
        if (head == null || head.next == null) {
            return null;
        }
        while (q != null) {
            q = q.next;
            if (q != null) q = q.next;
            p = p.next;
            if (p == q) {
                p = head;
                while(p != q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }


        return null;
    }
}
