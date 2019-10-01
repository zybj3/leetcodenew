public class trappingrainwater {

    public int trap(int[] height) {
        if (height.length<3 || height==null){
            return 0;
        }

        int i = 0, j = height.length-1;
        int leftmost = 0, rightmost = 0;
        int max = 0;
        while (i<j){
            leftmost = Math.max(height[i],leftmost);
            rightmost = Math.max(height[j],rightmost);
            if (leftmost<rightmost){
                max += leftmost-height[i];
                i++;
            }
            else {
                max += rightmost-height[j];
                j--;
            }
        }

        return max;
    }

}
