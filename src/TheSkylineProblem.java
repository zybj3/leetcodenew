import java.util.*;

public class TheSkylineProblem {
    class Event{
        int type;
        int time;
        int height;
        public Event(int type, int time, int height){
            this.type = type;
            this.time = time;
            this.height = height;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Event> events = new ArrayList<>();
        for (int i=0; i<buildings.length; i++){
            events.add(new Event(0, buildings[i][0], buildings[i][2]));
            events.add(new Event(1, buildings[i][1], buildings[i][2]));
        }

        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.time==o2.time){
                    if (o1.type==0 && o2.type==0){
                        return o1.height==o2.height? -1 : o2.height - o1.height;
                    }else if (o1.type==1 && o2.type==1) {
                        return o1.height==o2.height? 1 : o1.height - o2.height;
                    }else if (o1.type==0 && o2.type==1){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return o1.time - o2.time;
            }
        });

        PriorityQueue<Integer> maxHeight = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        maxHeight.offer(0);

        List<List<Integer>> res = new ArrayList<>();
        for (Event event: events){
            if (event.type==0){
                if (event.height>maxHeight.peek()){
                    res.add(Arrays.asList(event.time, event.height));
                }
                maxHeight.offer(event.height);
            }
            else{
                maxHeight.remove(event.height);
                if (event.height>maxHeight.peek()){
                    res.add(Arrays.asList(event.time, maxHeight.peek()));
                }
            }
        }

        return res;
    }
}
