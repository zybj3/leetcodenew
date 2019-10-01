public class powxn {
    public double myPow(double x, int n) {
        if (n==0){
            return 1.0;
        }
        if (n==1){
            return x;
        }

        if (n==-1){
            return 1.0/x;
        }

        double res = myPow(x,n>>1);
        res *= res;
        if (Math.abs(n)%2==1){
            res *= x;
        }
        return res;
    }

//    public double absPow(double x, int abs){
//        double res = 0.0;
//        if (abs==0){
//            return x;
//        }
//        for (int i=0;i<abs;i++){
//            res*=x;
//            System.out.println(x);
//        }
//
//        return res;
//    }
}
