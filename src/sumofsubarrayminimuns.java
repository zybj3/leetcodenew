import java.util.Stack;

public class sumofsubarrayminimuns {
    public int sumSubarrayMins(int[] A) {
        int[] leftamount = new int[A.length];
        int[] rightamount = new int[A.length];

        Stack<Integer> leftstack = new Stack<>();
        Stack<Integer> rightstack = new Stack<>();


        for (int i=0; i<leftamount.length; i++){
            int amount = 1;
            while (!leftstack.isEmpty() && A[leftstack.peek()]>=A[i]){
                leftstack.pop();
                if (leftstack.isEmpty()){
                    amount = Math.max(amount, i);
                }else
                amount = Math.max(amount, i - leftstack.peek()-1);
            }
            leftstack.push(i);
            leftamount[i] = amount;
        }


        for (int i=A.length-1; i>=0; i--){
            int amount = 1;
            while (!rightstack.isEmpty() && A[rightstack.peek()]>A[i]){
                rightstack.pop();
                if (rightstack.isEmpty()){
                    amount = Math.max(amount, rightamount.length-i);
                }
                amount = Math.max(amount, rightstack.peek()-i-1);
            }

            rightstack.push(i);
            rightamount[i] = amount;
        }


        int res = 0, mod = (int) (Math.pow(10,9) + 7);
        for (int i=0;i<A.length;i++){
            res = (res + leftamount[i]*rightamount[i]*A[i])%mod;
        }

        return res;
    }
}
