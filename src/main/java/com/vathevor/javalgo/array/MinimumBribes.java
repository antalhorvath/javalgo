package com.vathevor.javalgo.array;

/*
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
 * There are a number of people queued up,
 * and each person wears a sticker indicating their initial position in the queue.
 * Initial positions increment by 1 from 1 at the front of the line to at the back.
 *
 * Any person in the queue can bribe the person directly in front of them to swap positions.
 * If two people swap positions,
 * they still wear the same sticker denoting their original places in line.
 * One person can bribe at most two others.
 */
public class MinimumBribes {

    static String getMinimumBribes(int[] q) {
        int minimumBribes = 0;
        for (int i = 0; i < q.length; i++) {
            int shift = q[i] - (i + 1);
            if (2 < shift) {
                return "Too chaotic";
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[i] < q[j]) {
                    minimumBribes++;
                }
            }
        }
        return String.valueOf(minimumBribes);
    }
}


