import java.util.Arrays;

public class taskscheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char chr:tasks){
            count[chr-'A']++;
        }
        int maxcount = 0;
        Arrays.sort(count);
        for (int i=0;i<count.length-1;i++){
            if (count[i]>count[i+1]){
                maxcount = i+1;
            }
        }

        int intervel = n+1;
        return Math.max(intervel*(maxcount-1)+maxcount,tasks.length);
    }
}
