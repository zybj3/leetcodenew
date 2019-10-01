public class jumpgame2 {
    public int jump(int[] nums) {
        int index = 0;
        int curmax = 0;
        int nextmax = 0;
        int step = 0;
        while (index<=curmax){
            while (index<=curmax){
                nextmax = Math.max(nextmax,index+nums[index]);
                index++;
            }
            step++;
            curmax = nextmax;
            if (curmax>=nums.length-1){
                return step;
            }
        }

        return 0;
    }
}
