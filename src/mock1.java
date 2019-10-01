public class mock1 {
    public String licenseKeyFormatting(String S, int K) {
        String[] strings = S.split("-");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i=strings.length-1; i>=0; i--){
            for (int j=strings[i].length()-1; j>=0; j--){
                if (Character.isLetter(strings[i].charAt(j))) {
                    sb.append(Character.toUpperCase(strings[i].charAt(j)));
                }else {
                    sb.append(strings[i].charAt(j));
                }
                count++;

                if (count==K){
                    sb.append("-");
                    count = 0;
                }
            }
        }

        if (sb.length()>0 && sb.charAt(0)=='-'){
            sb.deleteCharAt(0);
        }

        return sb.reverse().toString();
    }

//    public int lengthLongestPath(String input) {
//
//    }
}
