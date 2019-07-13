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
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    static Long mergeSort(int[] arr, int[] temp, int start, int end) {
        long count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count = mergeSort(arr, temp, start, mid);
            count += mergeSort(arr, temp, mid + 1, end);
            count += merge(arr, temp, start, mid + 1, end);
        }
        return count;
    }

    static int merge(int[] arr, int[] temp, int start, int middle, int end) {
        int count = 0;
        int i = start;
        int j = middle;
        int k = start;

        while ((i <= middle - 1) && (j <= end)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count = count + (middle - i);
            }
        }

        while (i <= middle - 1) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
