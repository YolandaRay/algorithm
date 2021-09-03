package org.test;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        char c = s.charAt(0);
//        boolean booleanStr = t.contains(Character.toString(c));
//        System.out.println(booleanStr);
        /*
        Q47：给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
        注意：
        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
        如果 s 中存在这样的子串，我们保证它是唯一的答案。
        示例 1：
        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        示例 2：
        输入：s = "a", t = "a"
        输出："a"
        示例 3:
        输入: s = "a", t = "aa"
        输出: ""
        解释: t 中两个字符 'a' 均应包含在 s 的子串中，
        因此没有符合条件的子字符串，返回空字符串。
        你能设计一个在 o(n) 时间内解决此问题的算法吗？
         */
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

    public static String findSub(String s, String t) {
        //验证输入合法性
        if (null == s || null == t || "".equals(s) || "".equals(t)) {
            return "input not illegal";
        }
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (t.contains(Character.toString(s.charAt(i)))) {
//                c.
            }
        }

        return "";
    }

    /*
      选择排序
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) System.out.println("Parameters are not legitimate");
        int minIndex, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            /*
            i =0 j=1 minIndex =0  arr[j] = 2 arr[minIndex]=3   minIndex = j=1
            i =0 j=2 minIndex =1  arr[j] = 9 arr[minIndex]=2   minIndex = j=1
            i =0 j=6 minIndex =1  arr[j] = 1 arr[minIndex]=2   minIndex = j=6
             */
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

        }
    }

    /*
      冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) System.out.println("Parameters are not legitimate");
        for (int i = 0; i < arr.length - 1; i++) {
//            System.out.println(Arrays.toString(arr));
            //一次冒泡，冒出一个最大值，需要冒n-1次
            for (int j = 0; j < arr.length - i - 1; j++) {
                int temp;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }

    /*
      插入排序
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) System.out.println("Parameters are not legitimate");
        int preIndex, current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }

}
