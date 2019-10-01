import java.util.HashMap;

public class SoupServings {
    HashMap<String,Double> map = new HashMap<>();
    public double soupServings(int N) {

        return N>4800? 1: dfs(N,N);
    }

    private double dfs(int A, int B){
        if (A <=0 && B<=0){
            return 0.5;
        }

        if (A<=0){
            return 1;
        }

        if (B<=0){
            return 0;
        }
        String str = "";
        str += A;
        str += B;
        if (map.containsKey(str)){
            return map.get(str);
        }
        double amount = 0.25*(dfs(A-100,B)+dfs(A-75,B-25)+dfs(A-50,B-50) + dfs(A-25,B-75));
        map.put(str,amount);
        return amount;

    }
}
