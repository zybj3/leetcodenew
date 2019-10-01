public class findtheduplicatenumber {
    /*
    erfenchazhao
     */
    public int findDuplicate(int[] nums) {
       int left = 1;
       int right = nums.length - 1;

       while (left<=right){
           if (left==right){
               return right-1;
           }
           int mid = (right+left)/2;
           int count = count(nums, left, mid);
           int normalcount = mid - left + 1;
           if (normalcount>count){
               right = mid;
           }else {
               left = mid + 1;
           }
       }

       return 0;
    }

    public int count(int[] nums, int left, int right){
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]>=left && nums[i]<=right){
                count++;
            }
        }

        return count;
    }


}
