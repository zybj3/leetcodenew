public class sqrtx {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int left = 1;
        int right = x;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (x/mid==mid){
                return mid;
            }
            if (x/mid>mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left-1;
    }
}
