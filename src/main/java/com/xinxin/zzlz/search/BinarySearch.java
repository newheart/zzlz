package com.xinxin.zzlz.search;

/**
 * @Description: 二分查找
 * @Date: 2020/9/21
 * @Version: 1.0
 */
public class BinarySearch {

    /**
     * 在递增数组中查找target,并返回下标
     * @param nums 递增数组
     * @param target 查找目标值
     * @return
     */
    public static int find(int[] nums , int target){
        if(nums==null || nums.length==0) return -1;
        int left = 0, right = nums.length-1;
        //查找范围[left, right] 闭区间
        while (left <= right ){
            int mid =  left + (right - left)/2;
           if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right =  mid - 1;
            }else if(nums[mid] == target){
               //直接返回
                return  mid;
            }
        }
        return  -1;

    }

    /**
     * 寻找左侧边界的⼆分搜索, 逐步收紧右侧边界来查找目标值
     * @param nums
     * @param target
     * @return 左侧边界的target目标值下标
     */
    public static int left_bound(int[] nums , int target){
        if(nums==null || nums.length==0) return -1;
        int left = 0, right = nums.length-1;
        //搜索区间[left, right] 左右闭,终止条件 left = right+1
        while (left <= right){
            int mid = left + (right - left)/2;

            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                //区分：收紧右侧边界
                right = mid -1;
            }
        }
        //由于while的退出条件是left==right+1, 所以当target⽐nums中所有元素都⼤时,会使得索引越界.
        //最后返回结果检查越界情况
        if(left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 寻找右侧边界的⼆分搜索
     * @param nums
     * @param target
     * @return
     */
    public static int right_bound(int[] nums, int target){
        if(nums==null || nums.length==0) return -1;
        int left = 0, right = nums.length-1;
        //结束条件 left = right + 1
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] == target){
                // 不立即返回，增大【搜索区间】下界left
                left  = mid + 1;
            }
        }
        if(right < 0  || nums[right] != target){
            return -1;
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6,7,7,7,8,8};
        int target = 7;
        int index = find(nums, target);
        int left = left_bound(nums,target);
        int right = right_bound(nums,target);
        System.out.println("find index=" + index + ",left bound= " + left + ",right bound = " + right);
    }
}
