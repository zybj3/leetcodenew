public class minumuminccrementtomakearrayunique {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[40000];
        for (int num:A){
            count[num]++;
        }
        int move = 0;
        for (int i=0;i<count.length-1;i++){
            if (count[i]>1){
                count[i+1]+=count[i]-1;
                move += count[i]-1;
            }
        }

        if (count[count.length-1]>1){
            move += count[count.length-1]*(count[count.length-1]-1)/2;
        }
        System.out.println(count[39999]);
        return move;
    }
}
