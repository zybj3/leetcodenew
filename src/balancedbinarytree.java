public class balancedbinarytree {
    public boolean isBalanced(TreeNode root) {
        return helper(root, new Height(0));
    }

    class Height{
        int height;
        public Height(int height){
            this.height = height;
        }
    }

    public boolean helper(TreeNode root, Height height){
        if (root==null){
            height.height = 0;
            return true;
        }
        Height left = new Height(0);
        Height right = new Height(0);

        boolean leftIsBalance = helper(root.left, left);
        boolean rightIsBalance = helper(root.right, right);

        height.height = Math.max(left.height+1, right.height+1);

        if (!leftIsBalance){
            return false;
        }

        if (!rightIsBalance){
            return false;
        }

        if (Math.abs(left.height - right.height)<=1){
            return true;
        }else {
            return false;
        }
    }
}
