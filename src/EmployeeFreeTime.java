import java.util.*;

class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start,int _end) {
        start = _start;
        end = _end;
    }
};

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> interval = schedule.get(0);

        for (int i=1; i<schedule.size(); i++){
            List<Interval> list_to_merge = schedule.get(i);
            for (int j=0; j<list_to_merge.size(); j++){
                Interval interval_to_merge = list_to_merge.get(j);
                List<Interval> inserted_list = Insert(interval, interval_to_merge);
                interval = inserted_list;
            }
        }

        // for (int i=0; i<interval.size(); i++){
        //     System.out.print(interval.get(i).start + " " + interval.get(i).end + " ");
        // }

        System.out.println();
        List<Interval> res = new ArrayList<>();
        for (int i=0; i<interval.size()-1; i++){
            res.add(new Interval(interval.get(i).end, interval.get(i+1).start));
        }

        return res;
    }

    public List<Interval> Insert(List<Interval> intervalList, Interval interval){
        int start = interval.start;
        int end = interval.end;

        List<Interval> left = new ArrayList<>();
        List<Interval> right = new ArrayList<>();


        for (Interval interval1: intervalList){
            if (interval1.end<start){
                left.add(interval1);
            }else if (interval1.start>end){
                right.add(interval1);
            }
            else {
                start = Math.min(interval1.start, start);
                end = Math.max(interval1.end, end);
            }
        }

        List<Interval> result = new ArrayList<>();
        result.addAll(left);
        result.add(new Interval(start, end));
        result.addAll(right);


        return result;
    }
}
