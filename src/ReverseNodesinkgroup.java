import java.util.ArrayList;

public class ReverseNodesinkgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list1 = new ArrayList<>();
        ArrayList<ListNode> list2 = new ArrayList<>();

        ListNode slow = head,fast = head;
        while (fast!=null) {
            for (int i = 0; i < k-1; i++) {
                fast = fast.next;
                if (fast == null) {
                    break;
                }
            }

            if (fast!=null) {
                list1.add(slow);
                ListNode nextrev = fast.next;
                fast.next = null;
                reverselist(slow, k);
                slow = nextrev;
                list2.add(fast);
                fast = slow;
            }
            else {
                list2.add(slow);
            }
        }
        for (int i=0;i<list1.size();i++){
            if (list2.size()>=i) {
                list1.get(i).next = list2.get(i + 1);
            }
        }
        return list2.get(0);
    }


    public void reverselist(ListNode slow, int k) {
        if (slow.next==null && k==1) {
            return;
        }
        ListNode next = slow.next;
        slow.next = null;
        reverselist(next, k - 1);
        next.next = slow;
    }


}

