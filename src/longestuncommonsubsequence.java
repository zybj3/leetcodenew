public class longestuncommonsubsequence {
    public int findLUSlength(String[] strs) {
        int res = 0;
        for (int i=0;i<strs.length;i++){
            int j = 0;
            for (j=0;j<strs.length;j++){
                if (j==i){
                    continue;
                }
                if (isSubsequence(strs[i],strs[j])){
                    break;
                }
            }
            if (j==strs.length){
                res = Math.max(res,strs[i].length());
            }
        }

        if (res==0){
            return -1;
        }
        return res;
    }

    public boolean isSubsequence(String curr, String compare){
        if (curr.length()>compare.length()){
            return false;
        }

        int i = 0,j = 0;
        while (i<curr.length() && j<compare.length()){
            if (curr.charAt(i)==compare.charAt(j)){
                i++;
                j++;
            }
            else j++;
        }

        return i==curr.length();

    }
}
