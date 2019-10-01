import java.util.Arrays;
import java.util.Comparator;

public class twocityscheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        for (int i=0;i<costs.length;i++){
            System.out.print(costs[i][0]+ " " + costs[i][1]);
        }
        int res = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            res += costs[i][0];
        }
        for (int i = costs.length / 2; i < costs.length;i++) {
            res += costs[i][1];
        }
        return res;

    }
}
