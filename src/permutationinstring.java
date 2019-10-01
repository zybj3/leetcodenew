import java.util.Arrays;

public class permutationinstring {
    public boolean checkInclusion(String s1, String s2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        if (s1.length()>s2.length()){
            return false;
        }
        for (int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(c1,c2)){
            return true;
        }

        for (int i=s1.length();i<s2.length();i++){
            c2[s2.charAt(i)-'a']++;
            c2[s2.charAt(i-s1.length())-'a']--;
            if (Arrays.equals(c1,c2)){
                return true;
            }
        }

        return false;
    }
}
