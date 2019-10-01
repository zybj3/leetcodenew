public class primepalindrome {
    //长度为偶数的回文数必然会被11整除，所以选长度为奇数的进行检验就完事了
    public int primePalindrome(int N) {
        if (N>=8 && N<=11){
            return 11;
        }
        for (int i=1;i<Math.pow(10,8);i++){
            String left = Integer.toString(i);
            String right = new StringBuilder(left).reverse().substring(1);
            int num = Integer.parseInt(left+right);
            if (num>=N && isPrime(num)){
                return num;
            }
        }

        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }
}
