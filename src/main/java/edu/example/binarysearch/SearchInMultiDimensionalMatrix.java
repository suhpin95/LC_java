package edu.example.binarysearch;

public class SearchInMultiDimensionalMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int low = 0, high = ROWS - 1;
        int row = 0;
        while (low <= high) {
            row = low + (high - low) / 2;
            if(target < matrix[row][COLS-1]) {
                high = row - 1;
            } else if(target > matrix[row][0]) {
                low = row + 1;
            } else {
                break;
            }
        }

        int left = 0, right = COLS-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(target < matrix[row][mid]) {
                right = mid -1;
            } else if(target > matrix[row][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
