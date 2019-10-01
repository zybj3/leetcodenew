import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class numberoflongestincreasingsubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] cnt = new int[nums.length];
        int[] len = new int[nums.length];
        Arrays.fill(cnt,1);
        Arrays.fill(len,1);
        int res = 0,maxlen = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    if (len[i]<len[j]+1){
                        len[i] = len[j]+1;
                        cnt[i] = cnt[j];
                    }
                    else if (len[i]==len[j]+1){
                        cnt[i] += cnt[j];
                    }
                }
            }
        }

        for (int i=0;i<len.length;i++){
            if (maxlen<len[i]){
                maxlen = len[i];
            }
        }

        for (int i=0;i<len.length;i++){
            if (maxlen == len[i]){
                res += cnt[i];
            }
        }




        return res;
    }
}
