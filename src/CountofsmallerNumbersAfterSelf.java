import java.util.*;


public class CountofsmallerNumbersAfterSelf {
    class Bit {
        class Node {
            int val;
            int dup = 1;
            int sum;
            Node left, right;

            public Node(int val, int sum) {
                this.val = val;
                this.sum = sum;
            }
        }

        public Node insert(Node root, int num, int prefixSum, int index, int[] ans) {
            if (root == null) {
                root = new Node(num, 0);
                ans[index] = prefixSum;
            } else if (root.val > num) {
                root.sum++;
                root.left = insert(root.left, num, prefixSum, index, ans);
            } else if (root.val == num) {
                root.dup++;
                ans[index] = prefixSum + root.sum;
            } else {
                root.right = insert(root.right, num, prefixSum + root.sum + root.dup, index
                        , ans);
            }
            return root;
        }
    }

    public List<Integer> countSmaller(int[] nums) {

        Bit tree = new Bit();
        Bit.Node node = null;
        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            node = tree.insert(node, nums[i], 0, i, ans);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : ans) {
            res.add(num);
        }

        return res;
    }

}
