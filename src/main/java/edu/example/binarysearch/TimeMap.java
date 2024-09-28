package edu.example.binarysearch;

import java.util.*;

public class TimeMap {
    Map<String, List<Node>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Node>());
        }
        List<Node> store= map.get(key);
        store.add(new Node(value, timestamp));
        map.put(key, store);
    }

    public String get(String key, int timestamp) {
        String result = "";
        if(map.containsKey(key)) {
            int left = 0, right = map.get(key).size()-1;
            List<Node> nodes = map.get(key);

            while(left <= right) {
                int mid = left + (right - left) / 2;
                int time = nodes.get(mid).timestamp;
                if( time == timestamp){
                    return nodes.get(mid).value;
                } else if( time < timestamp) {
                    result = nodes.get(mid).value;
                    left = mid + 1;
                }  else{
                    right = mid - 1;
                }
            }
        }

        return result;
    }
}
class Node{
    String value;
    int timestamp;
    Node(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public int getTimestamp() {
        return timestamp;
    }
}
