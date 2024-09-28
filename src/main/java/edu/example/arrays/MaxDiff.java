package edu.example.arrays;

public class MaxDiff {
    public int getMaxProfit(int[] stockPrices){
        int len = stockPrices.length;
        if(len == 0) return 0;
        int maxProfit = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            minValue = Math.min(minValue, stockPrices[i]);
            int profit = stockPrices[i] - minValue;
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
    public int getMaxProfit2(int[] stockPrices){
        int len = stockPrices.length;
        if(len == 0 || len == 1) return 0;

        int maxProfit = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int[] bestUntilI = new int[len];
        int[] bestFromI = new int[len];
        for(int i = 0; i < len; i++){
            minValue = Math.min(stockPrices[i], minValue);
            int profit = stockPrices[i] - minValue;
            if(profit > maxProfit) maxProfit = profit;
            bestUntilI[i] = maxProfit;
        }
        maxProfit = Integer.MIN_VALUE;
        minValue = Integer.MAX_VALUE;
        for(int i = len-1; i > 0; i--){
            minValue = Math.min(minValue, stockPrices[i]);
            int profit = stockPrices[i] - minValue;
            if(profit > maxProfit) maxProfit = profit;
            bestFromI[i] = maxProfit;
        }
        int result = 0;
        for(int i = 0; i < len; i++){
            int maxSecondTrade = ( i+1 < len )? bestFromI[i+1] : 0;
            result = Math.max(result, bestUntilI[i] + maxSecondTrade);
        }
        return result;
    }
}
