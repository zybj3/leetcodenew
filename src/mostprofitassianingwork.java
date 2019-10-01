import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class mostprofitassianingwork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int slow = 0;
        int i=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i1=0;i1<difficulty.length;i1++){
            map.put(difficulty[i1],Math.max(profit[i1],map.getOrDefault(difficulty[i1],0)));
        }

        int curmax = 0;
        int maxprofit = 0;
        Arrays.sort(worker);
        Arrays.sort(difficulty);
        while (i<worker.length){
            if (slow>=difficulty.length){
                maxprofit += curmax;
                i++;
                continue;

            }

            while (slow<difficulty.length && worker[i]>=difficulty[slow]){
                curmax = Math.max(curmax,map.get(difficulty[slow]));
                slow++;
            }
            maxprofit += curmax;
            i++;


        }

        return maxprofit;
    }
}
