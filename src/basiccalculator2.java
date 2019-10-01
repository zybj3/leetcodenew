import java.util.Stack;

public class basiccalculator2 {
    public int calculate(String s) {
        s += '+';
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                continue;
            }

            if (Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i)-'0';
                continue;
            }

            if (op == '+'){
                stack.push(num);
            }
            else if (op == '-'){
                stack.push(-num);
            }
            else if (op == '*'){
                stack.push(num*stack.pop());
            }
            else if (op == '/'){
                stack.push(stack.pop()/num);
            }
            op = s.charAt(i);
            num = 0;
        }


        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}
