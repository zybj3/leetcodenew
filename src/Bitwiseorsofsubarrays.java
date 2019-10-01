import java.util.HashMap;
import java.util.HashSet;

public class Bitwiseorsofsubarrays {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> cur = new HashSet<>();

        for (int i=0;i<A.length;i++){
            HashSet<Integer> next = new HashSet<>();
            next.add(A[i]);

            for (int num:cur){
                next.add(num | A[i]);
            }

            res.addAll(next);
            cur = next;
        }

        return res.size();

    }
}
