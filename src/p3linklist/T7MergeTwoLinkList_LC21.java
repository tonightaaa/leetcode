package p3linklist;

public class T7MergeTwoLinkList_LC21 {
    public static void main(String[] args) {

    }

    // 解法1：正常合并
    public static ListNode method1(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode head = new ListNode();
        
        ListNode temp = head;
        
        
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                
                // temp指针指向list1
                temp.next = list1;
                // list1指向下一个元素
                list1 = list1.next;

            }else{
                // temp指针指向list2
                temp.next = list2;
                // list2指向下一个元素
                list2 = list2.next;

            }
            // temp指向新来的结点
            temp = temp.next;
            // 去掉新结点与过去的联系
            temp.next = null;
        }


        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }
        
        

        return head.next;
    }

    // 解法2：递归思想
    public static ListNode method2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = method2(list1.next, list2);
            return list1;
        }else{
            list2.next = method2(list1, list2.next);
            return list2;
        }

    }
}
