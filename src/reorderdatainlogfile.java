import java.util.Arrays;
import java.util.Comparator;

public class reorderdatainlogfile {
    /*
    Comparator 用法：return的数值小于0代表小，0代表相等，1代表大于
     */
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] strings1 = o1.split(" ", 2);
                String[] strings2 = o2.split(" ", 2);

                if (Character.isLetter(strings1[1].charAt(0)) && Character.isLetter(strings2[1].charAt(0))){
                    int compare = strings1[1].compareTo(strings2[1]);
                    if (compare==0){
                        return strings1[0].compareTo(strings2[0]);
                    }else {
                        return compare;
                    }
                }else if (Character.isLetter(strings1[1].charAt(0)) && Character.isDigit(strings2[1].charAt(0))){
                    return -1;
                }else if (Character.isDigit(strings1[1].charAt(0)) && Character.isLetter(strings2[1].charAt(0))){
                    return 1;
                }else
                    return 0;
            }
        });

        return logs;
    }
}
