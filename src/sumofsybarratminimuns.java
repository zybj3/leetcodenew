import java.util.Stack;

public class sumofsybarratminimuns {
    public int sumSubarrayMins(int[] A) {
        int[] leftamount = new int[A.length];
        int[] rightamount = new int[A.length];

        Stack<int[]> leftstack = new Stack<>();
        Stack<int[]> rightstack = new Stack<>();

        for (int i=0;i<A.length;i++){
            int amount = 1;
            while (!leftstack.isEmpty() && leftstack.peek()[0]>=A[i]){
                amount += leftstack.pop()[1];
            }
            leftstack.push(new int[]{A[i],amount});
            leftamount[i] = amount;
        }

        for (int i=A.length-1;i>=0;i--){
            int amount = 1;
            while (!rightstack.isEmpty() && rightstack.peek()[0]>A[i]){
                amount += rightstack.pop()[1];
            }
            rightstack.push(new int[]{A[i],amount});
            rightamount[i] = amount;
        }

        int res = 0, mod = (int) (Math.pow(10,9) + 7);
        for (int i=0;i<A.length;i++){
            res = (res + leftamount[i]*rightamount[i]*A[i])%mod;
        }

        return res;
    }
}
