package edu.example.linesweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort( intervals, (a, b) -> Integer.compare(a[0], b[0]));
        result.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] oldInterval = result.get(result.size() - 1);
            int[] newInterval = intervals[i];
            // end of the previous interval < start of new interval
            if (oldInterval[1] < newInterval[0]) {
                result.add(newInterval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(oldInterval[1], newInterval[1]);
                result.get(result.size() - 1)[0] = Math.min(oldInterval[0], newInterval[0]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
