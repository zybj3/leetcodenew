public class ReverseLinkedlist {
    ListNode newhead = null;
    public ListNode reverseList(ListNode head) {
        return reverse(head,null);
    }

    public ListNode reverse(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode next = cur.next;
        cur.next = prev;

        return reverse(next, cur);
    }
}
