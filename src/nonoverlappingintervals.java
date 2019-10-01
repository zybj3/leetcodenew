import java.util.Arrays;

public class nonoverlappingintervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = intervals[0][1];
        for (int i=1;i<intervals.length-1;i++){
            if (intervals[i][0]<end){
                count++;
            }
            else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
