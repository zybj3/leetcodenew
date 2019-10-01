import java.util.Stack;

public class asteriodcollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i=1;i<asteroids.length;i++){
            boolean exploded = false;
            while (!stack.isEmpty() && asteroids[i]<0 && stack.peek()>0){
                if (Math.abs(asteroids[i])>Math.abs(stack.peek())){
                    stack.pop();
                }else if (Math.abs(asteroids[i])==Math.abs(stack.peek())){
                    stack.pop();
                    exploded = true;
                    break;
                }
                else {
                    exploded = true;
                    break;
                }
            }

            if (!exploded){
                stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (int num:stack){
            res[index++] = num;
        }
        return res;
    }
}
