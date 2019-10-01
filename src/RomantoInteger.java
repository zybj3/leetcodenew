import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);  map.put("IV", 4);
        map.put("X", 10); map.put("IX", 9);
        map.put("L", 50);  map.put("XL", 40);
        map.put("C", 100); map.put("XC", 90);
        map.put("D", 500); map.put("CD", 400);
        map.put("M", 1000); map.put("CM", 900);

        int res = 0;
        for (int i=0; i<s.length(); ){
            if (i<s.length()-1){
                String two = s.substring(i, i+2);
                if (map.containsKey(two)){
                    res += map.get(two);
                    i += 2;
                    continue;
                }
            }

            String one = s.substring(i, i+1);
            if (map.containsKey(one)){
                res += map.get(one);
            }

            i += 1;
        }

        return res;
    }
}
