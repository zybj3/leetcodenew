import java.util.ArrayDeque;
import java.util.Deque;

public class serializeanddeserializebinarytree {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }

    public String serialize(TreeNode root) {
        if (root==null){
            return "n";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>();
        String[] arrDate = data.split(",");
        for (String str: arrDate){
            deque.addLast(str);
        }

        System.out.println(deque);
        System.out.println(deque.getFirst());
        return helper(deque);
    }

    public TreeNode helper(Deque<String> data){
        if (data.getFirst().equals("n")){
            //System.out.println("111");
            data.pollFirst();
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data.pollFirst()));
        node.left = helper(data);
        node.right = helper(data);

        return node;
    }
}
