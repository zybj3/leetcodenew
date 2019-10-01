import java.util.Arrays;

public class duplicatezeros {
    public void duplicateZeros(int[] arr) {
        int i=0,j=0;
        int count = 0;
        int [] copy = new int[arr.length];

        while (j<arr.length && i<arr.length){
            if (arr[i]!=0){
                copy[j] = arr[i];
                i++;
                j++;
            }
            else {
                copy[j] = 0;
                if(j+1<arr.length){
                    copy[j+1] = 0;
                }
                j+=2;
                i++;
            }
        }

        System.out.println(Arrays.toString(copy));
        arr = Arrays.copyOfRange(copy,0,arr.length);
    }

    public static void lll(int[] arr){
        int [] copy = new int[arr.length];
        copy[0] = 1;

        arr[2] = 7;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        lll(arr);
        System.out.println(Arrays.toString(arr));
    }
}
