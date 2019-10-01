import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        Map<String,Integer> map = new HashMap<>();
        for (String str:wordDict){
            map.put(str,1);
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<=i;j++){
                String str = s.substring(j-1,i);
                System.out.println(str);
                if (map.containsKey(str)){
                    if (dp[j-1]){
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[dp.length-1];

    }
}
