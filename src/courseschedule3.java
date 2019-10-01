import java.util.Arrays;
import java.util.PriorityQueue;

public class courseschedule3 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for (int i=0;i<courses.length;i++){
            time += courses[i][0];
            pq.add(courses[i][0]);
            if (time>courses[i][1]){
                time -= pq.poll();

            }
        }

        return pq.size();
    }
}
