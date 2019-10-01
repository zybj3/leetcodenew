import java.util.*;

class AutocompleteSystem {
    Trie trie;
    HashMap<String, Integer> map;
    String input = "";
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        map = new HashMap<>();
        for (int i=0; i<sentences.length; i++){
            trie.insert(sentences[i]);
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c =='#'){
            if (input.length()>0){
                trie.insert(input);
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
            input = "";
            return new ArrayList<>();
        }

        input+=c;
        List<String> res = new ArrayList<>();
        if (trie.startsWith(input)) {
            res = trie.getAll(input, map);
        }
        return res;
    }
}

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

    public Node endNode(String prefix) {
        char[] chars = prefix.toCharArray();
        Node copy = root;
        for (char chr: chars){
            if (copy.getChildren().containsKey(chr)){
                copy = copy.getChildren().get(chr);
            }else {
                return null;
            }
        }

        return copy;
    }


    public List<String> getAll(String prefix ,HashMap<String, Integer> map){
        Node endNode = endNode(prefix);
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1)==map.get(o2)){
                    return o2.compareTo(o1);
                }
                return map.get(o1) - map.get(o2);
            }
        });

        gethelper(new StringBuilder(prefix), endNode, pq);
        List<String> res = new ArrayList<>();
        int size = pq.size();
        for (int i=0; i<size; i++){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public void gethelper(StringBuilder sb, Node cur, PriorityQueue pq){
        if (cur.isEnd){
            //System.out.println(sb);
            pq.offer(sb.toString());
            if (pq.size()==4){
                pq.poll();
            }
        }
        for (char child: cur.children.keySet()) {
            sb.append(child);
            //System.out.println(child);
            gethelper( sb, cur.children.get(child), pq);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
