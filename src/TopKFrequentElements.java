import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });

        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // System.out.println(map);
        for (int num:map.keySet()){
            pq.add(new int[]{num, map.get(num)});
            if (pq.size()==k+1){
                pq.poll();
            }
        }
        // System.out.println(pq.size());
        for (int i=0;i<k;i++){
            res.add(pq.poll()[0]);
        }

        return res;
    }
}
