public class bitwiseandofnumberrange {
    public int rangeBitwiseAnd(int m, int n) {
        int factor = 1;
        while (m!=n){
            m >>= 1;
            n >>= 1;
            factor *= 2;
        }

        return m*factor;
    }
}
