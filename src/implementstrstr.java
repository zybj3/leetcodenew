import java.util.Stack;

public class implementstrstr {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(haystack.length()==0){
            return -1;
        }
        int i=0, j=0,index=0;
        int res = -1;
        if (needle.length()==1){
            for (int k=0;i<haystack.length();i++){
                if (haystack.charAt(k)==needle.charAt(0)){
                    return k;
                }
            }
        }
        while (index<haystack.length()){
            i = index;
            j = 0;
            while (j< needle.length() && i<haystack.length() && needle.charAt(j)==haystack.charAt(i)){
                i++;
                j++;
            }
            if (j==needle.length()){
                res = i-needle.length();
            }
            index++;
        }
        return res;
    }

}
