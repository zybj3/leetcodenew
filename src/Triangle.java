import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle.size()==1){
            return triangle.get(0).get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i=1;i<triangle.size();i++){
            List<Integer> curlevel = triangle.get(i);
            for (int j=0;j<curlevel.size();j++){
                List<Integer> lastlevel = triangle.get(i-1);
                if (j==0){
                    curlevel.set(j,lastlevel.get(0)+curlevel.get(j));
                }
                else if (j==curlevel.size()-1){
                    curlevel.set(j,lastlevel.get(j-1)+curlevel.get(j));
                }
                else {
                    int left = lastlevel.get(j-1);
                    int right = lastlevel.get(j);
                    curlevel.set(j,curlevel.get(j) + Math.min(left, right));
                }
            }

            if (i==triangle.size()-1){
                for (int j=0;j<triangle.get(i).size();j++) {
                    if (triangle.get(i).get(j)<min){
                        min = triangle.get(i).get(j);
                    }
                }
            }

        }
        return min;
    }
}
