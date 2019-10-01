public class removeduplicatesfromsortedarray {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        int index = 0;
        while (slow<nums.length || fast<nums.length){
            while (fast<nums.length && nums[slow]==nums[fast]){
                fast++;
            }

            if (fast-slow>=2){
                //System.out.println(slow + " " + fast);
                nums[index] = nums[slow];
                nums[index+1] = nums[slow];
                index+=2;
                slow = fast;
                fast++;
            }else {
                // System.out.println(slow + " " + fast);
                nums[index] = nums[slow];
                slow+=1;
                index+=1;
            }


        }

        return index;
    }
}
