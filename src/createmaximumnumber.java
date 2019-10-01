import java.util.Stack;

public class createmaximumnumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        if (nums1.length==0){
            return maxNumberofEach(nums2,k);
        }
        if (nums2.length==0){
            return maxNumberofEach(nums1,k);
        }

        for (int i=1;i<k;i++){
            if(i>nums1.length || k-i>nums2.length){
                continue;
            }
            int[] maxnum1 = maxNumberofEach(nums1,i);
            int[] maxnum2 = maxNumberofEach(nums2,k-i);

            int[] curmax = constructMax(maxnum1,maxnum2,k);


            if (ifLager(curmax, max, k)){
                max = curmax;
            }
        }
        return max;
    }

    public boolean ifLager(int[] curmax,int[] max,int k){

        for (int i=0;i<k;i++){
            if (curmax[i]>max[i]){
                return true;
            }
            else if(curmax[i]<max[i]){
                return false;
            }
        }

        return false;
    }

    public int[] constructMax(int[] maxnum1,int[] maxnum2,int k){
        int m = 0;
        int n = 0;
        int index = 0;
        int[] curmax = new int[k];
        while (m<maxnum1.length || n<maxnum2.length){
            if (m>=maxnum1.length){
                curmax[index] = maxnum2[n];
                index++;
                n++;
            }
            else if (n>=maxnum2.length){
                curmax[index] = maxnum1[m];
                index++;
                m++;
            }
            else if (maxnum1[m]>maxnum2[n]){
                curmax[index] = maxnum1[m];
                index++;
                m++;
            }
            else if (maxnum1[m]<maxnum2[n]){
                curmax[index] = maxnum2[n];
                index++;
                n++;
            }
            else {
                int m1 = m;
                int n1 = n;
                while (m1<maxnum1.length && n1<maxnum2.length && maxnum1[m1]==maxnum2[n1]){
                    m1++;
                    n1++;
                }
                if (m1<maxnum1.length && n1<maxnum2.length){
                    if (maxnum1[m1]>maxnum2[n1]){
                        curmax[index] = maxnum1[m];
                        m++;
                    }
                    else {
                        curmax[index] = maxnum2[n];
                        n++;
                    }
                }
                else if (m1==maxnum1.length){
                    curmax[index] = maxnum1[m];
                    m++;
                }
                else {
                    curmax[index] = maxnum2[n];
                    n++;
                }
            }

        }

        return curmax;
    }

    public int[] maxNumberofEach(int[] nums, int k){
        Stack<Integer> stack = new Stack<>();
        k = nums.length-k;

        for (int i=0;i<nums.length;i++){
            while (!stack.isEmpty()&&stack.peek()<nums[i]&&k>0){
                stack.pop();
                k--;
            }
            stack.push(nums[i]);

        }
        // System.out.println(k);
        while (k>0){
            stack.pop();
            k--;
        }
        System.out.println(stack);
        int[] maxnums = new int[stack.size()];
        for (int i=maxnums.length-1;i>=0;i--){
            maxnums[i] = stack.pop();
        }


        return maxnums;


    }
}
