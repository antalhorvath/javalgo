package com.vathevor.javalgo.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        if (r == 1 && arr.stream().distinct().count() == 1) {
            return binomialCoeff(arr.size(), 3);
        }

        int count = 0;
        Map<Long, List<Integer>> valuesWithIdexes = arr.stream()
                .distinct()
                .collect(Collectors.toMap(Function.identity(), value -> {
                    int i = 0;
                    long number;
                    List<Integer> indexes = new ArrayList<>();
                    do {
                        number = arr.get(i);
                        if (value.equals(number)) {
                            indexes.add(i);
                        }
                        i++;
                    } while (i < arr.size() && number <= value);
                    return indexes;
                }));

        for (int i = 0; i < arr.size() - 2; i++) {
            long ni = arr.get(i);
            long nj = ni * r;
            long nk = nj * r;

            if (r == 1) {
                int currentIndex = i;
                long numberOfIdenticalValue = valuesWithIdexes.get(nj)
                        .stream()
                        .filter(index -> currentIndex < index)
                        .count();
                count += (numberOfIdenticalValue * (numberOfIdenticalValue - 1)) / 2;
            } else {
                List<Integer> indexesOfNj = valuesWithIdexes.get(nj);
                List<Integer> indexesOfNk = valuesWithIdexes.get(nk);
                if (indexesOfNj != null && indexesOfNk != null) {
                    long countOfNj = indexesOfNj.size();
                    long countOfNk = indexesOfNk.size();
                    count += countOfNj * countOfNk;
                }
            }
        }

        return count;
    }


    static long binomialCoeff(int n, int k) {

        long[][] C = new long[n + 1][k + 1];
        int i, j;

        // Calculate  value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= min(i, k); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;

                    // Calculate value using previously stored values
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        return C[n][k];
    }

    static long min(int a, int b) {
        return (a < b) ? a : b;
    }

}
