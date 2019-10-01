public class maximumxoroftwonumbersinanarray {
    class TrieNode{
        int num;
        TrieNode left;
        TrieNode right;
        public TrieNode(int num1){
            this.num = num1;
        }
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode(3);

        for (int i=0; i<nums.length; i++){
            TrieNode cur = root;
            for (int j=31; j>=0; j--){
                int tmp = (nums[i]>>j) & 1;
                if (tmp==0){
                    if (cur.right==null){
                        cur.right = new TrieNode(0);
                    }
                    cur = cur.right;
                }else if (tmp==1){
                    if (cur.left==null){
                        cur.left = new TrieNode(1);
                    }
                    cur = cur.left;
                }
            }
        }

        System.out.println(root.right.num);

        int max = 0;

        for (int i=0; i<nums.length; i++){
            int tmpmax = 0;
            TrieNode curNode = root;
            for (int j=31; j>=0; j--){
                int tmp = (1<<j) & nums[i];

                if (tmp == 0) {
                    if(curNode.left!=null){
                        curNode = curNode.left;
                        tmpmax += 1<<j;
                    }else
                        curNode = curNode.right;
                }
                else {
                    if(curNode.right!=null){
                        curNode = curNode.right;
                        tmpmax += 1<<j;
                    }else
                        curNode = curNode.left;
                }


                //System.out.println(nums[i] + " " + curNode.num + " " + j);

            }
            max = Math.max(max, tmpmax);
            System.out.println(max);
        }

        return max;
    }
}
