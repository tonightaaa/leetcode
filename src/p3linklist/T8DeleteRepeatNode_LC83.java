package p3linklist;

public class T8DeleteRepeatNode_LC83 {

    public static void main(String[] args) {

    }

    // 解法1：遍历
    public static ListNode method1(ListNode head) {

        // 注意边界情况
        if (head == null) {
            return null;
        }


        ListNode temp = head;
        while (temp.next != null) {
            ListNode q = temp.next;

            if (temp.val == q.val) {
                temp.next = q.next;
            } else {
                temp = temp.next;
            }

        }
        return head;
    }

    // 解法2：递归思想

    public static ListNode method2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        head.next = method2(head.next);

        return head.val == head.next.val ? head.next : head;
    }

}
