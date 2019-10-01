import java.util.ArrayList;
import java.util.List;

public class palindromepartitioning {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0);
        return res;
    }

    public void dfs(String s, int start){
        if (start>=s.length()){

            res.add(new ArrayList<>(list));
            return;
        }


        for (int j=start+1;j<=s.length();j++){
            String substr = s.substring(start,j);
            if (check(substr)){
                // System.out.println(substr);
                list.add(substr);
                dfs(s,j);
                list.remove(list.size()-1);
            }
        }




    }

    public boolean check(String str){
        if (str.length()==1){
            return true;
        }

        for (int i=0, j=str.length()-1; i <= j; i++,j--){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
        }

        return true;
    }
}
