import java.util.Arrays;
import java.util.Comparator;

public class largestnumber {
    public String largestNumber(int[] nums) {
        if (nums==null || nums.length==0){
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(strs,comparator);
        if (strs[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }

        return sb.toString();
    }
}
