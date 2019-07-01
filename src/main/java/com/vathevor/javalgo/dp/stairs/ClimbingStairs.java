package com.vathevor.javalgo.dp.stairs;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 * Example:
 *      Input: 3
 *      Output: 3
 *      Explanation: There are three ways to climb to the top.
 *      1. 1 step + 1 step + 1 step
 *      2. 1 step + 2 steps
 *      3. 2 steps + 1 step
 */
public interface ClimbingStairs {

    int climbStairs(int n);
}
