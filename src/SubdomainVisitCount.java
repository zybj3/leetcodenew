import java.util.*;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<cpdomains.length; i++){

            String[] strs = cpdomains[i].split(" ");
            int amount = Integer.parseInt(strs[0]);
            String domains = strs[1];
            String[] domains_strs = domains.split("\\.");
            int len = 0;
            for (int j=domains_strs.length-1; j>=0; j--){
                len += domains_strs[j].length();
                String substr = domains.substring(domains.length()-len);
                if (map.containsKey(substr)){
                    map.put(substr, map.get(substr)+amount);
                }else {
                    map.put(substr, amount);
                }

                len+=1;
            }

        }

        List<String> res = new ArrayList<>();
        for (String str: map.keySet()){
            String string = "";
            string+=String.valueOf(map.get(str));
            string+=" ";
            string+=str;
            res.add(string);
        }

        return res;
    }
}
