public class shiftingletters {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder sb = new StringBuilder();


        for (int i=shifts.length-1;i>=0;i--){
            if (i<shifts.length-1) {
                shifts[i] = (shifts[i + 1] + shifts[i])%26;
            }

            int moves = shifts[i]%26 + S.charAt(i);
            if (moves>122){
                moves = 97 + moves-122-1;
            }
            sb.append((char)moves);
        }

        sb.reverse();
        return sb.toString();
    }
}
