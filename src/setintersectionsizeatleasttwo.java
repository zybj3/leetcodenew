import java.util.Arrays;
import java.util.Comparator;

public class setintersectionsizeatleasttwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[1]-b[1]));

        int p1 = -1, p2 = -1,res = 0;

        for (int i=0;i<intervals.length;i++){
            if (intervals[i][0]<=p1){
                continue;
            }
            else if (intervals[i][0]>p2){
                res+=2;
                p2 = intervals[i][1];
                p1 = p2 -1;
            }
            else {
                res+=1;
                p1 = p2;
                p2 = intervals[i][1];
            }
        }

        return res;

    }
}
