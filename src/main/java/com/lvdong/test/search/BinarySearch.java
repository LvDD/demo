package com.lvdong.test.search;

/**
 * 二分查找
 * Created by lvdong on 2017/5/19.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-4, -3, -2, -1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 9, 9, 13, 34};

        int key = 1;
        int i = binarySearch(array, key);
        System.out.println(key + "的位置：" + i);

        key = 1;
        int j = binSearch(array, 0, array.length - 1, key);
        System.out.println(key + "的位置：" + j);
    }


    /**
     * 非递归二分查找算法
     *
     * @param array 整型数组
     * @param key   需要比较的数
     * @return 返回值.
     */
    private static int binarySearch(int[] array, int key) {
        //第一个位置.
        int start = 0;
        //最高位置.数组长度-1,因为下标是从0开始的.
        int end = array.length - 1;
        //当start"指针"和high不重复的时候.
        while (start <= end) {
            //中间位置计算,start+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2
            int middle = (start + end) / 2;
            //与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.
            if (key == array[middle]) {
                return middle;
                //如果小于的话则移动最高层的"指针"
            } else if (key < array[middle]) {
                end = middle - 1;
                //移动最低的"指针"
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方法实现二分查找法.
     *
     * @param array 数组
     * @param start 数组第一位置
     * @param end   最高
     * @param key   要查找的值.
     * @return 返回值.
     */
    private static int binSearch(int[] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (key == array[mid]) {
            return mid;
        }

        if (key < array[mid]) {
            //移动low和high
            return binSearch(array, start, mid - 1, key);
        } else {
            return binSearch(array, mid + 1, end, key);
        }
    }
}
