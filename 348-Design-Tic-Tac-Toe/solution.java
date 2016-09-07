public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1){
            rows[row]++;
            cols[col]++;
            if(row == col) diag++;
            if(row + col == n - 1) antiDiag++;
        }
        else {
            rows[row]--;
            cols[col]--;
            if(row == col) diag--;
            if(row + col == n - 1) antiDiag--;
        }
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) return player;
        return 0;
        
    }
    /*
    看hint，用row[i] 和 col[j] 表示每行或列有几个数，如果是player1下的就加一，player2下的就减一。直到绝对值为n则分出胜负。
    */
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */