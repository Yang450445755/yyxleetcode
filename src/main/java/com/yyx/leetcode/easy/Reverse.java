package com.yyx.leetcode.easy;

import org.junit.Test;

/**
 * @author Aaron-yang
 * @date 2021/8/3 17:33
 */
public class Reverse {

    @Test
    public void test () throws Exception {
        System.out.println(reverse_1(1534236469));
        System.out.println(reverse_2(1534236469));
        System.out.println(reverse_2(-15342));
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * 示例 1：
     * 输入：x = 123
     * 输出：321
     *
     * 示例 2：
     * 输入：x = -123
     * 输出：-321
     * @param x
     * @return
     */
    public int reverse_1(int x) {
        String intString = Integer.toString(x);
        long res = 0l;
        if(intString.startsWith("-")){
            String numString = intString.split("-")[1];
            res = - Long.parseLong(new StringBuilder(numString).reverse().toString());
        }else {
            res = Long.parseLong(new StringBuilder(intString).reverse().toString());

        }
        if( res<-2147483648 || res>2147483647 ){
            return 0;
        }
        return (int) res;
    }

    public int reverse_2(int x){
        /**
         * // 弹出 x 的末尾数字 digit
         * digit = x % 10
         * x /= 10
         * // 将数字 digit 推入 rev 末尾
         * rev = rev * 10 + digit
         */

        int res = 0;
        while (x!=0){
            if( res<Integer.MIN_VALUE/10 || res>Integer.MAX_VALUE/10 ){
                return 0;
            }
            int digit = x % 10;
            res = res * 10 + digit;

            x = x/10;
        }

        return res;
    }

}
