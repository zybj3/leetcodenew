public class maximumswap {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] pos = new int[10];
        for (int i=0;i<chars.length;i++){
            pos[chars[i]-'0'] = i;
        }

        for (int i=0;i<chars.length;i++){
            for (int j=9;j>chars[i]-'0';j--){
                if (pos[j]>i){
                    chars[pos[j]] = chars[i];
                    chars[i] = (char)(j+'0');
                    return Integer.valueOf(new String(chars));
                }
            }
        }

        return num;
    }
}
