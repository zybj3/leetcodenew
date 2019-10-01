import java.util.*;

public class carfleet {
    public int carFleet(int target, int[] position, int[] speed) {
      TreeMap<Integer,Double> treeMap = new TreeMap<>();
      for (int i=0; i<position.length; i++){
          treeMap.put(-position[i],(double)(target-position[i])/speed[i]);
      }

      int res = 0;
      double cur = 0;
      for (double time:treeMap.values()){
          if (time>cur){
              res++;
              cur = time;
          }
      }

      return res;



    }
}
