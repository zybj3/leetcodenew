import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encodenarytreetobinarytree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root==null){
            return null;
        }

        TreeNode node = new TreeNode(root.val);

        List<Node> children = root.children;
        if (children.size()>0){
            node.right = encode(children.get(0));
        }

        TreeNode copy = node.right;

        for (int i=1; i<children.size(); i++){
            copy.left = encode(children.get(i));
            copy = copy.left;
        }


        return node;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root==null){
            return null;
        }
        Node node = new Node();
        node.children = new ArrayList<>();
        node.val = root.val;

        TreeNode cur = root.right;
        while (cur!=null){
            node.children.add(decode(cur));
            cur = cur.left;
        }

        return node;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaa";
        String[] strs = s.split(",");
        System.out.println(Arrays.toString(strs));
    }

}
