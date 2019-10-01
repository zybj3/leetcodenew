public class StringtoInteger {
    public int myAtoi(String str) {
        if(str==null || str.length()==0){
            return 0;
        }
        int op = 1;
        int index = 0;
        while (index<str.length() && str.charAt(index)==' '){
            index++;
        }
        if (index<str.length() && str.charAt(index)=='-'){
            op = -1;
            index++;
        }else if (index<str.length() && str.charAt(index)=='+'){
            op = 1;
            index++;
        }else if (index<str.length() && Character.isDigit(str.charAt(index))){
            return ConverttoInteger(index, str, op);
        }
        if (index<str.length() && Character.isDigit(str.charAt(index))){
            int res = ConverttoInteger(index, str, op);
            return res;
        }

        return 0;


    }
    public int ConverttoInteger(int index, String str, int op){
        int num = 0;

        while (index<str.length() && Character.isDigit(str.charAt(index))){
            if (num==Integer.MAX_VALUE/10){
                if (op==1 && Character.getNumericValue(str.charAt(index))>7){
                    return Integer.MAX_VALUE;
                }
                if (op==-1 && Character.getNumericValue(str.charAt(index))>8){
                    return Integer.MIN_VALUE;
                }
            }

            if (num>Integer.MAX_VALUE/10){
                return op==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            num = 10*num + Character.getNumericValue(str.charAt(index));
            index++;
        }

        return num * op;
    }


}
