import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class snakesandladders {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int target = board.length * board.length;
        int step = 1;
        queue.offer(1);
        visited.add(1);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                int curPos = queue.poll();
                for (int i=1; i<=6; i++){
                    int nextpos = curPos + i;
                    int[] posInBoard = transform(nextpos, board);
                    //System.out.println(nextpos +" " + Arrays.toString(posInBoard));
                    if (board[posInBoard[0]][posInBoard[1]]!= -1 ){
                        nextpos = board[posInBoard[0]][posInBoard[1]];
                    }
                    if (nextpos==target){
                        return step;
                    }
                    if(!visited.contains(nextpos)){
                        queue.offer(nextpos);
                        visited.add(nextpos);
                    }
                }
                size--;
            }
            step++;
        }

        return -1;
    }

    private int[] transform(int pos, int[][] board){
        int[] posInBoard = new int[2];
        int rol = pos/board.length ;
        int col = pos%board.length;

        if (pos%board.length==0){
            rol = board.length - rol;
            col = (pos/board.length)%2==0? 0 : board.length-1;
        }else {
            rol = board.length - rol - 1;
            col = (pos/board.length)%2==0? col-1 : board.length - col;
        }

        posInBoard[0] = rol;
        posInBoard[1] = col;
        return posInBoard;
    }
}
