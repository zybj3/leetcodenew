public class LongestRepeatingCharaterReplacement {
    /*
    O(26N)
     */
//    public int characterReplacement(String s, int k) {
//        int[] count = new int[26];
//        int slow = 0;
//        int res = 0;
//        for (int fast = 0; fast < s.length(); fast++) {
//            count[s.charAt(fast)-'A']++;
//            int max = getMax(count);
//            while (fast-slow+1-max>k){
//                count[s.charAt(slow)-'A']--;
//                slow++;
//            }
//
//            res = Math.max(res, fast-slow+1);
//        }
//
//        return res;
//    }
//
//    public int getMax(int[] count) {
//        int max = 0;
//        for (int i = 0; i < count.length; i++) {
//            max = Math.max(count[i], max);
//        }
//
//        return max;
//    }

    /*
    O(n)
     */

    public int characterReplacement(String s, int k) {
        int res = 0;
        int slow = 0;
        int[] count = new int[26];
        int max = 0;
        for (int fast = 0; fast<s.length(); fast++){
            max = Math.max(max, ++count[s.charAt(fast)-'A']);
            while (fast-slow+1-max>k){
                count[s.charAt(slow)-'A']--;
                slow++;
            }

            res = Math.max(res, fast-slow+1);
        }
        return res;
    }

//    public static void main(String[] args) {
//        int a = 2;
//        System.out.print(Math.max(2,a++));
//    }
}
