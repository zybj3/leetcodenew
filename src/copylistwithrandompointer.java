import java.util.HashMap;

public class copylistwithrandompointer {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        public Node copyRandomList(Node head) {
            HashMap<Integer,Node> map = new HashMap<>();

            Node temp = null;
            Node res = null;
            int iter = 0;
            while (head!=null){
                Node newnode = null;
                if (map.getOrDefault(head.val,null)==null){
                    newnode = new Node(head.val,null,null);
                }
                else {
                    newnode = map.get(head.val);
                }
                map.put(newnode.val,newnode);
                if (head.random!=null){
                    Node random = map.getOrDefault(head.random.val,null);
                    if (random!=null){
                        newnode.random = random;
                    }
                    else {
                        random = new Node(head.random.val, null, null);
                        newnode.random = random;
                        map.put(random.val, random);
                    }
                }
                if (temp!=null){
                    temp.next = newnode;
                    map.replace(newnode.val,newnode);
                    map.replace(temp.val,temp);
                    temp = newnode;
                }
                else {
                    temp = newnode;
                }
                if (iter==0){
                    res = newnode;
                }
                iter++;

                head = head.next;


            }

            return res;


        }
    }
}
