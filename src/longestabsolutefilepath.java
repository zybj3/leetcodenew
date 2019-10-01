import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class longestabsolutefilepath {
    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int res = 0;
        for (String str: input.split("\n")){
            int level = str.lastIndexOf("\t") + 1;
            int len = str.substring(level).length();
            if (str.contains(".")){
                res = Math.max(res, map.get(level) + len);
            }else {
                map.put(level+1, map.get(level)+len+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestabsolutefilepath longestabsolutefilepath = new longestabsolutefilepath();
        String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        longestabsolutefilepath.lengthLongestPath(str);
    }

}
