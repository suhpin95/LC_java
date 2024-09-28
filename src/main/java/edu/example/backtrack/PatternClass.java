//package edu.example.backtrack;
//
//import java.util.HashMap;
//
//public class PatternClass {
//    public static int fibonacci(int n) {
//        if (n == 1 || n == 2)        return 1;    return fibonacci(n-1) + fibonacci(n-2);
//    }
//    public static int getFib(int n) {    return optimizedFib(n, new HashMap<Integer, Integer>());}
//    public static int optimizedFib(int n, HashMap<Integer, Integer> memo) {
//        if (n == 1 || n == 2)        return 1;
//        if (memo.containsKey(n)) ;
//    }
//    public static float power(int x, int power) {
//        if (x == 0 && power <= 0) {        throw new ArithmeticException("undefined");    }
//        float result = positivePower(Math.abs(x), Math.abs(power));
//
//        if (x < 0 && power % 2 != 0)
//            result = -1 * result;
//        return result;
//    }
//    public static int positivePower(int x, int power) {    if (power == 0)        return 1;    if (power == 1)        return x;    int halfPower = positivePower(x, power/2);    if (power % 2 == 0) {        return halfPower * halfPower;    } else {        return x * halfPower * halfPower;    }}