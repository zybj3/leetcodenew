import java.util.Arrays;
import java.util.WeakHashMap;

public class uglynumber3 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        long lcm1 = lcm(a, b);
        long lcm2 = lcm(a, c);
        long lcm3 = lcm(b, c);
        long lcm4 = lcm(lcm1, c);
        System.out.println(lcm4);
        while (left<right){
            int mid = left + (right-left)/2;
            long count = mid/a + mid/b + mid/c - mid/lcm1 - mid/lcm2 - mid/lcm3 + mid/lcm4;

            if (count>=n){
                right = mid;
            }else if (count<n){
                left = mid + 1;
            }
        }
        return right;
    }

    public long gcd(long a, long b){
        if (b==0){
            return a;
        }

        return gcd(b, a%b);
    }

    public long lcm(long a, long b){
        long gcd = gcd(a, b);

        return a*b/gcd;
    }




}
