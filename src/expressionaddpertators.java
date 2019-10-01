import java.util.ArrayList;
import java.util.List;

public class expressionaddpertators {
    public List<String> addOperators(String num, int target) {
        dfs(0, 0, 0, num, target, "");
        return res;
    }

    List<String> res = new ArrayList<>();

    public void dfs(int index, long prev, long curres, String num, int target, String curString){
        if (index>=num.length() && curres==target){
            res.add(curString);
        }

        long number = 0;
        for (int i=index; i<num.length(); i++){
            if(i!=index &&  num.charAt(index) == '0'){
                break;
            }
            number = 10 * number + num.charAt(i) - '0';

            if (index==0){
                dfs(i+1, number, number, num, target, curString + number);
            }
            else {
                dfs(i+1, number, curres + number, num, target, curString + "+" + number);
                dfs(i+1, -number, curres - number, num, target, curString + "-" + number);
                dfs(i+1, prev*number, curres-prev+prev*number, num, target, curString + "*" + number);
            }


        }
    }
}
