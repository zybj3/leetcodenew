import java.util.List;

public class NestedListWeightSum2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return getResult(nestedList, maxDepth);
    }

    private int getResult(List<NestedInteger> nestedList, int curdepth){
        int res = 0;
        for (NestedInteger nestedInteger: nestedList){
            if (nestedInteger.isInteger()){
                res += nestedInteger.getInteger() * curdepth;
            }else {
                res += getResult(nestedInteger.getList(), curdepth-1);
            }
        }

        return res;
    }

    private int getMaxDepth(List<NestedInteger> nestedList){
        int max = 1;
        for (NestedInteger nestedInteger: nestedList){
            if (nestedInteger.isInteger()){
                continue;
            }
            else {
                int level = 1 + getMaxDepth(nestedInteger.getList());
                max = Math.max(level, max);
            }
        }

        return max;
    }
}