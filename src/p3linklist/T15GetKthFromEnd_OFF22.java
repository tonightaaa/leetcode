package p3linklist;

public class T15GetKthFromEnd_OFF22 {
    public static void main(String[] args) {

    }

    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode p = head;
        ListNode q = head;

        for(int i = 1; i < k; i++){
            if(q == null){
                return null;
            }
            q = q.next;
        }

        while (q != null){
            p = p.next;
            q = q.next;
        }

        return p;
    }
}
