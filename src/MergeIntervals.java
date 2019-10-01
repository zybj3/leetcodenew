import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });


        Stack<int[]> stack = new Stack<>();
        for (int i=0;i<intervals.length;i++){
            if (stack.isEmpty() || intervals[i][0]>stack.peek()[1]){
                stack.push(intervals[i]);
            }else {
                int[] previous = stack.peek();
                previous[1] = Math.max(previous[1], intervals[i][1]);
            }
        }

        int[][] res = new int[stack.size()][2];
        for (int i=0; i<stack.size(); i++){
            res[i] = stack.get(i);
        }
        return res;



    }
}
