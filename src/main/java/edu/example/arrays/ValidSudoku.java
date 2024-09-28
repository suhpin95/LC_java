package edu.example.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ValidSudoku {
    Map<String, HashSet> rowMap = new HashMap<>();
    Map<String, HashSet> colMap = new HashMap<>();
    Map<String, HashSet> subGridMap = new HashMap<>();


    public boolean isValidSudoku(char[][] board) {
        // row, col, subgrid
        int ROWLEN = board.length;
        int COLLEN = board[0].length;
        if(ROWLEN == 0){
            return false;
        }
        for(int row = 0; row < ROWLEN; row++){
            for(int col = 0; col < COLLEN; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                Integer rowKey = row, colKey = col;
                HashSet<Integer> rowSet = rowMap.get(rowKey.toString());
                HashSet<Integer> colSet = colMap.get(colKey.toString());
                HashSet<Integer> subGridSet = subGridMap.get(getIndex(rowKey, colKey));
                int val = board[row][col];
                if(rowSet.contains(val) || colSet.contains(val) || subGridSet.contains(val)){
                    return false;
                }
                rowSet.add(val);
                colSet.add(val);
                subGridSet.add(val);
                rowMap.put(String.valueOf(row), rowSet);
                colMap.put(String.valueOf(col), colSet);
                subGridMap.put(String.valueOf(row), subGridSet);
            }
        }
        return true;

    }

    private String getIndex(int row, int col) {
        row /= 3;
        col /= 3;
        return row + "-" + col;
    }
    /**
     * [
     *  [".",".","4",".",".",".","6","3","."],
     *  [".",".",".",".",".",".",".",".","."],
     *  ["5",".",".",".",".",".",".","9","."],
     *  [".",".",".","5","6",".",".",".","."],
     *  ["4",".","3",".",".",".",".",".","1"],
     *  [".",".",".","7",".",".",".",".","."],
     *  [".",".",".","5",".",".",".",".","."],
     *  [".",".",".",".",".",".",".",".","."],
     *  [".",".",".",".",".",".",".",".","."]]
     */
}
