package org.primary.class02;

public class Code03_Comp {
    public static void main(String[] args) {
        int maxLen = 10;
        int maxValue = 1000;
        int testTime = 1000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = lenRandomValueRandom(maxLen, maxValue);
//            int[] arr2 = copyArray(arr1);
            selectSort(arr1);
            if (!isSorted(arr1)) {
                System.out.println("排序错了");
            }

        }

    }

    private static boolean isSorted(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (max > arr[i]) return false;
        }
        return true;
    }

    private static int[] copyArray(int[] arr) {
        int len = arr.length;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    //返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
    //长度随机，数值随机
    public static int[] lenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) Math.random() * maxLen;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = (int) Math.random() * maxValue;
        }
        return result;
    }


    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                minValueIndex = (arr[j] < arr[minValueIndex]) ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
