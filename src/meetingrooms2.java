import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class meetingrooms2 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else
                return o1[0]-o2[0];
            }
        });


        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        endTime.offer(intervals[0][1]);

        for (int i=1; i<intervals.length; i++){
            if (endTime.peek()>intervals[i][0]){
                endTime.offer(intervals[i][1]);
            }else {
                int endtime = endTime.poll();
                endTime.offer(intervals[i][1]);
            }
        }

        return endTime.size();
    }
}
