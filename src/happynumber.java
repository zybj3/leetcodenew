import java.util.HashSet;

public class happynumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)){
            int res = 0;
            while (n>0){
                int balance = n%10;
                n/=10;
                res += Math.pow(balance,2);
            }
            if (res==1){
                return true;
            }
            n = res;
        }

        return false;
    }
}
