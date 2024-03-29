import java.util.LinkedList;
import java.util.Stack;

public class verifypreorderserializationofabinarytree {
    public boolean isValidSerialization(String preorder) {
        LinkedList<String> stack = new LinkedList<>();
        String[] arr = preorder.split(",");
        for (int i=0;i<arr.length;i++){
            stack.add(arr[i]);
            while (stack.size()>=3 && stack.get(stack.size()-1).equals("#") && stack.get(stack.size()-2).equals("#")
                    && !stack.get(stack.size()-3).equals("#")){
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add("#");
            }

        }

        return stack.size()==1 && stack.get(0).equals("#");
    }
}
