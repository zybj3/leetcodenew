import java.util.ArrayList;
import java.util.List;

public class removeinvalidparentheses {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)=='('){
                left++;
            }else if (s.charAt(i)==')'){
                if (left!=0){
                    left--;
                }else {
                    right++;
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);
        List<String> res = new ArrayList<>();
        dfs(sb, 0, left, right, res);
        return res;
    }

    public void dfs(StringBuilder sb, int index, int left, int right, List<String> res){
        if (left==0 && right==0){
            if (isValid(sb)){
                res.add(new String(sb));
            }
            return;
        }

        for (int i=index;i<sb.length();i++){
            if (i>index && sb.charAt(i)==sb.charAt(i-1)){
                continue;
            }
            StringBuilder copy1 = new StringBuilder(sb);
            StringBuilder copy2 = new StringBuilder(sb);
            if (sb.charAt(i)=='(' && left>0){
                copy1.deleteCharAt(i);
                dfs(copy1, i, left-1, right, res);
            }else if (sb.charAt(i)==')' && right>0){
                copy2.deleteCharAt(i);
                dfs(copy2, i, left, right-1, res);
            }
        }


    }


    public boolean isValid(StringBuilder sb){
        int left = 0;
        int right = 0;

        for (int i=0; i<sb.length(); i++){
            if (sb.charAt(i)=='('){
                left++;
            }else if (sb.charAt(i)==')'){
                if (left!=0){
                    left--;
                }else {
                    right++;
                }
            }
        }

        return left==0 && right==0;
    }

}
