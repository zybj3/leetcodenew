import java.util.Arrays;
import java.util.Comparator;

public class nonoverlapingintervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });


        int end = intervals[0][1];
        int res = 0;

        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]<end){
                end = Math.min(end, intervals[i][1]);
                res++;
            }else {
                end = intervals[i][1];
            }
        }

        return res;
    }
}
