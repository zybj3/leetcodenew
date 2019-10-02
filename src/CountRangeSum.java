public class CountRangeSum {
    //BST 解法 可能会退化到O(n)
    class Node {
        long val;
        int count = 1;
        int left_size;
        int right_size;
        Node left, right;

        public Node(long val) {
            this.val = val;
        }
    }

    public Node insert(Node root, long val) {
        if (root == null) {
            root = new Node(val);
        } else if (root.val > val) {
            root.left_size++;
            insert(root.left, val);
        } else if (root.val == val) {
            root.count++;
        } else if (root.val < val) {
            root.right_size++;
            insert(root.right, val);
        }

        return root;
    }

    public int getSmaller(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (root.val > val) {
            return getSmaller(root.left, val);
        } else if (root.val < val) {
            return getSmaller(root.right, val) + root.count + root.left_size;
        } else {
            return root.left_size;
        }
    }

    public int getLarger(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (root.val > val) {
            return getLarger(root.left, val) + root.count + root.right_size;
        } else if (root.val < val) {
            return getLarger(root.right, val);
        } else {
            return root.right_size;
        }
    }

    public int getBound(Node root, long lower, long upper){
        // if(root==null){
        //     return 0;
        // }
        int total = root.count + root.left_size + root.right_size;
        int lowerbound = getSmaller(root, lower);
        int upperbound = getLarger(root, upper);
        return total - lowerbound - upperbound;
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) {
            return 0;
        }


        long sum = 0;
        int res = 0;

//         if (sum<=upper && sum>=lower){
//             res+=1;
//         }

        Node root = new Node(0);
        // root = insert(root, sum);

        for (int i = 0; i<nums.length; i++){
            sum += nums[i];
            System.out.println((sum-upper) + " " + (sum-lower));
            int count = getBound(root, sum-upper, sum-lower);
            System.out.println(count);
            root = insert(root, sum);
            res += count;
        }

        return res;
    }
}
