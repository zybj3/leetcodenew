import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LFUCache {

    class Node{
        Node prev, next;
        int key, value;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    private void insertOnHead(Node n, Node head){
        Node headnext = head.next;
        head.next = n;
        n.next = headnext;
        n.prev = head;
        headnext.prev = n;
    }

    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }



    Map<Integer, Node> NodeMap;
    Map<Integer, Integer> keyMap;
    Map<Integer, Integer> freMap;
    Map<Integer, Node> freNodesMap;
    Map<Integer, Node> freNodesTail;

    private int capacity;
    private int size = 0;
    private int minFre = 1;
    public LFUCache(int capacity) {
        freMap = new HashMap<>();
        keyMap = new HashMap<>();
        freNodesMap = new HashMap<>();
        NodeMap = new HashMap<>();
        freNodesTail = new HashMap<>();
        this.capacity = capacity;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;

        freNodesMap.put(1,head);
        freNodesTail.put(1, tail);
    }

    public int get(int key) {
        if (keyMap.containsKey(key)){

            int fre = freMap.get(key);
            Node node = NodeMap.get(key);
            remove(node);
            Node head = null;
            Node oldhead = freNodesMap.get(fre);
            if (freNodesMap.containsKey(fre + 1)) {
                head = freNodesMap.get(fre + 1);
            }else {
                head = new Node(0, 0);
                Node tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                freNodesMap.put(fre+1, head);
                freNodesTail.put(fre+1, tail);
            }

            if (fre==minFre && oldhead.next.next==null){
                minFre++;
            }

            Node newhead = freNodesMap.get(fre+1);
            insertOnHead(node,newhead);
            freMap.put(key, fre + 1);
            return keyMap.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if (size==capacity && !keyMap.containsKey(key)){
            // System.out.println(minFre);
            // System.out.println(freMap);

            Node tail = freNodesTail.get(minFre);



            Node remove_node = tail.prev;
            //System.out.println(remove_node.key);
            int remove_key = remove_node.key;
            NodeMap.remove(remove_key);
            freMap.remove(remove_key);
            keyMap.remove(remove_key);
            remove(remove_node);
            // if (tail.prev.prev==null){
            //     minFre++;
            // }
            size--;
        }

        if (keyMap.containsKey(key)){
            keyMap.put(key, value);
            Node node = NodeMap.get(key);
            node.value = value;
            int fre = freMap.get(key);
            remove(node);
            if (freNodesMap.containsKey(fre + 1)){
                Node head = freNodesMap.get(fre + 1);
                insertOnHead(node, head);
            }else {
                Node head = new Node(0, 0);
                Node tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                freNodesMap.put(fre+1, head);
                freNodesTail.put(fre+1, tail);
                insertOnHead(node, head);
            }
            Node oldhead = freNodesMap.get(fre);
            if (fre==minFre && oldhead.next.next==null){
                minFre++;
            }
            freMap.put(key, fre+1);
        }else {
            keyMap.put(key,value);
            Node node = new Node(key, value);
            NodeMap.put(key, node);
            freMap.put(key, 1);
            Node head = freNodesMap.get(1);
            insertOnHead(node, head);
            minFre = 1;
            size++;
        }


    }
}



