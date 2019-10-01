public class validateipaddress {
    //无意义
    public String validIPAddress(String IP) {
        String[] ipv6strs = IP.split(":");
        String[] ipv4strs = IP.split("\\.");
        if (IP.length()==0 || IP.charAt(IP.length()-1)==':' || IP.charAt(IP.length()-1)=='.'){
            return "Neither";
        }

        if (ipv6strs.length==8){
            for (String str:ipv6strs){
                if (str.length()==0 || str.length()>4){
                    return  "Neither";
                }

//                int amount = 0;
//                for (int i=0;i<str.length();i++){
//                    if (str.charAt(i)=='0'){
//                        amount++;
//                    }
//                }

            }
            return "IPv6";
        }
        else if (ipv4strs.length==4){

            for (String str:ipv4strs){
                if(str.length()==0 || str.length()>3){
                    return "Neither";
                }
                if (str.charAt(0)=='0'){
                    System.out.println("111");
                    return "Neither";
                }
                else {
                    for (int i=0;i<str.length();i++){
                        if (str.charAt(i)<48 || str.charAt(i)>57){
                            System.out.println("211");
                            return "Neither";
                        }
                    }
                    int num = Integer.parseInt(str);
                    if (!(0<num && num<=255)){
                        System.out.println("311");
                        return "Neither";
                    }
                }
            }

            return "IPv4";
        }

        return "Neither";

    }
}
