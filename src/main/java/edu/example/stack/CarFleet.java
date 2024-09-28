package edu.example.stack;

import java.util.*;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        if(target < 0 || position == null || position.length == 0 || speed == null || speed.length == 0) {
            throw new IllegalArgumentException();
        }

        List<double[]> pairs = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            pairs.add(new double[]{position[i], speed[i]});
        }

        // Sort the pairs list by position in descending order
        Collections.sort(pairs, (a, b) -> Double.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (double[] pair : pairs) {
            double pos = pair[0];
            double spd = pair[1];
            double time = (target - pos) / spd;

            // Push the time onto the stack
            stack.push(time);

            // Check if the last two cars would form a fleet
            if (stack.size() >= 2 && stack.get(stack.size() - 1) <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
