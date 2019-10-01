import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Integer, Integer> degree = new HashMap<>();

        for (int i=0; i<words.length; i++){
            for (int j=0; j<words[i].length(); j++){
                degree.put(words[i].charAt(j)-'a', 0);
            }
        }

        for (int i=0; i<words.length-1; i++){
            String cur = words[i];
            String next = words[i+1];
            int len = Math.min(cur.length(), next.length());
            for (int j=0; j<len; j++){
                if (cur.charAt(j)!=next.charAt(j)){
                    if (!map.containsKey(cur)){
                        map.put(cur.charAt(j), new HashSet<>());
                    }

                    if (map.get(cur.charAt(j)).add(next.charAt(j))){
                        degree.put(next.charAt(j)-'a', degree.getOrDefault(next.charAt(j)-'a',0) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int num:degree.keySet()){
            if (degree.get(num)==0){
                queue.offer((char)('a' + num));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            char cur = queue.poll();
            sb.append(cur);
            HashSet<Character> next = map.get(cur);
            for (char chr: next){
                int newdegree = degree.get(chr-'a') - 1;
                if (newdegree==0){
                    degree.put(chr-'a', newdegree);
                    queue.offer(chr);
                }else {
                    degree.put(chr-'a', newdegree);
                }
            }
        }

        if (sb.length()!=degree.size()){
            return "";
        }
        return sb.toString();
    }
}
