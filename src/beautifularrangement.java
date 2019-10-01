import java.util.ArrayList;
import java.util.List;

public class beautifularrangement {
    int amount = 0;
    public int countArrangement(int N) {
        boolean[] used = new boolean[N];
        backtrack(N,1,used);
        return amount;
    }

    public void backtrack(int N,int entry, boolean[]used){
        if (entry==N+1){
            amount+=1;
            return;
        }
        for (int i=1;i<N+1;i++){
            if (i%entry==0 || entry%i==0){
                if (!used[i-1]){
                    used[i] = true;
                    backtrack(N,entry+1,used);
                    used[i] = false;
                }
            }
        }
    }
}
