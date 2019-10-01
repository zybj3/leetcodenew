import java.util.HashSet;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        HashSet<Character> set = new HashSet<>();

        String res = "";

        if (strs==null || strs.length==0){
            return res;
        }
        boolean canAdd = true;
        for (int i=0; i<100; i++){
            if (!canAdd){
                break;
            }

            if (i>=strs[0].length()){
                break;
            }

            set = new HashSet<>();
            set.add(strs[0].charAt(i));

            for (int j=1; j<strs.length; j++){
                if (i>=strs[j].length()){
                    canAdd = false;
                    break;
                }

                char chr = strs[j].charAt(i);
                if (set.add(chr)){
                    canAdd = false;
                    break;
                }
            }

            if (canAdd){
                res += strs[0].charAt(i);
            }

        }

        return res;
    }
}
