import java.util.Arrays;

public class candy {
    public int candy(int[] ratings) {
        int[] arrange = new int[ratings.length];
        Arrays.fill(arrange,1);
        for (int i=1;i<arrange.length;i++){
            if (ratings[i]>ratings[i-1]){
                arrange[i] = arrange[i-1] + 1 ;
            }
        }

        for (int i=arrange.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1] && arrange[i]<=arrange[i+1]){
                arrange[i] =arrange[i+1]+1;
            }
        }

        int sum = 0;
        for (int i:arrange){
            sum+=i;
        }

        return sum;


    }
}
