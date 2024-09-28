package edu.example.binarysearch;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Integer.MIN_VALUE;
        int speed = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // calculate possible values from given speed
        int left = 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int hourSpent = 0;
            for(int pile : piles) {
                hourSpent += Math.ceil((pile / mid));
            }
            if(hourSpent < h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
