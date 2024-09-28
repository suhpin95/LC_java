package edu.example.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class StockPriceTime {

    int windowSize;
    Deque<Pair> queueOfPrice= new LinkedList<>();
    public void add(int price, int day){
        while(queueOfPrice.isEmpty() && queueOfPrice.peek().timeStamp() < day - windowSize + 1){
            queueOfPrice.poll();
        }
        queueOfPrice.add(new Pair(price, day));
    }

    public int getMaxStockPrice(){
        Iterator<Pair> iterator = queueOfPrice.iterator();
        int maxPrice = Integer.MIN_VALUE;
        while(iterator.hasNext()){
            int stockPrice = iterator.next().price();
            maxPrice = Math.max(maxPrice, stockPrice);
        }
        return maxPrice;
    }

}
record Pair(int price, int timeStamp){}
