public class countnumberswithuniquedigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0){
            return 1;
        }

        if (n==1){
            return 10;
        }

        if (n==2){
            return 91;
        }

        int res = 91;
        int start = 8;
        int startcount = 81;
        int m = 3;
        while (m<=n && start>0){
            startcount*=(start--);
            res += startcount ;

            m++;
        }

        return res;
    }
}
