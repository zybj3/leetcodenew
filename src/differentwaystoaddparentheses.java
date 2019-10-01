import java.util.ArrayList;
import java.util.List;

public class differentwaystoaddparentheses {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input);
    }

    public List<Integer> helper(String input){
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<input.length();i++){
            if (!Character.isDigit(input.charAt(i))){
                List<Integer> left = helper(input.substring(0,i));
                List<Integer> right = helper(input.substring(i+1,input.length()));
                for (int leftnum:left){
                    for (int rightnum:right){
                        if (input.charAt(i)=='*'){
                            res.add(leftnum*rightnum);
                        }
                        else if (input.charAt(i)=='+'){
                            res.add(leftnum+rightnum);
                        }
                        else res.add(leftnum-rightnum);
                    }
                }
            }
        }

        if (res.size()==0){
            res.add(Integer.parseInt(input));
        }

        return res;
    }
}
