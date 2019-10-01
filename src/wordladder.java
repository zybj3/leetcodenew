import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class wordladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        int[] visited = new int[wordList.size()];
        Queue<String> path = new LinkedList<>();
        path.add(beginWord);
        int level = 1;
        while (!path.isEmpty()){
            int size = path.size();
            while (size>0) {
                String current = path.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (differ(current, wordList.get(i)) == 1 && visited[i] != 1) {
                        path.add(wordList.get(i));
                        visited[i] = 1;
                        if (wordList.get(i).equals(endWord)) {
                            return level + 1;
                        }
                    }
                }
                size--;
            }

            level++;
        }

        return 0;

    }

    public int differ(String current,String compare){
        int diff = 0;
        for (int i=0;i<current.length();i++){
            if (current.charAt(i)!=compare.charAt(i)){
                diff++;
            }
        }

        return diff;
    }
}
