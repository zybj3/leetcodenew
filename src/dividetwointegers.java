public class dividetwointegers {
    public int divide(int dividend, int divisor) {
        if (dividend==1<<31 && divisor==-1){
            return (1<<31)-1;
        }
        int flag = 0;
        if (dividend<0){
            flag++;
        }
        if (divisor<0){
            flag++;
        }

        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        int res = 0;

        if (m<n){
            return res;
        }

        System.out.println(m);

        while (m>=n){
            long temp = n;
            int count = 1;
            while (m>(temp<<1)){
                temp <<= 1;
                count *= 2;
            }

            res += count;
            m-=temp;
        }

        return flag==1?-res : res;
    }
}
