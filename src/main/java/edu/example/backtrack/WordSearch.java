package edu.example.backtrack;

public class WordSearch {
    int ROWLEN, COLLEN;
    public boolean exist(char[][] board, String word) {
        ROWLEN = board.length;
        COLLEN = board[0].length;
        if(ROWLEN == 0 && COLLEN == 0){
            return false;
        }
        for(int row = 0; row < ROWLEN; row++){
            for(int col = 0; col < COLLEN; col++){
               if(backTrack(row, col, word, board, 0))return true;
            }
        }
        return false;
    }
    private boolean backTrack(int row, int col, String word, char[][] board, int index){
        if(index == word.length()){
            return true;
        }
        if(row < 0 || row > ROWLEN || col < 0 || col > COLLEN || board[row][col] != word.charAt(index) || board[row][col] == '#'){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean res =
                backTrack(row + 1, col, word, board, index + 1) ||
                backTrack(row - 1, col, word, board, index + 1) ||
                backTrack(row, col + 1, word, board, index + 1) ||
                backTrack(row, col - 1, word, board, index + 1);
        board[row][col] = temp;
        return res;
    }
}
