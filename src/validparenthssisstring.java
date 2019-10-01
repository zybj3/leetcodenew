import java.util.Stack;

public class validparenthssisstring {
    public boolean checkValidString(String s) {
        Stack<Integer> leftstack = new Stack<>();
        Stack<Integer> starstack = new Stack<>();

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                leftstack.push(i);
            }
            else if (s.charAt(i)=='*'){
                starstack.push(i);
            }
            else {
                if (leftstack.isEmpty()&&starstack.isEmpty()){
                    return false;
                }

                else if (!leftstack.isEmpty()){
                    leftstack.pop();
                }
                else{
                    starstack.pop();
                }
            }
        }

        while (!leftstack.isEmpty()&&!starstack.isEmpty()){
            if (leftstack.pop()>starstack.pop()){
                return false;
            }
        }

        return leftstack.isEmpty();
    }
}
