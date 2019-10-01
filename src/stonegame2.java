import java.util.HashMap;
import java.util.HashSet;

public class stonegame2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sum = new int[n];
        sum[n-1] = piles[n-1];
        for (int i=n-2; i>=0; i--){
            sum[i] = sum[i+1] + piles[i];
        }


        return dfs(0, piles, 1, sum);

    }

    HashMap<String, Integer> map = new HashMap<>();
    public int dfs(int start, int[] piles, int M, int[] sum){
        if (start==piles.length){
            return 0;
        }
        if (start+2*M>=piles.length){
            return sum[start];
        }

        if (map.containsKey(start + " " + M)){
            return map.get(start + " " + M);
        }

        int min = Integer.MAX_VALUE;
        for (int x=1; x<=2*M; x++){
            min = Math.min(min, dfs(start+x, piles, Math.max(x,M), sum));
        }
        map.put(start + " " + M, sum[start] - min);

        return sum[start] - min;
    }



}
