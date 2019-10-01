import java.util.ArrayList;
import java.util.List;

public class partitionlabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];
        for (int i=0;i<S.length();i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i=0;i<S.length();i++){
            end = Math.max(end,last[S.charAt(i)-'a']);
            if (end==i){
                list.add(end-start+1);
                start = end + 1;
            }
        }
        return list;
    }
}
