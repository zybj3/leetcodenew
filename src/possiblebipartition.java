import java.util.*;

public class possiblebipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) {
            return true;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] relation:dislikes){
            if (map.getOrDefault(relation[0],null)==null){
                List<Integer> list = new ArrayList<>();
                list.add(relation[1]);
                map.put(relation[0],list);
            }else {
                List<Integer> list = map.get(relation[0]);
                list.add(relation[1]);
                map.put(relation[0],list);
            }
            if (map.getOrDefault(relation[1],null)==null){
                List<Integer> list = new ArrayList<>();
                list.add(relation[0]);
                map.put(relation[1],list);
            }else {
                List<Integer> list = map.get(relation[1]);
                list.add(relation[0]);
                map.put(relation[1],list);
            }

        }

        int[] color = new int[N+1];

        for (int i=1;i<=N;i++){
            if (color[i]==0 && !dfs(i,1,color,map)){
                return false;
            }
        }


        return true;
    }

    private boolean dfs(int curnum, int curcolor, int[] color,HashMap<Integer,List<Integer>> map){
        if (color[curnum]!=0){
            return color[curnum]==curcolor;
        }

        color[curnum] = curcolor;

        List<Integer> nextList = map.get(curnum);
        if (nextList==null){
            return true;
        }
        for (int neighbor: nextList){
            boolean subres = dfs(neighbor,-1*curcolor,color,map);
            if (!subres){
                return false;
            }
        }

        return true;
    }
}
