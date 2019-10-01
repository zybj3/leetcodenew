import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class insertinterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> left = new ArrayList<>(), right = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        for (int i=0; i<intervals.length; i++){
            if (intervals[i][1]<start) {
                left.add(intervals[i]);
            }
            else if (intervals[i][0]>end){
                right.add(intervals[i]);
            }else {
               start = Math.min(start, intervals[i][0]);
               end = Math.max(end, intervals[i][1]);
            }
        }

        List<int[]> res = new ArrayList<>();
        res.addAll(left);
        res.add(new int[]{start, end});
        res.addAll(right);

        return res.toArray(new int[res.size()][]);
    }
}
