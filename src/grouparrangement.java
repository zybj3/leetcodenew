import java.util.*;

public class grouparrangement {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Queue, List<String>> map = new HashMap<>();
        String alphbat = "abcdefghijklmnopqrstuvwxyz";
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
//            String str = "";
//            for (int j = 0; j < strs[i].length(); j++) {
//                set.add(strs[i].charAt(j));
//            }

            Queue<Character> queue = new LinkedList<>();
            for (int j=0;j<alphbat.length();j++){
                for (int k=0;k<strs[i].length();k++){
                    if (strs[i].charAt(k)==alphbat.charAt(j)){
                        queue.add(strs[i].charAt(k));
                    }
                }
            }


            if (map.containsKey(queue)) {
                List list = map.get(queue);
                list.add(strs[i]);
                map.replace(queue, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(queue, list);
            }


        }
        // System.out.println(map);
        for (List list:map.values()){
            res.add(list);
        }
        return res;
    }
}


