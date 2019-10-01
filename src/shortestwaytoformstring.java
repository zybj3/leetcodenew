public class shortestwaytoformstring {
    public int shortestWay(String source, String target) {

        int t=0;
        int step = 0;

        while (t<target.length()){
            int pt = t;
            for (int i=0; i<source.length(); i++){
                if (t<target.length() && source.charAt(i)==target.charAt(t)){
                    t++;
                }
            }

            if (t==pt){
                return -1;
            }

            step++;
        }

        return step;


    }
}
