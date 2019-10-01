import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MutiplyString {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] res = new int[m+n];

        for (int i=n-1;i>=0;i--) {
            for (int j = m - 1; j >= 0; j--) {
                int addnum = 0;
                int mul1 = Character.getNumericValue(num2.charAt(i));
                int mul2 = Character.getNumericValue(num1.charAt(j));
                int mul = mul1 * mul2;

                res[i + j + 1] = res[i + j + 1] + mul % 10;
                if (res[i+j+1]>=10){
                    addnum = res[i+j+1]/10;
                }
                res[i+j+1] %= 10;
                res[i + j] = res[i + j] + mul / 10 + addnum;
                if (res[i+j]>=10){
                    res[i+j-1] += res[i+j]/10;
                }
                res[i+j] %= 10;
            }

        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<res.length){
            if (res[index]!=0){
                break;
            }
            index++;
        }

        if(index == res.length){
            sb.append(0);
        }else
            for (int i=index;i<res.length;i++){
                sb.append(res[i]);
            }

        return sb.toString();
    }
}
