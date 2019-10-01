import java.util.Stack;

public class removekdigits {
    public String removeKdigits(String num, int k) {
        if (k==num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();

        int topop = k;
        stack.add(num.charAt(0));
        for (int i=1;i<num.length();i++){
            while (!stack.isEmpty() && stack.peek()>num.charAt(i)&& topop>0){
                stack.pop();
                topop--;
            }
            stack.push(num.charAt(i));
        }
        System.out.println(stack);

        while (topop>0){
            stack.pop();
            topop--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }

        return sb.toString();


    }
}
