import java.util.*;

public class concatenatedwords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        List<String> res = new ArrayList<>();
        HashSet<String> prevStr = new HashSet<>();
        for (int i=0; i<words.length; i++){
            if (!prevStr.isEmpty()){
                if (check(words[i],prevStr)){
                    res.add(words[i]);
                }
            }
            prevStr.add(words[i]);
        }


        return res;
    }

    boolean check(String curr, HashSet<String> dict){
        boolean[] dp = new boolean[curr.length()+1];
        dp[0] = true;
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<=i;j++){
                if (dict.contains(curr.substring(j-1,i))){
                    if (dp[j-1]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[curr.length()];
    }


    public static void main(String[] args) {
        String str = "aaa";

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        test(str, list);
        System.out.println(list);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<Integer>[] a  = new ArrayList[1];
        a[0] = list1;
        ArrayList<Integer>[] b = Arrays.copyOf(a,3);
        System.out.println(b[0]);
        a[0].add(2);
        System.out.println(b[0]);
    }

    public static void test(String str, ArrayList<Integer> list){
        str += "a";
        list.add(1);
    }
}
