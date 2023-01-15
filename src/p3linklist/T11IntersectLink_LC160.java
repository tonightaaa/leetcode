package p3linklist;

import java.util.HashSet;

public class T11IntersectLink_LC160 {
    public static void main(String[] args) {

    }

    
    // 解法1：使用hash
    public static ListNode method1(ListNode headA, ListNode headB){
        HashSet<ListNode> hashSet = new HashSet<>();

        while(headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }


        while(headB != null){
            if(hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    // 解法2：双指针
    public static ListNode method2(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;

        while (q != p){

           if(p != null){
               p = p.next;
           }else{
               p = headB;
           }

           if(q != null){
               q = q.next;
           }else{
               q = headA;
           }

        }

        return q;
    }
}
