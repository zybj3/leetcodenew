import java.util.Arrays;
import java.util.HashMap;

public class binarytreeswithfactors {
    HashMap<Integer,Long> map = new HashMap<>();
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        long res = 0;
        int mod = 1000000007;
        for (int i=0;i<A.length;i++){
            long count = 1;
            for (int j=0;j<i;j++){
                if (A[i]%A[j]==0 && map.containsKey(A[i]/A[j])){
                    count += map.get(A[j])*map.get(A[i]/A[j])%mod;
                }
            }
            map.put(A[i],count);

        }

        for (Integer num:map.keySet()){
            res = (res + map.get(num))%mod;
        }

        return (int)res;
    }
}
