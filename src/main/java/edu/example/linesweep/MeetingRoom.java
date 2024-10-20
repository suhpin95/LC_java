package edu.example.linesweep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        int len = intervals.length;
        if(len == 0){
            return true;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> overLaps = new ArrayList<>();
        overLaps.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] oldMeeting = overLaps.get(overLaps.size() - 1);
            int[] newMeeting = intervals[i];
            if(newMeeting[0] < oldMeeting[1]) {
                return false;
            }
            overLaps.add(intervals[i]);
        }
        return true;
    }
}
