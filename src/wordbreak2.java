import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wordbreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashMap<Integer, List<String>> memo = new HashMap<>();

        return dfs(s, 0, wordDict, memo);

    }


    public List<String> dfs(String s, int start,List<String> wordDict, HashMap<Integer, List<String>> memo){
        if (memo.containsKey(start)){
            return memo.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start==s.length()){
            res.add("");
            return res;
        }

        String curr = s.substring(start);
        for (String word: wordDict){
            if (curr.startsWith(word)){
                List<String> sublist = dfs(s, start+word.length(), wordDict, memo);
                for (String sub: sublist){
                    res.add(word + (sub.isEmpty()?"" :" ") + sub);
                }
            }
        }

        memo.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        test(sb.append("aaaa"));
        System.out.println(sb);
    }

    static void test(StringBuilder sb){

    }
}
