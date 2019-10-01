import java.util.Stack;

public class Maximumwidthramp {
    /*
    思想：我认为是分块+贪心选择
     */
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<A.length;i++){
            if (stack.isEmpty() || A[i]<A[stack.peek()]){
                stack.add(i);
            }
        }
        // System.out.println(stack);
        int res = 0;

        for (int i=A.length-1; i>res; i--){
            while (!stack.isEmpty() && A[i]>=A[stack.peek()]){
                res = Math.max(res, i - stack.pop());
            }
        }




        return res;
    }





}
