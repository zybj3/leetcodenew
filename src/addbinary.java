import java.util.Arrays;

public class addbinary {
    public String addBinary(String a, String b) {
        int[] res = new int[Math.max(a.length(),b.length())+1];
        int taila = a.length()-1;
        int tailb = b.length()-1;
        int tail = res.length-1;
        while (tail>=0){
            int adda,addb;
            adda=(taila<0) ? 0:Character.getNumericValue(a.charAt(taila--));
            addb=(tailb<0) ? 0:Character.getNumericValue(b.charAt(tailb--));
            res[tail] += adda + addb;
            if (res[tail]>1){
                res[tail-1] += 1;
                res[tail] %=2;
            }
            tail--;
        }
        StringBuilder sb = new StringBuilder();
        if(res[0]!=0){
            sb.append(res[0]);
        }
        for (int i=1;i<res.length;i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
