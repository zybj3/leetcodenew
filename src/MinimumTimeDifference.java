import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int hour1 = Integer.parseInt(o1.substring(0,2));
                int hour2 = Integer.parseInt(o2.substring(0,2));
                int minute1 = Integer.parseInt(o1.substring(3));
                int minute2 = Integer.parseInt(o2.substring(3));

                if (hour1==hour2){
                    return minute1-minute2;
                }else return hour1-hour2;
            }
        });

        int min_dif = Integer.MAX_VALUE;
        for (int i=0;i<timePoints.size()-1; i++){
            int dif = getDif(timePoints.get(i), timePoints.get(i+1));
            min_dif = Math.min(dif, min_dif);
        }


        String earliestTime = timePoints.get(0);
        String latestTime = timePoints.get(timePoints.size()-1);

        int dif1 = getDif(latestTime, "24:00");
        int dif2 = getDif("00:00", earliestTime);

        min_dif = Math.min(dif1+dif2, min_dif);
        return min_dif;


    }


    public int getDif(String early, String late){
        int hour1 = Integer.parseInt(early.substring(0,2));
        int hour2 = Integer.parseInt(late.substring(0,2));
        // System.out.println(hour1);
        // System.out.println(hour2);
        int minute1 = Integer.parseInt(early.substring(3));
        int minute2 = Integer.parseInt(late.substring(3));

        //  System.out.println(minute1);
        // System.out.println(minute2);
        if (hour1==hour2){
            return minute2-minute1;
        }
        else return (hour2-hour1-1)*60 + 60-minute1+minute2;
    }
}
