package com.xinxin.zzlz.leetcode.DP;

import java.util.Arrays;

/**
 * @Description: 最长递增子序列（Longest Increasing Subsequence，简写LIS）
 * @Date: 2020/9/8
 * @Version: 1.0
 */
public class LIS {
    public static int lis(int[] sequence){
        if (sequence==null || sequence.length==0 ) return 0;
        int[] dp = new int[sequence.length];//dp[i]表示以sequence[i]结尾的最长递增子序列长度
        //以sequence[i]结尾的递增子序列最小为本身，长度为1，所以将dp数组初始化初值为1
        Arrays.fill(dp,1);
        //时间复杂度O(n^2)
        for (int i = 1; i < sequence.length; i++){
            for(int j = 0; j < i; j++){
                if(sequence[i] > sequence[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int result =0;
        for (int i=0;i<dp.length;i++){
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={1,4,3,5,5,5,28,10,6,14};
        int lis = lis(nums);
        System.out.println(lis);
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums){
        int[] top = new int[nums.length];
        //牌堆数初始化为0
        int piles =0;
        for (int i =0;i<nums.length;i++){
            //需要处理的扑克牌
            int poker = nums[i];
            /************搜素左侧边界的二分查找****************/
            int left =0, right = piles ;
            while (left < right){
                int mid = (left+right)/2;
                if(top[mid] < poker){ //寻找mid右侧
                    left = mid + 1;
                }else if(top[mid] > poker){//右侧开放 right=mid
                    right = mid;
                }else  {
                    right = mid;
                }

            }
            /*********************************/
            //没找到合适的牌堆，新建一堆
            if(left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        //牌堆数为LIS长度
        return piles;
    }
}
