import java.util.HashMap;

public class subarraysumsdivisiblebyK {
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i=0;i<A.length;i++){
            sum += A[i];
            int key = sum%K;

            if (map.containsKey(key)){
                res+=map.get(key);
            }
            if (map.containsKey(key-K)){
                res+=map.get(key-K);
            }
            if (map.containsKey(key+K)){
                res+=map.get(key+K);
            }

            map.put(key, map.getOrDefault(key, 0)+1);
        }

        return res;
    }
}
