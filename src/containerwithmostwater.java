public class containerwithmostwater {
    public int maxArea(int[] height) {
        int contain = Math.min(height[0],height[1]);
        int slow = 0, fast = 1;
        while (slow<height.length-1) {
            while (fast < height.length) {
                contain = Math.max(contain,(fast-slow)*Math.min(height[slow],height[fast]));
                fast++;
            }
            slow++;
            fast = slow+1;
        }

        return contain;
    }
}
