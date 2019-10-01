public class searcha2dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int rowlen = matrix.length-1;
        int collen = matrix[0].length-1;

        int left = 0, right = rowlen, mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            if (matrix[mid][0]<=target && matrix[mid][collen]>=target){
                break;
            }
            else if (matrix[mid][0]>target){
                right = mid - 1;
            }
            else if (matrix[mid][collen]<target){
                left = mid + 1;
            }
        }
        System.out.println(mid);
        left = 0;
        right = collen;
        int mid1 = 0;
        while (left<=right){
            mid1 = (left + right)/2;
            if (matrix[mid][mid1]==target){
                return true;
            }
            else if (matrix[mid][mid1]>target){
                right = mid1 - 1;
            }
            else left = mid1 + 1;
        }

        return false;
    }
}
