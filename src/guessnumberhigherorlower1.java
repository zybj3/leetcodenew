import java.util.Arrays;
import java.util.List;

public class guessnumberhigherorlower1 {
    private int guess(int num){
        return num;
    }
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left<=right){
            int mid = left + (right-left)/2;
            if (guess(mid) == 1){
                left = mid + 1;
            }
            else if (guess(mid) == -1){
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
//        if(List  instanceof Arrays){
//
//        }
        return 0;
    }
}
