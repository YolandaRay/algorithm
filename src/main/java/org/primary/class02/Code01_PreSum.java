package org.primary.class02;

public class Code01_PreSum {
    /**
     * 1、bubble、select、insert
     * 2、对数器
     * 3、递归的和
     */
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 9, 4, 7, 5, 1, 6, 8};
//        bubbleSort(arr1);
//        selectSort(arr1);
//        insertSort(arr1);
//        System.out.println("bubbleSort：" + Arrays.toString(arr1));
        System.out.println(factorialSum(1));
    }

    /*
    给定一个参数N，返回：  1! + 2! + 3! + 4! + … + N!   的结果
    1、暴力计算
    1 1
    2 1+2=3
    3 1+2+3*2*1=9
    4 1+2+3*2*1+4*3*2*1=33
    5 1+2+3*2*1+4*3*2*1+5*4*3*2*1=153
    n  pre + n*(n-1)*  ... *1
    2、后一个值等于前一个值*n
     */
    public static int factorialSum(int n) {
        if (n == 0 || n == 1) return n;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + factorial(i);
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return n;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
        }
        return sum;
    }


    /*
    画面感：
        一次冒一个最大数，最外层循环n，n-1，n-2
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int end = n - 1; end >= 0; end--) {
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /*
    画面感：
        一次选出一个最小值，放到第一个位置。
        {3, 2, 9, 4, 7, 5, 1, 6, 8}
        minValueIndex = 0
        arr[0],arr[1]对比
     */
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

    public static void insertSort1(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            int newIndexNum = end;
            while (newIndexNum - 1 >= 0 && arr[newIndexNum - 1] > arr[newIndexNum]) {
                swap(arr, newIndexNum - 1, newIndexNum);
                newIndexNum--;
            }
        }

    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int newIndexNum = i;
            while (newIndexNum - 1 >= 0 && arr[newIndexNum - 1] > arr[newIndexNum]) {
                swap(arr, newIndexNum - 1, newIndexNum);
                newIndexNum--;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
