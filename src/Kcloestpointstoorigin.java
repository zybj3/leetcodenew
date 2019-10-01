import java.util.PriorityQueue;

public class Kcloestpointstoorigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)->{
            int disa = a[0]*a[0] + a[1]*a[1];
            int disb = b[0]*b[0] + b[1]*b[1];

            return disb-disa;
        });

        for (int i=0;i<points.length;i++){
            priorityQueue.add(points[i]);
            if (priorityQueue.size()>K){

                priorityQueue.poll();
            }
            // System.out.println(priorityQueue);
        }

        int[][] res = new int[K][2];
        int index = 0;
        while (!priorityQueue.isEmpty()){
            res[index] = priorityQueue.poll();
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
//        Math math = new Math();
//        math.max()
    }
}
