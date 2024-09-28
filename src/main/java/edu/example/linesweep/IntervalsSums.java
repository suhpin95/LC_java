package edu.example.linesweep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalsSums {
    public boolean hasOverlap(Interval[] intervals){
        int len = intervals.length;
        if(len == 0){
            throw new IllegalArgumentException("Intervals must contain at least one interval");
        }
        List<Point> points = new ArrayList<>();
        Collections.sort(points);
        for(Interval interval : intervals){
            points.add(new Point(interval.getStart(), true));
            points.add(new Point(interval.getEnd(), false));
        }
        Collections.sort(points);
        int count = 0;
        for(int i = 0; i < points.size(); i++){
            count = points.get(i).isStart ? count++ : count--;
            if(count > 1){
                return true;
            }
        }
        return false;
    }
}
class Point implements Comparable<Point>{
    int timeStamp;
    boolean isStart;

    public Point(int timeStamp, boolean isStart){
        this.timeStamp = timeStamp;
        this.isStart = isStart;
    }
    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    @Override
    public int compareTo(Point other) {
        if(this.timeStamp == other.timeStamp){
            return 0;
        } else{
            return this.isStart ? 1 : -1;
        }
    }
}
class Interval{
    int start;
    int end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
