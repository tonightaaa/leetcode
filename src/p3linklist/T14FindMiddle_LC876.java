package p3linklist;

public class T14FindMiddle_LC876 {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        if(head == null ){
            return head;
        }


        ListNode q = head;
        ListNode p = head;

        while(q.next != null && p.next != null){
            p = p.next;
            q = q.next;
            if(q.next == null){
                break;
            }
            q = q.next;

        }


        return p;
    }
}
