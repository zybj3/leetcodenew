public class zigzagconversion {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<=numRows){
            return s;
        }
        int [][] zigzag = new int[numRows][s.length()];
        int pos = 1;
        int height = 0;
        int width = 0;
        int flag = 0;
        while (pos<s.length()+1){
            if (flag==0) {
                height = 0;
            }
            else {
                height = 1;
            }
            while (height<numRows) {
                zigzag[height][width] = pos;
                pos++;
                height++;
            }

            flag = 1;
            width++;
            height = numRows-2;
            while (height>=0){
                zigzag[height][width] = pos;
                height--;
                pos++;
                width++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<zigzag.length;i++){
            for(int j=0;j<zigzag[0].length;j++){
                if (zigzag[i][j]<s.length()+1&&zigzag[i][j]!=0){
                    sb.append(s.charAt(zigzag[i][j]-1));
                }
            }
        }
        return sb.toString();
    }
}
