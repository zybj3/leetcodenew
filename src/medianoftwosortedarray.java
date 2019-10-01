import java.util.HashMap;
import java.util.Stack;

public class medianoftwosortedarray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0,j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i+j<(m+n)/2+1){
            if(i<m && j<n){
                if (nums1[i] <= nums2[j]) {
                    stack.add(nums1[i]);
                    i++;
                }
                else if (nums1[i] > nums2[j]) {
                    stack.add(nums2[j]);
                    j++;
                }
            }
            else{
                if(i>=m && j<n){
                    stack.add(nums2[j]);
                    j++;
                }
                else if(i<m && j>=n){
                    stack.add(nums1[i]);
                    i++;
                }
            }
        }
        if ((m+n)%2!=0){
            return (double)stack.pop();
        }
        else
            return (double)(stack.pop()+stack.pop())/2;
    }

}
