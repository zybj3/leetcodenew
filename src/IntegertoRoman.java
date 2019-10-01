import java.util.HashMap;

public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String number = Integer.toString(num);
        for (int i=1000,j=3;i>=1;i/=10,j--){
            int factor = num/i;
            if (factor > 0){
                if (j==3){
                    for (int k=0;k<factor;k++){
                        sb.append("M");
                    }
                }
                else if (j==2){
                    factor = factor%10;
                    // System.out.println(factor);
                    if (factor==4){
                        sb.append("CD");
                    }
                    else if (factor==9){
                        sb.append("CM");
                    }
                    else {
                        if (factor>5){
                            sb.append("D");
                            for (int k=5;k<factor;k++){
                                sb.append("C");
                            }
                        }
                        else if (factor<5){
                            for (int k=0;k<factor;k++) {
                                sb.append("C");
                            }
                        }
                        else {
                            sb.append("D");
                        }
                    }

                }
                else if (j==1){
                    factor = factor%10;

                    if (factor==4){
                        sb.append("XL");
                    }
                    else if (factor==9){
                        sb.append("XC");
                    }
                    else {
                        if (factor>5){
                            sb.append("L");
                            for (int k=5;k<factor;k++){
                                sb.append("X");
                            }
                        }
                        else if (factor<5){
                            for (int k=0;k<factor;k++) {
                                sb.append("X");
                            }
                        }
                        else {
                            sb.append("L");
                        }
                    }
                }
                else if (j==0){
                    factor = factor%10;
                    if (factor==4){
                        sb.append("IV");
                    }
                    else if (factor==9){
                        sb.append("IX");
                    }
                    else {
                        if (factor>5){
                            sb.append("V");
                            for (int k=5;k<factor;k++){
                                sb.append("I");
                            }
                        }
                        else if (factor<5){
                            for (int k=0;k<factor;k++) {
                                sb.append("I");
                            }
                        }
                        else {
                            sb.append("V");
                        }
                    }
                }
            }

        }

        return sb.toString();
    }
}
