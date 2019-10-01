public class addingtwonegabinarynumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] res = new int[Math.max(arr1.length,arr2.length)+2];

        int index1 = arr1.length-1;
        int index2 = arr2.length-1;
        int index = res.length-1;

        while (index>=0){
            int addnum1 = index1<0 ? 0 : arr1[index1--];
            int addnum2 = index2<0 ? 0 : arr2[index2--];

            int sum = res[index] + addnum1 + addnum2;
            if (sum>=2){
                res[index-1] -= 1;
                sum %= 2;
                res[index] = sum;
            }
            else if (sum==-1){
                res[index] = 1;
                res[index-1] = 1;
            }
            else{
                res[index] = sum;
            }

            index--;
        }

        index = 0;
        while (res[index]==0 && index<res.length-1){
            index++;
        }

        int[] newres = new int[res.length-index];
        for (int i=0;i<newres.length;i++){
            newres[i] = res[i+index];
        }

        res = index==0? res : newres;
        return res;
    }
}
