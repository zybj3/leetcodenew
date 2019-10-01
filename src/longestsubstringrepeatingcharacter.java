import java.util.HashSet;

public class longestsubstringrepeatingcharacter {
    public int lengthOfLongestSubstring(String s) {
        int a = 0 , b = 0;
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        int max = 0;
        while (a<s.length() && b<s.length()){
            if (set.add(s.charAt(b))){
                length = b-a+1;
                b++;
            }
            else{
                set.remove(s.charAt(a));
                a++;
            }
            max = Math.max(max,length);
        }

        return max;
    }

}
