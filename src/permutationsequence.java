import java.util.ArrayList;
import java.util.List;

public class permutationsequence {
    int count = 0;
    StringBuilder sb = new StringBuilder();
    List<Integer> list = new ArrayList<>();
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean [n+1];
        dfs(n,k,used);
        return sb.toString();
    }

    public void dfs(int n,int k,boolean[] used){
        if (list.size()==n){
            if (count==k-1){
                for (int num:list){
                    sb.append(num);
                }
                count++;
            }
            else {
                count++;
            }
            return;
        }

        for (int i=1;i<=n;i++){
            if (!used[i]) {
                list.add(i);
                used[i] = true;
                dfs(n, k, used);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}
