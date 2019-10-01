import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDulicateFileinSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, HashMap<String, List<String>>> map = new HashMap<>();

        for (int i=0; i<paths.length; i++){
            String[] strs = paths[i].split(" ");
            String dir = strs[0];
            for (int j=1; j<strs.length; j++){
                String file_name = strs[j].split("\\(")[0];
                String file_cont = strs[j].split("\\(")[1].split("\\)")[0];
                if (map.containsKey(file_cont)){
                    if (map.get(file_cont).containsKey(file_name)){
                        map.get(file_cont).get(file_name).add(dir);
                    }else {
                        map.get(file_cont).put(file_name, new ArrayList<>());
                        map.get(file_cont).get(file_name).add(dir);
                    }
                }else {
                    map.put(file_cont, new HashMap<>());
                    map.get(file_cont).put(file_name, new ArrayList<>());
                    map.get(file_cont).get(file_name).add(dir);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String cont: map.keySet()){
            List<String> list = new ArrayList<>();

            for (String filename: map.get(cont).keySet()){
                List<String> dirtories = map.get(cont).get(filename);
                for (String dir: dirtories) {
                    list.add(dir + "/" + filename);
                }
            }

            if (list.size()>1){
                res.add(list);
            }
        }
        return res;
    }
}
