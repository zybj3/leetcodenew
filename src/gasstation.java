public class gasstation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] gastogo = new int[gas.length];
        for (int i=0;i<gastogo.length;i++){
            gastogo[i] = gas[i]-cost[i];
        }

        for (int i=0;i<gastogo.length;i++){
            if (gastogo[i]>=0){
                int flag = 0;
                int gasline = 0;
                for (int j=i;j<gastogo.length;j++){
                    gasline += gastogo[j];
                    if (gasline<0){
                        flag = 1;
                        break;
                    }
                }

                for (int j=0;j<i;j++){
                    gasline += gastogo[j];
                    if (gasline<0){
                        flag = 1;
                        break;
                    }
                }

                if (flag==0){
                    return i;
                }

            }
        }
        return -1;
    }
}
