import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class implementtrie {
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
}
