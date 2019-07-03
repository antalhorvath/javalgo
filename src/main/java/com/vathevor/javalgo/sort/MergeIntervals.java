package com.vathevor.javalgo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *      Input: [[1,3],[2,6],[8,10],[15,18]]
 *      Output: [[1,6],[8,10],[15,18]]
 *      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] lastInterval = intervals[0];
        result.add(lastInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= lastInterval[1])
                lastInterval[1] = Math.max(interval[1], lastInterval[1]);
            else {
                lastInterval = interval;
                result.add(lastInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
