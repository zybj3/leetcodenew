import java.util.*;

public class accountsmerge {
    private int[] parents;
    private int[] rank;
    int find(int num){
        //System.out.println(num);
        if (parents[num]!=num){
            parents[num] = find(parents[num]);
        }

        return parents[num];
    }

    boolean merge(int num1, int num2, int[] rank){
        if (find(num1)==find(num2)){
            return false;
        }

        parents[find(num1)] = find(num2);

        return true;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new int[accounts.size()];
        for (int i=0;i<parents.length;i++){
            parents[i] = i;
        }

        rank = new int[accounts.size()];
        HashMap<String,Integer> map = new HashMap<>();

        for (int i=0;i<accounts.size();i++){
            List<String> emails = accounts.get(i);
            for (int j=1;j<emails.size();j++){
                String email = emails.get(j);
                if (map.containsKey(email)){

                    merge(map.get(email),i,rank);

                    map.put(email,find(i));
                }else {
                    map.put(email,find(i));
                }
            }

            System.out.println(Arrays.toString(parents));



        }

        System.out.println(map);




        Map<Integer, Set<String>> mapping = new HashMap<>();
        for (int i=0;i<parents.length;i++){
            // System.out.println(i);
            int parent = find(i);
            if (!mapping.containsKey(parent)){
                mapping.put(parent,new HashSet<>());
            }

            Set<String> emails = mapping.get(parent);
            for (int j=1;j<accounts.get(i).size();j++){
                emails.add(accounts.get(i).get(j));

            }

        }

        List<List<String>> res = new ArrayList<>();
        for (int id:mapping.keySet()){
            Set<String> set = mapping.get(id);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(id).get(0));
            list.addAll(set);
            Collections.sort(list);
            res.add(list);
        }
        // System.out.println(res);
        return res;


    }
}
