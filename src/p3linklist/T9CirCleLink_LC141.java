package p3linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class T9CirCleLink_LC141 {
    public static void main(String[] args) {

    }

    // 解法1：hash辅助
    public static boolean method1(ListNode head){
        HashSet<ListNode> map = new HashSet<>();

        while (head != null){
            if(map.contains(head)){
                return true;
            }else {
                map.add(head);
            }
            head = head.next;
        }

        return false;

    }


    // 解法2：双指针
    public static boolean method2(ListNode head){
        ListNode q = head;
        ListNode p = head;
        if(head == null || head.next == null){
            return false;
        }
        while(q != null){
            q = q.next;
            if(q != null) q = q.next;
            p = p.next;
            if(p == q){
                return true;
            }
        }



        return false;
    }
}
