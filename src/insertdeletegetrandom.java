import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class insertdeletegetrandom {
    class RandomizedSet {
        /*
        找到对应的index，和最后的交换，然后删除最后的
         */
        private HashMap<Integer,Integer> location;
        private ArrayList<Integer> set;
        Random random = new Random();
        /** Initialize your data structure here. */
        public RandomizedSet() {
            set = new ArrayList<>();
            location = new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (location.containsKey(val)){
                return false;
            }
            location.put(val,set.size());
            set.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!location.containsKey(val)){
                return false;
            }
            // System.out.println(location);
            // System.out.println(set);
            int index = location.get(val);
            int lastnum = set.get(set.size()-1);
            set.set(index,lastnum);
            location.put(lastnum,index);
            location.remove(val);
            set.remove(set.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return set.get(random.nextInt(set.size()));
        }
    }

}
