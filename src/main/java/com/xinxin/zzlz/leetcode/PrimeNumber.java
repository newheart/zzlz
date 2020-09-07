package com.xinxin.zzlz.leetcode;

import java.util.Arrays;

/**
 * @Description: 素数（质数）相关
 * 性质
 * ·质数只有两个因数：1和本身
 * ·任何大于1的自然数，要么本身是质数，要么可以分解为几个质数之积，且这种分解是唯一的
 * ·质数的个数是无限多的
 * ·若n为正整数，在n²到(n+1)²之间至少有一个质数
 * ·若n为大于等于2的正整数，则n到n!之间至少有一个质数
 * ·若质数p为不超过n(n≥4)的最大质数，则p＞n/2
 * ·所有大于10的质数中，个位数只有1，3，7，9
 * @Date: 2020/8/27
 * @Version: 1.0
 */
public class PrimeNumber {
    /**
     * 返回区间[start,bound)之间素数个数
     * @param start
     * @param bound
     * @return
     */
    public static int countPrimes(int start,int bound){

        return 0;
    }

    /**
     * 返回[2,n) 之间的素数个数
     * 某一范围的质数个数。埃拉托色尼筛选法（The Sieve of Eratosthenes），简称埃氏筛法，是解决这一问题的常见算法
     * @param n
     * @return
     */
    public static int countPrimes(int n){
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim,true);
        for(int i = 2; i*i < n ; i++) {
            if (isPrim[i]) {
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;
            }
        }
        int count =0;
        for(int i=2;i<n;i++){
//            System.out.println(i + " isPrim: "+ isPrim[i]);
            if (isPrim[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(2020));
        int compareTo = "20200721".compareTo("20200630");
        System.out.println(compareTo);
    }
}
