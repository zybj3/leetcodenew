import java.util.*;

public class makearraystrictlyincreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr2.length; i++){
            if (i>0&&arr2[i]==arr2[i-1]){
                continue;
            }
            list.add(arr2[i]);
        }

        arr2 = new int[list.size()];
        for (int i=0;i<list.size();i++){
            arr2[i] = list.get(i);
        }
        int[][] swap = new int[arr1.length][arr2.length];
        int[] keep = new int[arr1.length];
        int defval = 1000000009;
        keep[0] = 0;
        Arrays.fill(swap[0], 1);
        for (int i=1; i<arr1.length; i++){
            keep[i] = defval;
            int minkeep = defval;
            int minswap = defval;
            for (int j=0; j<arr2.length; j++){
                swap[i][j] = defval;
                if (arr1[i]>arr1[i-1]){
                    keep[i] = keep[i-1];
                }
                if (arr2[j]>arr1[i-1]){
                    swap[i][j] = keep[i-1] + 1;
                }

                if (arr1[i]>arr2[j]){
                    minkeep = Math.min(minkeep, swap[i-1][j]);
                }

                if (j>0){
                    minswap = Math.min(minswap, swap[i-1][j-1] + 1);
                }

                keep[i] = Math.min(keep[i], minkeep);
                swap[i][j] = Math.min(swap[i][j], minswap);
            }
        }
        int ans = Math.min(keep[arr1.length-1], swap[arr1.length-1][arr2.length-1]);
        return ans>=defval? -1: ans;
    }
}
