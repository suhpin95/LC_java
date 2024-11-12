package edu.example.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> cache;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    /**
     *
     * @param key
     * @return value
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(key);
        addNode(node.key, node.value);
        return node.value;
    }

    /**
     *
     * @param key ,unique id for the storing the value
     * @param value ,value to be stored in the data structure
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            removeNode(key);
        }
        if(cache.size() == capacity) {
            removeNode(head.key);
        }
        addNode(key, value);
    }

    private void addNode(int key, int value){
        Node node = new Node(key, value);
        appendNodeToList(node);
        cache.put(key, node);
    }

    private void appendNodeToList(Node newNode) {
        if(head == null){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }
    private void removeNode(int key){
        if(!cache.containsKey(key)){
            return;
        }
        Node node = cache.get(key);
        removeFromLinkedList(node);
        cache.remove(key);
    }

    private void removeFromLinkedList(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
        if(node == head) {
            head = node.next;
        }
        if(node == tail) {
            tail = node.prev;
        }
    }

    private static class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value =value;
        }
    }
}


