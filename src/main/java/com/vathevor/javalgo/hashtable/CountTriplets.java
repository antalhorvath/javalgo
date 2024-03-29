package com.vathevor.javalgo.hashtable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You are given an array and you need to find number of tripets of indices (i,j,k)
 * such that the elements at those indices are in geometric progression
 * for a given common ratio 'r' and  i < j < k.
 *
 * Return the count of triplets that form a geometric progression.
 *
 * Sample Input 0
 *      4 2
 *      1 2 2 4
 * Sample Output 0
 *      2
 * Explanation 0
 *      There are 2 triplets in satisfying our criteria, whose indices are (0,1,3) and (0,2,3)
 *
 * Sample Input 1
 *      6 3
 *      1 3 9 9 27 81
 * Sample Output 1
 *      6
 */
public class CountTriplets {

    /**
     * @param arr an array of integers
     * @param r   the common ratio
     * @return count of triplets
     */
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        long count = 0;
        for (Long number : arr) {
            if (number % r == 0) {
                long key = number / r;

                if (counter.containsKey(key)) {
                    count += counter.get(key);
                }

                if (potential.containsKey(key)) {
                    Long originalValue = counter.getOrDefault(number, 0L);
                    long incrementValue = potential.get(key);
                    counter.put(number, originalValue + incrementValue);
                }
            }

            potential.put(number, potential.getOrDefault(number, 0L) + 1);
        }
        return count;
    }
}
