import java.util.Arrays;
import java.util.Stack;

public class removepuplicateletters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] amount = new int[26];
        boolean[] visited = new boolean[26];

        for (int i=0;i<s.length();i++){
            int position = s.charAt(i)-'a';
            amount[position]++;
        }


        System.out.println(Arrays.asList(amount));

        for (char ch:s.toCharArray()){
            amount[ch-'a']--;
            if (visited[ch-'a']){
                continue;
            }
            //如果栈中的char字母表排序比当前的字母后并且后面还有货，就全部pop出来，给字母表靠前的（当前字母）留出空间
            while (!stack.isEmpty() && amount[stack.peek()-'a']>0 && ch<stack.peek()){
                visited[stack.pop()-'a'] = false;
            }

            stack.push(ch);
            visited[ch-'a'] = true;
        }

        String res = "";
        for (char ch:stack){
            res += ch;
        }
        return res;
    }

}
