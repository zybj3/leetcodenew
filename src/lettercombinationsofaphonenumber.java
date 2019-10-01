import java.util.ArrayList;
import java.util.List;

public class lettercombinationsofaphonenumber {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0){
            return res;
        }
        String[] map = new String[8];
        map[0] = "abc"; map[1]="def"; map[2] = "ghi"; map[3] = "jkl"; map[4] = "mno";
        map[5] = "pqrs"; map[6] = "tuv"; map[7] = "wxyz";

        backtrack(0,digits,map);
        return res;
    }

    public void backtrack(int index, String digits, String[] map){
        if (index>=digits.length()){
            res.add(new String(sb.toString()));
            return;
        }

        int interger = Character.getNumericValue(digits.charAt(index));
        for (int i=0;i<map[interger-2].length();i++){
            sb.append(map[interger-2].charAt(i));
            backtrack(index+1,digits,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
