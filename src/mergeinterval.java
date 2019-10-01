import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class mergeinterval {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        if (intervals.length==0 || intervals==null){
            return new int[0][0];
        }
        Stack<int[]> stack = new Stack<>();
        for (int i=intervals.length-1;i>0;i--){
            stack.push(intervals[i]);
        }
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        while (!stack.isEmpty()){
            int[] top = stack.pop();
            int[] cur = list.get(list.size()-1);
            if (cur[1]>=top[0]){
                cur[1] = Math.max(cur[1],top[1]);
            }
            else{
                list.add(top);
            }

        }

        int[][] res = new int[list.size()][2];
        for (int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
