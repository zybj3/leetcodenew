import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words){
            count.put(word, 0);
        }

        int max = 1;
        for (String word: words){
            max = Math.max(dfs(word, count),max);
        }

        return max;
    }

    public int dfs(String word, Map<String, Integer> count){
        if (!count.containsKey(word)){
            return 0;
        }

        if (count.containsKey(word) && count.get(word)>0){
            return count.get(word);
        }
        StringBuilder sb = new StringBuilder(word);

        int max = 1;
        for (int i=0; i<sb.length();i++){
            char chr = sb.charAt(i);
            String next = sb.deleteCharAt(i).toString();
            max = Math.max(max, 1 + dfs(next, count));
            sb.insert(i, chr);
        }
        count.put(word, max);
        return max;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(1);
        System.out.println(pq);

        pq.remove(1);
        System.out.print(pq);
    }
}
