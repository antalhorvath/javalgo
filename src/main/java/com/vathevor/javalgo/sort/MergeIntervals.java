package com.vathevor.javalgo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *      Input: [[1,3],[2,6],[8,10],[15,18]]
 *      Output: [[1,6],[8,10],[15,18]]
 *      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    private static class Interval {
        int start;
        int end;

        static Interval of(int start, int end) {
            Interval interval = new Interval();
            interval.start = start;
            interval.end = end;
            return interval;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        List<Interval> intervalsSortedByStart = Arrays.stream(intervals)
                .map(interval -> Interval.of(interval[0], interval[1]))
                .sorted(Comparator.comparing(interval -> interval.start))
                .collect(Collectors.toList());

        List<Interval> mergedIntervals = new ArrayList<>();
        Interval lastInterval = null;
        for (Interval interval : intervalsSortedByStart) {

            if (lastInterval == null) {
                lastInterval = interval;
                mergedIntervals.add(lastInterval);
                continue;
            }

            if (interval.start <= lastInterval.end) {
                lastInterval.end = Math.max(interval.end, lastInterval.end);
            } else {
                lastInterval = interval;
                mergedIntervals.add(lastInterval);
            }
        }

        return mergedIntervals.stream()
                .map(interval -> new int[]{interval.start, interval.end})
                .toArray(int[][]::new);
    }
}
