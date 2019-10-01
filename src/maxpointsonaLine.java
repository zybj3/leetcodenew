import java.util.*;
/*
 求最大公约数，不然精度不够，难顶
 */
public class maxpointsonaLine {
    public int maxPoints(int[][] points) {
        if (points==null){
            return 0;
        }
        if (points.length<=2){
            return points.length;
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int res = 1;
        for (int i=0; i<points.length; i++){
            map.clear();
            int overlap = 0, max = 0;
            for (int j=i+1; j<points.length; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x==0 && y==0){
                    overlap++;
                    continue;
                }

                int gcd = gcd(x, y);

                x /= gcd;
                y /= gcd;

                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)){
                        map.get(x).put(y, map.get(x).get(y) + 1 );
                    }else {
                        map.get(x).put(y, 1);
                    }
                }else{
                    map.put(x, new HashMap());
                    map.get(x).put(y, 1);
                }
                max = Math.max(max, map.get(x).get(y));
            }

            res = Math.max(res, max + overlap + 1);

        }

        return res;

    }

    int gcd(int a, int b){
        if (b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}
