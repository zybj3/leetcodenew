import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        int flag = 0;
        if (numerator<0){
            flag++;
        }
        if (denominator<0){
            flag++;
        }

        StringBuilder sb = new StringBuilder();
        if (flag==1){
            sb.append("-");
        }
        long top = Math.abs((long)numerator);
        long down = Math.abs((long)denominator);

        sb.append(top/down);
        if (top%down==0){
            return sb.toString();
        }
        top%=down;
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(top, sb.length());
        while (top!=0) {
            top *= 10;
            long quo = top/down;
            top = top%down;
            sb.append(quo);
            if (map.containsKey(top)){
                sb.insert(map.get(top),"(");
                sb.append(")");
                break;
            }
            map.put(top, sb.length());
        }

        return sb.toString();
    }
}
