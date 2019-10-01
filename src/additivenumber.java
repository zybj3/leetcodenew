import java.util.ArrayList;
import java.util.List;

public class additivenumber {
    List<Integer> list = new ArrayList<>();
    public boolean isAdditiveNumber(String num) {
        helper(0,num);
        if (list.size()==0){
            return false;
        }
        return false;
    }

    public boolean helper(int index,String S){
        if (index==S.length() && list.size()>=3){
            return true;
        }

        for (int i=index;i<S.length();i++){
            if (S.charAt(index)=='0' && i>index){
                break;
            }
            long num = Long.parseLong(S.substring(index,i+1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            //System.out.println(num);
            if (list.size()>=2 && num > list.get(list.size()-1) + list.get(list.size()-2)){
                break;
            }
            if (list.size()<2 || num == list.get(list.size()-1) + list.get(list.size()-2)){
                list.add((int)num);
                if (helper(i+1,S)){
                    return true;
                }
                list.remove(list.size()-1);
            }
        }

        return false;
    }
}
