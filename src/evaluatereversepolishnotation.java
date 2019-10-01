import java.util.Stack;

public class evaluatereversepolishnotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (!Character.isDigit(tokens[i].charAt(0))){
                if (tokens[i].length()>1){
                    stack.add(Integer.valueOf(tokens[i]));
                    continue;
                }
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                if (tokens[i].charAt(0)=='*'){
                    stack.push(operand1*operand2);
                }
                else if (tokens[i].charAt(0)=='+'){
                    stack.push(operand1+operand2);
                }
                else if (tokens[i].charAt(0)=='/'){
                    stack.push(operand2/operand1);
                }
                else if (tokens[i].charAt(0)=='-'){
                    stack.push(operand2-operand1);
                }
            }
            else {
                stack.add(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();

    }
}
