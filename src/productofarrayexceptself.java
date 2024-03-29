import java.util.Arrays;

public class productofarrayexceptself {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i=1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i=nums.length-1; i>=0; i--){
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int num = 3;
        int j = num<<3;
        System.out.println(num);
    }
}
