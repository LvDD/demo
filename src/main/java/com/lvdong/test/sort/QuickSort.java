package com.lvdong.test.sort;

/**
 * Created by lvdong on 2017/5/17.
 */
public class QuickSort {
    private static int change = 0;

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7, -1, 4, 2, 1, 34, 5, 6, 9, -3, 6, 8, 7, 13, -4, -2, 4};
        ArrayUtils.printArray(data);
        quickSort(data, 0, data.length - 1);
        System.out.println("排序后的数组：");
        ArrayUtils.printArray(data);
        System.out.println("交换次数：" + change);
    }

    private static void quickSort(int[] data, int start, int end) {
        if (start >= end) return;
        int temp;
        int base = data[start];
        int i = start, j = end;
        do {
            while (i < end && data[i] < base) i++;
            while (j > start && data[j] > base) j--;
            if (i <= j) {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
                change++;
            }
        } while (i <= j);
        if (i < end) quickSort(data, i, end);
        if (j > start) quickSort(data, start, j);
    }
}
