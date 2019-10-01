import java.util.*;

public class wordsearch2 {
    class Trie {
        class Node{
            char value;

            public HashMap<Character, Node> getChildren() {
                return children;
            }

            public void setChildren(HashMap<Character, Node> children) {
                this.children = children;
            }

            HashMap<Character,Node> children;


            public char getValue() {
                return value;
            }

            public void setValue(char value) {
                this.value = value;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }

            boolean isEnd;

            public Node(){
                this.children = new HashMap<>();
            }
        }

        Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node copy = root;
            for (char chr:chars){
                if (copy.getChildren().containsKey(chr)){
                    copy = copy.getChildren().get(chr);
                }
                else {
                    Node newNode = new Node();
                    newNode.setValue(chr);
                    copy.getChildren().put(chr,newNode);
                    copy = newNode;
                }
            }

            copy.setEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node copy = root;
            for (char chr: chars){
                if (copy.getChildren().containsKey(chr)){
                    copy = copy.getChildren().get(chr);
                }else {
                    return false;
                }
            }

            return copy.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node copy = root;
            for (char chr: chars){
                if (copy.getChildren().containsKey(chr)){
                    copy = copy.getChildren().get(chr);
                }else {
                    return false;
                }
            }

            return true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Trie.Node root = trie.root;

        HashSet<String> res = new HashSet<>();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                dfs(board, root, i, j, new StringBuilder(), new boolean[board.length][board[0].length], res);
            }
        }

        return new ArrayList<>(res);
    }


    public void dfs(char[][] board, Trie.Node root, int row, int col, StringBuilder sb,
                    boolean[][] visided, HashSet<String> res){
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

        if (root.isEnd){
            //System.out.println(row + " " + col +" " + root.children);
            res.add(new String(sb));
        }

        if (row<0 || row>board.length-1 || col<0 || col>board[0].length-1){
            return;
        }







        if(root.children.isEmpty()){
            return;
        }


        if (!root.children.containsKey(board[row][col])){
            return;
        }

        for (char chr: root.children.keySet()){
            if (chr==board[row][col] && !visided[row][col]){
                visided[row][col] = true;
                sb.append(chr);
                //System.out.println(root.children.get('a').isEnd);
                for (int[] dir: dirs) {
                    dfs(board, root.children.get(chr), row+dir[0], col+dir[1], sb, visided, res);
                }
                visided[row][col] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
