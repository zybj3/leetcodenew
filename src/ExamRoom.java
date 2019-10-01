import java.util.PriorityQueue;

public class ExamRoom {
    private int getdist(int [] interval){
        int dist = 0;
        if (interval[0] == -1){
            dist = interval[1];
        }else if (interval[1] == N){
            dist = N - 1 - interval[0];
        }
        else {
            dist = (interval[1]-interval[0])/2;
        }

        return dist;
    }

    PriorityQueue<int[]> pq;
    int N;
    public ExamRoom(int N){
        this.N = N;
        pq = new PriorityQueue<int[]>((a,b)->{
            int dista = getdist(a);
            int distb = getdist(b);
            if (dista==distb){
                return a[0]-b[0];
            }
            else {
                return distb-dista;
            }
        });
        pq.add(new int[]{-1,N});
    }

    public int seat() {
        int result = 0;
        int[] interval = pq.poll();
        if (interval[0]==-1){
            result = 0;
        }else if (interval[1]==N){
            result = N -1;
        }else {
            result = interval[0] + (interval[1] - interval[0])/2;
        }

        pq.add(new int[]{interval[0],result});
        pq.add(new int[]{result,interval[1]});

        return result;
    }

    public void leave(int p) {
        int[] left  = null;
        int[] right = null;
        for (int[] interval:pq){
            if (interval[1]==p){
                left = interval;
            }
            if (interval[0]==p){
                right = interval;
            }
        }

        pq.remove(left);
        pq.remove(right);
        pq.add(new int[]{left[0],right[1]});
    }
}
