import java.util.ArrayList;
import java.util.PriorityQueue;

public class mergeKsortedlist {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<ListNode> list = new ArrayList<>();
        for (ListNode head:lists){
            while (head!=null){
                pq.add(head.val);
                head = head.next;
            }

        }

        while (!pq.isEmpty()){
            int num = pq.poll();
            ListNode node = new ListNode(num);
            list.add(node);
        }

        for (int i=0;i<list.size()-1;i++){
            list.get(i).next = list.get(i+1);

        }

        return list.get(0);
    }

}
