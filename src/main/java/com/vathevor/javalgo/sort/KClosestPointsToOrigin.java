package com.vathevor.javalgo.sort;

import java.util.Arrays;

/*
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 *      The distance between (1, 3) and the origin is sqrt(10).
 *      The distance between (-2, 2) and the origin is sqrt(8).
 *      Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 *      We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}
