package org.test;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 9, 4, 7, 5, 1, 6, 8};
        int[] arr2 = {3, 2, 9, 4, 7, 5, 1, 6, 8};
        int[] arr3 = {3, 2, 9, 4, 7, 5, 1, 6, 8};
        selectSort(arr1);
        System.out.println("selectSort：" + Arrays.toString(arr1));
        bubbleSort(arr2);
        System.out.println("bubbleSort：" + Arrays.toString(arr2));
        insertSort(arr3);
        System.out.println("insertSort：" + Arrays.toString(arr3));
    }

    private static void insertSort(int[] arr) {
        int len = arr.length;
        if (arr == null || len < 2) return;
        for (int i = 1; i < len; i++) {
            int newNumIndex = i;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }

        }
    }

    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        if (arr == null || len < 2) return;
        for (int end = len - 1; end >= 0; end--) {
            for (int i = 0; i < end - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void selectSort(int[] arr) {
        int len = arr.length;
        if (arr == null || len < 2) return;
        for (int i = 0; i < len; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < len; j++) {
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
