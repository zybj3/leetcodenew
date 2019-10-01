public class IntegerReplacement {
    /*
    书上说的对 位运算还是猛得一
     */
    public int integerReplacement(int n) {
        int step = 0;
        if (n==1){
            return 0;
        }
        while (n!=1){
            if ((n & 1) == 0){
                n >>>= 1;
            }else{
                if(n==3){
                    step+=2;
                    break;
                }
                int temp = n>>1;
                if (temp%2==0){
                    n-=1;
                }else {
                    n+=1;
                }
            }
            step++;
        }
        return step;
    }

}
