import java.util.Arrays;

public class minimumnumberofarrowstoburstballoons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        if (points.length==0){
            return 0;
        }
        if (points.length==1){
            return 1;
        }
        int number = 1;
        int high =points[0][1];
        for (int slow=0,fast=1;slow<points.length && fast<points.length;){
            if (points[fast][0]<=high){
                high = Math.min(high,points[fast][1]);
                fast++;
            }
            else {
                high = points[fast][1];
                number++;
                slow = fast;
                fast++;
            }

            System.out.println(high);

        }
        return number;
    }
}
