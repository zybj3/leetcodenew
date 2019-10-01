public class validperfectsquare {
    public boolean isPerfectSquare(int num) {
        if(num==0){
            return true;
        }
        long left = 1;
        long right = num;

        while (left<=right){
            long mid = left + (right-left)/2;
            //System.out.println(mid + " " + left +" " + right);
            if (num==mid*mid){
                return true;
            }
            if (num/mid<mid){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;
    }
}
