import java.util.*;

public class cheapestflightswithinkstops {
    HashMap<Integer, HashMap<Integer,Integer>> map = new HashMap<>();
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        for (int i=0;i<flights.length;i++){
            if (map.getOrDefault(flights[i][0],null)==null){
                map.put(flights[i][0],new HashMap<>());
                map.get(flights[i][0]).put(flights[i][1],flights[i][2]);
            }else map.get(flights[i][0]).put(flights[i][1],flights[i][2]);
        }

        int cheapest = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0});
        int step = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int[] cur = queue.poll();
                if (cur[0]==dst){
                    cheapest = Math.min(cur[1],cheapest);
                }
                Set<Integer> set = null;
                if (map.getOrDefault(cur[0],null)==null){
                    continue;
                }
                else{
                    set = map.get(cur[0]).keySet();
                }
                for (int num:set){
                    if (map.get(cur[0]).get(num)+cur[1]<cheapest){
                        queue.add(new int[]{num,map.get(cur[0]).get(num)+cur[1]});
                    }
                }
            }

            if (step++>K){
                break;
            }


        }


        return cheapest == Integer.MAX_VALUE ? -1:cheapest;
    }
}
