package com.vathevor.javalgo.dp.stairs;

public class BruteForceClimbingStairs implements ClimbingStairs {

    @Override
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    int climbStairs(int i, int n) {
        if (i == n) {
            return 1;
        }
        if (n < i) {
            return 0;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
