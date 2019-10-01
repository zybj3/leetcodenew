public class binarytreemaximumpathsum {

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    int max = -1000000000;
    public int helper(TreeNode root){
        if (root==null){
            return 0;
        }

        int leftMax = Math.max(0, helper(root.left));
        int rightMax = Math.max(0, helper(root.right));
        max = Math.max(max, leftMax+rightMax+root.val);

        return root.val + Math.max(leftMax, rightMax);

    }
}
