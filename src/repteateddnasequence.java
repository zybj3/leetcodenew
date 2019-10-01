import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class repteateddnasequence {
//    public List<String> findRepeatedDnaSequences(String s) {
//        HashSet<String> seen = new HashSet<>();
//        HashSet<String> repeated = new HashSet<>();
//
//        for (int i=0;i<s.length()-9;i++){
//            if (!seen.add(s.substring(i,i+10))){
//                repeated.add(s.substring(i,i+10));
//            }
//        }
//
//        return new ArrayList(repeated);
//    }

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10){
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        int mask = 0x7ffffff;
        int cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<9;i++){
            cur = (cur<<3) | (s.charAt(i)&7);
        }

        for (int i=9;i<s.length();i++){
            cur = (cur & mask)<<3 | (s.charAt(i)&7);
            if (map.containsKey(cur)){
                if (map.get(cur)==1){
                    res.add(s.substring(i-9,i+1));
                }
                map.put(cur, map.get(cur)+1);
            }else {
                map.put(cur, 1);
            }
        }

        return res;
    }


}
