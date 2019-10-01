import java.util.*;

public class palindromepairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++){
            map.put(words[i], i);
        }

        //1.存在""，另一个自己是回文串就行
        if (map.containsKey("")){
            int blank = map.get("");
            for (int i=0; i<words.length; i++){
                if (i==blank){
                    continue;
                }
                if (isPalindrome(words[i])){
                    res.add(Arrays.asList(blank, i));
                    res.add(Arrays.asList(i, blank));
                }
            }
        }


        //2.存在当前字符串的反转字符串
        for (int i=0; i<words.length; i++){
            StringBuilder sb = new StringBuilder(words[i]);
            String reverse = sb.reverse().toString();
            if (map.containsKey(reverse)){
                // System.out.println(sb.reverse().toString());
                int index = map.get(reverse);
                if (index!=i){
                    res.add(Arrays.asList(i, index));
                }
            }
        }


        //3. 如果s1[0,cut] 是回文串, 那么只要数组中有一个另外一个字符串等于[cut+1:-1] 的反转便可以构成回文串
        // 如果是s1[cut,-1] 是回文串，那么只要十足中有另外一个字符等于[0,cut]的反转便可以构成回文串

        for (int i=0; i<words.length; i++){
            String cur = words[i];
            for (int cut=1; cut<cur.length(); cut++){
                if (isPalindrome(cur.substring(0, cut))){
                    String cutreverse = new StringBuilder(cur.substring(cut)).reverse().toString();
                    // System.out.println(cutreverse);
                    if (map.containsKey(cutreverse)){
                        int index = map.get(cutreverse);
                        if (index!=i){
                            res.add(Arrays.asList(index, i));
                        }
                    }
                }

                if (isPalindrome(cur.substring(cut))){
                    String curreverse = new StringBuilder(cur.substring(0, cut)).reverse().toString();
                    if (map.containsKey(curreverse)){
                        int index = map.get(curreverse);
                        if (index!=i){
                            res.add(Arrays.asList(i, index));
                        }
                    }
                }
            }

        }
        return res;
    }


    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
