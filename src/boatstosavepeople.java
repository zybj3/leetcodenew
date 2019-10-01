import java.util.Arrays;
import java.util.Collections;

public class boatstosavepeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int amount = 0;
        int start = 0;
        int end = people.length-1;

        while (start<=end){
            if (people[start]+people[end]<=limit){
                start++;
                end--;
            }
            else
                end--;

            amount++;


        }
        return amount;
    }
}
