import java.util.Arrays;
import java.util.HashMap;

public class CanIWIN {
    HashMap<String,Boolean> map = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal==0){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        return helper(maxChoosableInteger,desiredTotal,new boolean[maxChoosableInteger+1]);
    }

    public boolean helper(int max, int desired, boolean[] used){
        if (desired<=0){
            return false;
        }

        String path = Arrays.toString(used);
        if (map.getOrDefault(path,null)!=null){
            return map.get(path);
        }

        for (int i=1;i<=max;i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            if (!helper(max,desired-i,used)){
                map.put(path,true);
                used[i] = false;
                return true;

            }
            used[i] = false;
        }

        map.put(path,false);
        return false;


    }
}
