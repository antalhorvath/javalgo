package com.vathevor.javalgo.array;

/*
 * A left rotation operation on an array shifts each of the array's elements unit to the left.
 * For example, if left rotations are performed on array [1,2,3,4,5],
 * then the array would become [3,4,5,2,1].
 *
 * Complete the function rotLeft in the editor below.
 * It should return the resulting array of integers.
 */
public class LeftRotation {

    /**
     *
     * @param a array of integers
     * @param d d number of rotations
     * @return
     */
    static int[] rotLeft(int[] a, int d) {
        int[] source = a;
        int[] result = new int[a.length];

        int tailLength = source.length - d;
        int leadLength = d;

        // start the new array with the last of the source
        int sourceStartPosition = d;
        int resultStartPosition = 0;
        System.arraycopy(source, sourceStartPosition, result, resultStartPosition, tailLength);

        // end the new array with the front elements of the source
        sourceStartPosition = 0;
        resultStartPosition = tailLength;
        System.arraycopy(source, sourceStartPosition, result, resultStartPosition, leadLength);
        return result;
    }
}
