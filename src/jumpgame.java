public class jumpgame {
    public boolean canJump(int[] nums) {
        int maxreach = 0;
        for (int i=0;i<nums.length&&i<=maxreach;i++){
            maxreach = Math.max(maxreach,nums[i]+i);
            if (maxreach>=nums.length-1){
                return true;
            }
        }

        return false;
    }
}
