import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class minimumgeneticmutation {
    public int minMutation(String start, String end, String[] bank) {
        int level = 1;
        HashSet<String> visited = new HashSet<>();
        Queue<String> path = new LinkedList<>();
        path.add(start);
        visited.add(start);
        while (!path.isEmpty()){
            int size = path.size();
            while (size>0){
                String str = path.poll();
                for (String string: bank){
                    if (visited.contains(string)){
                        continue;
                    }
                    if (canmutate(str,string)){

                        if (string.equals(end)){
                            return level;
                        }
                        path.add(string);
                        visited.add(string);
                    }
                }

                System.out.println(path);

                size--;
            }



            level++;

        }

        return -1;
    }

    public boolean canmutate(String cur, String bankstr){
        int difference = 0;
        for (int i=0;i<cur.length();i++){
            if (cur.charAt(i)!=bankstr.charAt(i)){
                difference++;
            }
        }
        return difference==1;
    }
}
