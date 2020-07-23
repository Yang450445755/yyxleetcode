package com.yyx.leetcode.dynamic_programming;

/**
 * @author Aaron-yang
 * @date 2020/7/23 15:26
 */
public class AliTest {

    /**
     *
     * 1. 有n级台阶，每次可以上1级或者2级，那么一共有多少种不同的走法可以上去？请用代码实际编码解决。
     * 第一题思路:
     *  n     way
     *  1       1
     *  2       2
     *  3       3
     *  4       5
     *  5       8
     *
     *  走到n阶的way   等于 走到n-1的way + n-2的way
     *  因为你要走到n阶   必须要先走到n-1 跨一步  或者走到n-2跨两步
     */

    public static void main(String[] args) {
        long i = test1(5);
        System.out.println(i);
        long i1 = test2(5);
        System.out.println(i1);
    }

    private static long test1(int n) {
        //循环    从小算到大
        long[] ways = new long[n+2];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }

    private static long test2(long n) {
        //递归     从大算到小
        //n太大   层级太深  不好  建议循环
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        return test2(n-1)+test2(n-2);
    }


}
