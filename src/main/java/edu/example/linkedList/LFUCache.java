package edu.example.linkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    private int capacity;
    // Storing set of numbers whose frequency is same
    private Map<Integer, LinkedHashSet<Integer>> frequencyCounter;
    // stores the key value alongwith Pair of freq and value
    private Map<Integer, Pair<Integer, Integer>> cache;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.frequencyCounter = new HashMap<>();
        this.cache = new HashMap<>();
        minFreq = 0;
    }

    private void insert(int key, int frequency, int value){
        cache.put(key, new Pair<>(key, frequency));
        frequencyCounter.computeIfAbsent(key, k -> new LinkedHashSet<>()).add(value);
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Pair<Integer, Integer> freqAndValue= cache.get(key);
        int frequency = freqAndValue.key();
        Set<Integer> keySet = frequencyCounter.get(key);
        if(keySet.isEmpty()) {
            frequencyCounter.remove(frequency);
            if(minFreq == frequency){
                minFreq++;
            }
        }
        int value = freqAndValue.value();
        insert(key, frequency + 1, value);
        return value;
    }


    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null) {
            cache.put(key, new Pair<>(frequencyAndValue.key(), value));
            get(key);
            return;
        }
        if (capacity == cache.size()) {
            final Set<Integer> keys = frequencyCounter.get(minFreq);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if (keys.isEmpty()) {
                frequencyCounter.remove(minFreq);
            }
        }
        minFreq = 1;
        insert(key, 1, value);
    }
    record Pair<Key, Value>(Key key, Value value) {}
}

