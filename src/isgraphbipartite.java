import java.util.LinkedList;
import java.util.Queue;

public class isgraphbipartite {
    public boolean isBipartite(int[][] graph) {
        if (graph==null || graph.length==0){
            return false;
        }
        int[] color = new int[graph.length];

        for (int i=0;i<graph.length;i++){
            Queue<Integer> queue = new LinkedList<>();
            if (color[i]==0){
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()){
                    int node = queue.poll();
                    for (int next:graph[node]){
                        if (color[next]==color[node]){
                            return false;
                        }
                        if (color[next]==0){
                            color[next] = -color[node];
                            queue.offer(next);
                        }
                    }
                }
            }

        }

        return true;
    }
}
