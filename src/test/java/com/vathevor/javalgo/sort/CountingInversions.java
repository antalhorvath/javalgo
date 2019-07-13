package com.vathevor.javalgo.sort;

/*
 * In an array, arr, the elements at indices 'i' and 'j' (where i < j)
 * form an inversion if arr[i] > arr[j].
 * In other words, inverted elements arr[i] and arr[j] are considered to be out of order.
 * To correct an inversion, we can swap adjacent elements.
 *
 * For example, consider the dataset arr=[2,4,1]
 * It has two inversions: (4,1) and (2,1)
 */
public class CountingInversions {

    /**
     * @param arr an array of integers to sort
     * @return an integer representing the number of inversions required to sort the array
     */
    static long countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static Long mergeSort(int[] arr, int start, int end) {
        long count = 0;
        if (start < end) {
            int middle = (start + end) / 2;
            count = mergeSort(arr, start, middle);
            count += mergeSort(arr, middle + 1, end);
            count += merge(arr, start, middle + 1, end);
        }
        return count;
    }

    static long merge(int[] array, int start, int middle, int end) {
        long count = 0;

        int i = start;
        int j = middle;
        int k = 0;

        int[] temp = new int[end - start + 1];
        while ((i <= middle - 1) && (j <= end)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count = count + (middle - i);
            }
        }

        while (i <= middle - 1) {
            temp[k++] = array[i++];
        }

        while (j <= end) {
            temp[k++] = array[j++];
        }

        for (i = start; i <= end; i++) {
            array[i] = temp[i - start];
        }

        return count;
    }
}
