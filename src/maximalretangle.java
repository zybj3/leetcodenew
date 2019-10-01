import java.util.Arrays;
import java.util.Stack;

public class maximalretangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int area = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix[0].length;i++){
            if (matrix[0][i]=='1'){
                dp[0][i] = 1;
            }
        }

        area = getareabystack(dp[0]);
        for (int i=1;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1') {
                    dp[i][j] = 1 + dp[i-1][j];
                }

            }

            area = Math.max(area,getareabystack(dp[i]));


        }
        return area;
    }

//    public int getarea(int[] area,int index){
//        int maxarea = 0;
//        for (int i=0;i<area.length;i++){
//            if(area[i]==0){
//                continue;
//            }
//            int minheight = area[i];
//            for (int j=i;j>=0;j--){
//                if(area[j]==0){
//                    break;
//                }
//                minheight = Math.min(minheight,area[j]);
//                int curarea = (i-j+1)*minheight;
//                maxarea = Math.max(maxarea,curarea);
//            }
//
//        }
//
//        return maxarea;
//    }

    public int getareabystack(int[] height){
        int maxarea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] newheight = Arrays.copyOf(height,height.length+1);
        for (int i=0;i<newheight.length;){
            if (stack.isEmpty() || newheight[stack.peek()]<=newheight[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxarea = Math.max(newheight[t]*(stack.isEmpty()?i:i-stack.peek()-1),maxarea);
            }
        }
        return maxarea;
    }
}
