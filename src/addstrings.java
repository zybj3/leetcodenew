public class addstrings {

    public String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int [] res = new int[Math.max(m,n)+1];
        for (int i=res.length-1,sub=0;i>=0;i--,sub++){
            int add1 = 0, add2 = 0;
            if (m-1-sub>=0) {
                add1 = Character.getNumericValue(num1.charAt(m - 1 - sub));
            }
            if (n-1-sub>=0){
                add2 = Character.getNumericValue(num2.charAt(n - 1 - sub));
            }
            int sum = add1 + add2 + res[i];
            res[i] = (sum)%10;
            // System.out.println(res[i]);
            if (sum>=10){
                res[i-1] += sum/10;
            }


            // for(int num:res){
            //     System.out.print(num + " ");
            // }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        while (index<res.length){
            if (res[index]!=0){
                break;
            }
            index++;
        }
        if (index==res.length){
            sb.append(0);
        }
        else {
            for (int i = index; i < res.length; i++) {
                sb.append(res[i]);
            }
        }

        return sb.toString();

    }
}
