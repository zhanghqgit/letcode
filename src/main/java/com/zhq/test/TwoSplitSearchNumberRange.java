package com.zhq.test;

import java.util.Arrays;

/**
 * @author zhanghengqiang
 * @date 2020/10/15
 * @time 6:26 下午
 * @email zhanghengqiang@jd.com
 */

public class TwoSplitSearchNumberRange {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,3,3,3,4,6,7};
        useForCircle(array, 3);
        findBound(array, 3, 0, array.length -1);
    }



    public static void findBound(int[] array, int number, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] == number) {
            boolean foundRight = mid == array.length -1 || array[mid + 1] > number;
            boolean foundLef = mid == 0 || array[mid - 1] < number;
            if (foundLef || foundRight) {

                if (foundRight) {
                    System.out.println("查找到最大边界:" + mid);
                }
                if (foundLef) {
                    System.out.println("查找到最小边界:" + mid);
                }
                return;
            }
        }

        if (start >= end) {
            return;
        }

        findBound(array, number, start, mid);

        findBound(array, number, mid + 1, end);
    }

    /**
     * 使用遍历循环方案
     * @param array
     * @param number
     */
    public static void useForCircle(int[] array, int number) {
        int min = array.length;
        int max = 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == number) {
                if (i < min) {
                    min = i;
                }
                if (i > max) {
                    max = i;
                }
            }
        }

        System.out.println(String.format("查找%d在数组%s中的上下界为[%d,%d]",
                number, Arrays.toString(array), min, max));
    }
}
