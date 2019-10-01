import java.util.Stack;

public class solvetheequation {
    public String solveEquation(String equation) {
        Stack<Integer> leftx = new Stack<>();
        Stack<Integer> leftnum = new Stack<>();

        Stack<Integer> rightx = new Stack<>();
        Stack<Integer> rightnum = new Stack<>();

        String[] strings = equation.split("=");
        String left = strings[0]+" ", right = strings[1]+" ";

        separate(left,leftx,leftnum);
        separate(right,rightx,rightnum);
        // System.out.println(leftx);

        int coxleft = 0;
        while (!leftx.isEmpty()){
            coxleft+=leftx.pop();
        }

        int numleft = 0;
        while (!leftnum.isEmpty()){
            numleft+=leftnum.pop();
        }

        int coxright = 0;
        while (!rightx.isEmpty()){
            coxright+=rightx.pop();
        }

        int numright = 0;
        while (!rightnum.isEmpty()){
            numright+=rightnum.pop();
        }

        int coeff = coxleft - coxright;
        int num = numleft - numright;

        if (coeff==0 && num==0){
            return "Infinite solutions";
        }

        if (coeff==0 && num!=0){
            return "No solution";
        }

        int res = num/-coeff;

        return "x=" + String.valueOf(res);
    }

    private void separate(String equation, Stack xstack, Stack numstack){
        int index = 0;
        int num = 0;
        int sign = 1;
        int flag = 0;
        while (index<equation.length()){
            while (index<equation.length() && Character.isDigit(equation.charAt(index))){
                num = num*10 + equation.charAt(index) - '0';
                index++;
                flag = 1;
            }
            if (equation.charAt(index)=='x'){
                if (flag==0 && num==0){
                    num = 1;
                }
                else if(flag==1 && num==0){
                    num = 0;
                }
                xstack.push(sign*num);
                index++;
            }
            else {
                numstack.push(sign*num);
            }

            num = 0;
            if (index<equation.length() && equation.charAt(index)=='+'){
                sign = 1;
            }
            else if (index<equation.length() && equation.charAt(index)=='-'){
                sign = -1;
            }

            flag = 0;
            index++;
        }
    }
}
