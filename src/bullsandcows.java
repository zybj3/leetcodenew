import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bullsandcows {
    public String getHint(String secret, String guess) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] count = new int[10];
        for (int i=0;i<secret.length();i++){
            int num = Integer.parseInt(secret.substring(i,i+1));
            if (map.containsKey(num)){
                List list = map.get(num);
                list.add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num,list);
            }
            count[num]++;
        }

        int A = 0;
        int B = 0;
        int[] count2 = new int[10];
        for (int i=0;i<guess.length();i++){
            int num = Integer.parseInt(guess.substring(i,i+1));
            count2[num]++;
            if (map.containsKey(num)){
                if (map.get(num).contains(i)){
                    A++;
                    count[num]--;
                    count2[num]--;
                }
            }

        }

        for (int i=0;i<count.length;i++){
            if (count2[i]>0) {
                if (count[i] >= count2[i]) {
                    B += count2[i];
                } else {
                    B += count[i];
                }
            }
        }
        String str = "";
        str += A;
        str += "A";
        str += B;
        str += "B";

        return str;
    }
}
