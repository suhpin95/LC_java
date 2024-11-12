package edu.example.graphs;

import java.util.Arrays;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;
        for(int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(price, price.length);
            for(int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int weight = flight[2];
                if (price[start] != Integer.MAX_VALUE && price[start] + weight < temp[end]) {
                    temp[end] = price[start] + weight;
                }
            }
            price = temp;
        }
        return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }

    public static void main(String[] args) {
        CheapestFlight cheapestFlight = new CheapestFlight();

        int[][] flights = {  {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        cheapestFlight.findCheapestPrice(4, flights, 0, 2, 1);
    }
}
