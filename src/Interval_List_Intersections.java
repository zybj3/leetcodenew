import java.util.ArrayList;
import java.util.List;

public class Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][0] > B[j][1]) {
                j++;
            } else if (B[j][0] > A[i][1]) {
                i++;
            } else {
                int head = Math.max(A[i][0], B[j][0]);
                int tail = Math.min(A[i][1], B[j][1]);
                list.add(new int[]{head, tail});
                if (A[i][1]>B[j][1]){
                    j++;
                }else {
                    i++;
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
