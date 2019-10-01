import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class arrayofdoubledpairs {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i=0;i<A.length;i++){
            if (map.getOrDefault(A[i],null)==null){
                map.put(A[i],1);
            }
            else {
                map.put(A[i],map.get(A[i])+1);
            }
        }

        for (int num:map.keySet()){
            if (map.get(num)==0){
                continue;
            }
            int count = map.get(num);
            if (map.getOrDefault(num*2,null)!=null){
                int count1 = map.get(num*2);
                if (count>count1) {
                    map.put(num, count - count1);
                    map.put(num*2,0);
                }else {
                    map.put(num,0);
                    map.put(num * 2, count1 - count);
                }
            }
        }

        System.out.println(map);

        for (int num:map.keySet()){
            if (map.get(num)!=0){
                return false;
            }
        }

        return true;
    }
}
