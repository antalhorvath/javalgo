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
        int numberOfBribes = 0;
        for (int i = 0; i < q.length; i++) {
            int currentIndexOfPerson = q[i];
            int originalIndexOfPerson = i + 1;
            int numberOfBribesDoneByPerson = currentIndexOfPerson - originalIndexOfPerson;
            if (2 < numberOfBribesDoneByPerson) {
                return "Too chaotic";
            }
            int twoPositionsBeforeTheCurrentIndexOfPerson = Math.max(0, currentIndexOfPerson - 2);
            for (int j = twoPositionsBeforeTheCurrentIndexOfPerson; j < i; j++) {
                int indexOfPersonBeforeThem = q[j];
                if (currentIndexOfPerson < indexOfPersonBeforeThem) {
                    numberOfBribes++;
                }
            }
        }
        return String.valueOf(numberOfBribes);
    }
}


