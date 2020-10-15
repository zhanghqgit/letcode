package com.zhq.test;

/**
 * @author zhanghengqiang
 * @date 2020/10/15
 * @time 2:23 下午
 * @email zhanghengqiang@jd.com
 */

public class ReverseSignedInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > (Integer.MAX_VALUE / 10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
