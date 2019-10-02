public class ConsecutiveNumbersSum {
    /*
     题目意思，存在多少个公差为1的等差数列并且每个等差数列和为N
     设首项为x，项数为m 那么可以知道 (x + x + m - 1)*m/2 = N
     化简后可得 mx + m(m-1)/2 = N
     所以 x = (N - m(m-1)/2)/m
     如果存在x 那么(N - m(m-1)/2)/m 一定是个正整数 (N - m(m-1)/2)%m==0
     循环终止条件是mx<=0 因为要求的是正整数数列
     */
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int m = 1; ;m++){
            int mx = N-m*(m-1)/2;
            if (mx<=0){
                break;
            }
            if(mx%m==0){
                ans++;
            }
        }
        return ans;
    }
}
