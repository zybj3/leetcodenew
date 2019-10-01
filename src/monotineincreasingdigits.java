public class monotineincreasingdigits {
    public int monotoneIncreasingDigits(int N) {
        char [] x = String.valueOf(N).toCharArray();
        int mark = x.length;
        for (int i=x.length-1;i>0;i--){
            if (x[i]<x[i-1]){
                mark = i;
                x[i-1] -= 1;
            }
        }

        for (int i=mark;i<x.length;i++){
            x[i] = '9';
        }
        return Integer.parseInt(String.valueOf(x));
    }
}
