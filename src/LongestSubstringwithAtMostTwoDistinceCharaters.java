import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinceCharaters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
            }

            while (map.size() > 2) {
                char left = s.charAt(slow);
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                slow++;
            }

            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}
