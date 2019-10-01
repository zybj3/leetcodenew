import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class carpooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o1[2] - o2[2];
                }
                return o1[1]-o2[1];
            }
        });

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });


        int cap = 0;
        for (int i=0; i<trips.length; i++){
            while (!priorityQueue.isEmpty() && trips[i][1]>=priorityQueue.peek()[2]){
                cap -= priorityQueue.poll()[0];
            }
            priorityQueue.offer(trips[i]);
            cap += trips[i][0];
            if (cap>capacity){
                return false;
            }
        }


        return true;
    }
}
