public class satisfiabilityofequality {
    private int[] parents;
    private int[] rank;

    private int find(int target){
        if (target!=parents[target]){
            parents[target] = find(parents[target]);
        }

        return parents[target];
    }


    private boolean union(int num1, int num2){
        int p1 = find(num1);
        int p2 = find(num2);

        if (p1==p2){
            return false;
        }

        if (rank[p1]>rank[p2]){
            parents[p2] = p1;
        }else if (rank[p2]>rank[p1]){
            parents[p1] = p2;
        }
        else {
            parents[p1] = p2;
            rank[p2]++;
        }

        return true;
    }

    public boolean equationsPossible(String[] equations) {
        parents = new int[26];
        rank = new int[26];

        for (int i=0;i<parents.length;i++){
            parents[i] = i;
            rank[i] = 1;
        }

        for (String str:equations){
            char a = str.charAt(0);
            char b = str.charAt(3);
            if (!str.contains("!")) {
                union(a - 'a', b - 'a');
            }


        }

        for (String str:equations){
            char a = str.charAt(0);
            char b = str.charAt(3);
            if (str.contains("!")) {
                if (find(a-'a')==find(b-'a')){
                    return false;
                }
            }
        }

        return true;
    }
}
