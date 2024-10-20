package edu.example.linesweep;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        int index = 0;
        while(index < len && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }
        while(index < len && intervals[index][0] <= newInterval[1]) {
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            index++;
        }
        result.add(newInterval);
        while(index < len) {
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }
}

