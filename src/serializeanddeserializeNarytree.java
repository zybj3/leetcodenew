import java.util.*;

public class serializeanddeserializeNarytree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(Node root, StringBuilder sb){
        if (root==null){
            sb.append("N");
            sb.append(",");
        }else {
            sb.append(root.val);
            sb.append(",");
            sb.append(root.children.size());
            sb.append(",");
            for (Node child: root.children){
                buildString(child, sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        System.out.println(data);
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return helper(deque);
    }

    public Node helper(Deque<String> deque){
        String s1 = deque.pollFirst();
        if (s1.equals("N")){
            return null;
        }

        int rootval = Integer.valueOf(s1);
        int childnumber = Integer.valueOf(deque.pollFirst());

        List<Node> nodes = new ArrayList<>();
        Node root = new Node(rootval,nodes);
        for (int i=0; i<childnumber; i++){
            nodes.add(helper(deque));
        }

        return root;
    }
}
