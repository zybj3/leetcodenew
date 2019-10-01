public class DesignHitCounter {
    class HitCounter {
        int[] hit;
        int[] timeStamp;
        /** Initialize your data structure here. */
        public HitCounter() {
            hit = new int[300];
            timeStamp = new int[300];
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            int idx = timestamp%300;
            if (timeStamp[idx]==timestamp){
                hit[idx]++;
            }else {
                timeStamp[idx] = timestamp;
                hit[idx] = 1;
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            int res = 0;
            for (int i=0; i<300; i++){
                if (timestamp - timeStamp[i]<300){
                    res += hit[i];
                }
            }

            return res;
        }
    }
}
