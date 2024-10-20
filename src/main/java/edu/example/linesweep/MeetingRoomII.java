package edu.example.linesweep;

import java.util.Arrays;

public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] startingTime = new int[len];
        int[] endingTime = new int[len];
        for(int i = 0 ; i < len; i++){
            startingTime[i] = intervals[i][0];
            endingTime[i] = intervals[i][1];
        }
        Arrays.sort(startingTime);
        Arrays.sort(endingTime);
        int startPtr = 0, endPtr = 0;
        int numOfRooms = 0;
        while(startPtr < len){
            // if there's a meeting that starts after the endTime of another meeting
            // decrement the count of rooms as we can reuse the room
            if(startingTime[startPtr] >= endingTime[endPtr]){
                numOfRooms-= 1;
                endPtr++;
            }
            numOfRooms+=1;
            startPtr++;
        }
        return numOfRooms;

    }
}
