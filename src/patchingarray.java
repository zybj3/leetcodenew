public class patchingarray {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long miss = 1;
        int index = 0;
        while (miss<=n){
            if (index<nums.length && miss>=nums[index]){
                miss += nums[index];
                index++;
            }
            else {
                miss*=2;
                patch++;
            }
            System.out.println(miss);
        }

        return patch;
    }
}
