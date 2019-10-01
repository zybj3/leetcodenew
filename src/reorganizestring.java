import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class reorganizestring {

    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int[] count = new int[26];
        for (int i=0;i<S.length();i++) {
            count[S.charAt(i)-'a'] ++;
        }

        for (int i=0;i<count.length;i++){
            if (count[i]!=0){
                pq.add(new int[]{count[i],i});
            }
        }


        List<String> list = new ArrayList<>();
        int num = pq.peek()[0];
        if (num==1){
            return S;
        }

        char chr = (char)(pq.peek()[1]+97);
        pq.poll();
        for (int i=0;i<num;i++){
            String str = "";
            str+=chr;
            list.add(str);
        }
        int index = 0;
        while (!pq.isEmpty()){
            int amount = pq.peek()[0];

            char character = (char)(pq.peek()[1]+97);
            if(index >= list.size()){
                index = 0;
            }
            if (index+amount<=list.size()-1) {
                int i = index;
                for (i = index; i < index + amount; i++) {
                    String str = list.get(i);
                    str += character;
                    list.set(i, str);
                }
                index = i;
            }
            else {
                int iter = 0;
                int i = index;
                for (i = index;i<list.size();i++){
                    String str = list.get(i);
                    str += character;
                    list.set(i, str);
                    iter ++;

                }

                for (i = 0;i<amount-iter;i++){

                    String str = list.get(i);
                    str += character;
                    list.set(i, str);
                }
                index = i;
            }
            pq.poll();
        }

        String res = "";
        for (String str:list){
            res += str;
        }

        for (int i=0;i<res.length()-1;i++){
            if (res.charAt(i)==res.charAt(i+1)){
                return "";
            }
        }

        return res;

    }
}
