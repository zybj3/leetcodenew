import java.util.Stack;

public class decodedstringatindex {
    public String decodeAtIndex(String S, int K) {

        long totallen = 0;
        for (int i=0;i<S.length();i++){
            if (Character.isDigit(S.charAt(i))){
                totallen *= Character.getNumericValue(S.charAt(i));
            }
            else {
                totallen += 1;
            }
        }

        for (int i=S.length()-1;i>=0;i--){
            if (Character.isDigit(S.charAt(i))){
                totallen /= Character.getNumericValue(S.charAt(i));
                K %= totallen;
            }
            else {
                if (K==totallen || K==0){
                    return String.valueOf(S.charAt(i));
                }
                totallen--;
            }
        }

        throw null;
    }
}
