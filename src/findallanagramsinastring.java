import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findallanagramsinastring {
    /*
    爱是一扇窗
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[26];
        for (int i=0;i<p.length();i++){
            count[p.charAt(i)-'a']++;
        }

        int[] window = new int[26];
        for (int i=0;i<s.length(); i++){
            window[s.charAt(i)-'a']++;
            if (i==p.length()-1){
                if (Arrays.equals(window,count)){
                    list.add(i-p.length()+1);
                }

            }
            else if (i>=p.length()){
                window[s.charAt(i-p.length())-'a']--;
                if (Arrays.equals(window,count)){
                    list.add(i-p.length()+1);
                }
            }
        }

        return list;
    }
}
