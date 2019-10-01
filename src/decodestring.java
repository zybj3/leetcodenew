import java.util.Stack;

public class decodestring {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>();

        String res = "";
        int i = 0;
        while (i<s.length()){
            if (Character.isDigit(s.charAt(i))){
                int count = 0;
                while (Character.isDigit(s.charAt(i))){
                    count = 10 * count + (s.charAt(i)-'0');
                    i++;
                }
                num.add(count);
            }
            else if (s.charAt(i)==']'){
                int times = num.pop();
                StringBuilder temp = new StringBuilder(str.pop());
                for (int j=0; j<times; j++){
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            }
            else if (Character.isLetter(s.charAt(i))){
                res+=s.charAt(i);
                i++;
            }
            else if (s.charAt(i)=='['){
                str.add(res);
                res = "";
                i++;
            }
        }

        return res;
    }
}
