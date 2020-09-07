package com.xinxin.zzlz.leetcode.DP;

/**
 * @Description:斐波那契数列（Fibonacci sequence），
 * 又称黄金分割数列、因数学家莱昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波那契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 3，n ∈ N*）
 * @Date: 2020/9/3
 * @Version: 1.0
 */
public class FibonacciSequence {

    /**
     * 递归实现 算法复杂度O(2^n)
     * @return
     */
    @Deprecated
    int fib_recursion(int N) {
        if (N == 1 || N == 2) return 1;
        return fib_recursion(N - 1) + fib_recursion(N - 2);
    }

    public int fib_memo(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[N+1];
        // 初始化最简情况
        return helper(memo, N);
    }
    // 备忘录 自顶向下
    int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) +
                helper(memo, n - 2);
        return memo[n];
    }
    // 动态规划 利用DP table 自底向上 空间复杂度 O(n)
    @Deprecated
    int fibDP(int N) {
        int[] dp = new int[N+1];
        // base case
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N];
    }

    public static int fib_DP(int n){
        if(n==2|| n==1)
            return 1;
        int prev = 1,curr = 1;
        for (int i = 3;i<=n; i++){
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib_DP(4));
    }
}
