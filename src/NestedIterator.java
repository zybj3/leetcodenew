import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    int size = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        addall(nestedList, deque);
        this.size = deque.size();
    }

    public void addall (List<NestedInteger> nestedList, Deque<Integer> deque){
        for (NestedInteger entry: nestedList){
            if (entry.isInteger()){
                deque.addLast(entry.getInteger());
            }else {
                addall(entry.getList(), deque);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return size>0;
    }

    @Override
    public Integer next() {
        int num = deque.pollFirst();
        this.size--;
        return num;
    }
}