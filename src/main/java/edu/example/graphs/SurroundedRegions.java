package edu.example.graphs;

public class SurroundedRegions {
    int ROWLEN = 0, COLLEN = 0;
    public void solve(char[][] board) {
        ROWLEN = board.length;
        COLLEN = board[0].length;
        for (int i = 0; i < ROWLEN; i++) {
            for (int j = 0; j < COLLEN; j++) {
               if(board[i][j] == 'O' && (i == 0 || i == ROWLEN-1 || j == 0 || j == COLLEN -1) ) {
                   dfs(i,j, board);
               }
            }
        }

        // later on flip all the T's to O
        for( int row = 0; row < ROWLEN; row++ ) {
            for( int col = 0; col < COLLEN; col++ ) {
                if(board[row][col] == 'T') {
                    board[row][col] = 'O';
                } else{
                    // Else it is X
                    board[row][col] = 'X';
                }
            }
        }

    }
    // Perform DFS from the border
    private void dfs(int row, int col, char[][] board) {
        // boundary conditions and already visited, avoid visiting elements marked as 'X' as they have already been converted
        if(row < 0 || row >= ROWLEN || col < 0 || col >= COLLEN || board[row][col] == 'T' || board[row][col] != 'O' ) {
            return;
        }
        // mark the visited as T
        board[row][col] = 'T';
        dfs(row+1, col, board);
        dfs(row-1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}
