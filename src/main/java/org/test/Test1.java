package org.test;

public class Test1 {
    public static void main(String[] args) {
        int[] pack = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = allocate(pack, 5);
        System.out.println(result);
//        int[] arr = {1,2,3,4,-8};
//        System.out.print(kPart(arr,0,arr.length - 1,3));
        System.out.print(kPart(pack,0,pack.length - 1,5));

    }
    public static int kPart(int[] arr, int start,int end, int k) {
        if (k == 1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            return sum;
        }
        if ((end - start + 1) == k) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= end; i++) {
                if (arr[i] > max) {
                    max = arr[i];

                }
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            //  System.out.println("进入该循环");
            int sum = 0;
            for (int j = start; j <= i; j++) {
                sum += arr[j];
            }
            int larger = sum > kPart(arr, i + 1, end, k - 1) ? sum : kPart(arr, i + 1, end, k - 1);
            if (larger < min) {
                min = larger;

            }
        }
        return min;

    }/**/
    public static int allocate(int[] pack, int n) {
        /**
         * 边界考虑：
         *      n <= 0 不合法
         *      n == 1 pack只和
         *      n == pack.length pack最大值
         */
        if (null == pack || n == 0) {
            return 0;
        }
//        pack.length
        return 0;
    }
}
