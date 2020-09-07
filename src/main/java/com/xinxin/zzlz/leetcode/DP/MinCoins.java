package com.xinxin.zzlz.leetcode.DP;

import java.util.Arrays;

/**
 * @Description: 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * // coins 中是可选硬币面值，amount 是目标金额
 * int coinChange(int[] coins, int amount);
 * @Date: 2020/9/3
 * @Version: 1.0
 */
public class MinCoins {
    // coins 中是可选硬币面值，amount 是目标金额
    public static  int coinChange(int[] coins, int amount){
        // 数组大小为 amount + 1，初始值也为 amount + 1, 索引代表金额，value代表需要的硬币数量
        //dp[i] = x表⽰，当⽬标⾦额为i时，⾄少需要x枚硬币
        int[] dp = new int[amount+1];
//        初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i=1,len = dp.length; i< len; i++){
            for(int coin: coins){
                if (i-coin < 0) continue;
                dp[i] = min(dp[i], 1+dp[i-coin]);
            }
        }
        return (dp[amount] == amount+1)? -1 : dp[amount];
    }

    //返回较小值，相等时返回b
    public static int min(int a, int b){
        return  a < b? a : b;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,17));
        System.out.println();
    }

}
