import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class distantbarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<barcodes.length;i++){
            if (map.containsKey(barcodes[i])){
                map.put(barcodes[i],map.get(barcodes[i])+1);
            }else {
                map.put(barcodes[i],1);
            }
        }

        for (int i:map.keySet()){
            pq.add(new int[]{i,map.get(i)});
        }

        List<List<Integer>> res = new ArrayList<>();
        int num = pq.peek()[0];
        int length = pq.peek()[1];
        pq.poll();
        for (int i=0;i<length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(num);
            res.add(list);
        }

        int index = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            num = cur[0];
            length = cur[1];
            while (length>0) {
                List curList = res.get(index++);
                curList.add(num);
                index %= res.size();
                length--;
            }
        }

        int[] ans = new int[barcodes.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index1<ans.length){
            if (index3>=res.get(index2).size()){
                index2++;
                index3 = 0;
            }
            ans[index1] = res.get(index2).get(index3);
            index1++;
            index3++;
        }
        return ans;
    }
}
