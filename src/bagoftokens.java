import java.util.Arrays;

public class bagoftokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1, balance = 0;
        while (left<=right){
            if(P >= tokens[left] ){
                P-=tokens[left];
                balance++;
                left++;
            }
            else if (balance>0 && left!=right){
                balance--;
                P+=tokens[right];
                right--;
            }
            else break;

        }
        return balance;
    }
}
