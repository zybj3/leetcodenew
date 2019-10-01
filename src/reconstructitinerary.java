import java.util.*;

public class reconstructitinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (int i=0; i<tickets.size(); i++){
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);

            if (map.containsKey(from)){
                map.get(from).offer(to);
            }else {
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.offer(to);
                map.put(from, pq);
            }
        }

        dfs("JFK", map);
        Collections.reverse(path);
        return path;
    }

    List<String> path = new ArrayList<>();
    public void dfs(String cur, HashMap<String, PriorityQueue<String>> map){

        while (map.containsKey(cur) && !map.get(cur).isEmpty()){
            dfs(map.get(cur).poll(), map);
        }

        path.add(cur);
    }
}
