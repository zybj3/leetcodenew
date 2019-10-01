import java.util.Arrays;

public class assigncookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookies = 0;

        int i = 0, j = 0;
        while (i<g.length && j<s.length){
            if (s[j]>=g[i]){
                i++;
                j++;
                cookies++;
            }
            else j++;
        }
        return cookies;

    }
}
