import java.util.*;

public class verticalordertraversalofabinarytree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
         dfs(root,0,0);
         for (TreeMap<Integer,PriorityQueue<Integer>> values:map.values()){
             List<Integer> list = new ArrayList<>();
             for (PriorityQueue<Integer> pq:values.values()){
                 while (!pq.isEmpty()){
                     list.add(pq.poll());
                 }
             }

             res.add(list);
         }

        return res;
    }

    public void dfs(TreeNode root,int layer,int height){
        if (root==null){
            return;
        }

        if (map.get(layer)==null){
            map.put(layer,new TreeMap<>());
        }
        if (map.get(layer).get(height)==null){
            map.get(layer).put(height,new PriorityQueue<>());
        }

        map.get(layer).get(height).offer(root.val);




        dfs(root.left,layer-1,height+1);
        dfs(root.right,layer+1,height+1);
    }
}
