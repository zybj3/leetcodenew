public class stringwithoutaaaorbbb {
    public String strWithout3a3b(int A, int B) {
        String res = "";
        while (A>0 && B>0){
            if (A>B){
                res += "aa";
                res += "b";
                A-=2;
                B-=1;
            }
            else if (B>A){
                res+="bb";
                res+="a";
                B-=2;
                A-=1;
            }
            else {
                res+="b";
                res+="a";
                A--;
                B--;
            }
        }

        while (A>0){
            res+="a";
            A--;
        }
        while (B>0){
            res+="b";
            B--;
        }
        return res;
    }
}
