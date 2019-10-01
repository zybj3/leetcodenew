import java.util.PriorityQueue;

public class longestsubstringwithatleastKrepeatingcharacters {
    public int longestSubstring(String s, int k) {
        return dc(0,s.length(),s,k);
    }

    public int dc(int left, int right, String s, int k){
        if (right-left<k){
            return 0;
        }

        int[] count = new int[26];
        for (int i=left;i<right;i++){
            count[s.charAt(i)-'a'] += 1;
        }

        for (int i=left;i<right;i++){
            if (count[s.charAt(i)-'a']>0 && count[s.charAt(i)-'a']<k ){
                return Math.max(dc(left,i,s,k),dc(i+1,right,s,k));
            }
        }

        return right-left;
    }
}
