public class partitiontoKequalsumsubsets {
    int k;
    int target;
    boolean res = false;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        int sum = 0;
        for (int num:nums){
            sum += num;
        }

        if (sum%k!=0){
            return false;
        }

        this.target = sum/k;
        boolean[] visited = new boolean[nums.length];

        return dfs(target,0,k,visited,nums);
    }

    public boolean dfs(int target, int start,int time, boolean[] visited, int[] nums){
        if(target<0){
            return false;
        }
        if (time==1){
            return true;
        }

        if (target==0){
            target = this.target;
            // System.out.println(target + " " + time);
            return dfs(target,0,time-1,visited,nums);
        }

        for (int i=start; i<nums.length;i++){
            if (!visited[i]){
                visited[i] = true;
                if(dfs(target-nums[i],start+1, time, visited,nums)){

                    return true;
                }
                visited[i] = false;
            }

        }

        return false;
    }
}
