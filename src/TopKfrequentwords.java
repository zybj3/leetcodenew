import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKfrequentwords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b)->{
            if (map.get(a)!=map.get(b)){
                return map.get(b)-map.get(a);
            }
            else {
                int i=0,j=0;

                while (i<a.length() && j<b.length() && a.charAt(i)==b.charAt(j)){
                    i++;
                    j++;
                }
                if (i>=a.length() || j>=b.length()){
                    return a.length()-b.length();
                }
                else
                    return a.charAt(i)-b.charAt(j);
            }
        }
        );

        for (int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        for (int i=0;i<words.length;i++) {
            if (!pq.contains(words[i])) {
                pq.offer(words[i]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i=0;i<k;i++){
            list.add(pq.poll());
        }
        return list;


    }
}
