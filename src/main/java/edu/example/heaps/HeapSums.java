package edu.example.heaps;


import java.util.PriorityQueue;

public class HeapSums {
    public Object[] printKSmallest(int[] arr, int k) {
        int len = arr.length;
        if(len == 0){
            return null;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int i = 0 ; i < len; i++){
            if(maxHeap.size() < k){
                maxHeap.add(arr[i]);
            }
            else if(maxHeap.peek() > arr[i]){
                    maxHeap.remove();
                    maxHeap.add(arr[i]);
            }
        }
        Object[] result = maxHeap.toArray();
        int start = 0, end = result.length-1;
        while(start < end){
            swap(result, start ,end);
            start++;
            end--;
        }
        return result;
    }
    private void swap(Object[] arr, int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
