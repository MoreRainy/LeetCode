package BinarySearch;

import java.util.Arrays;

public class LeetCode34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
//        给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
//
//
//
//        示例 1：
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        int[] arr = {5, 7, 7, 8, 8, 10};
//        int target = 8;

//        示例 2：
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//        int[] arr = {5,7,7,8,8,10};
//        int target = 6;

//        示例 3：
//        输入：nums = [], target = 0
//        输出：[-1,-1]
//        int[] arr = {};
//        int target = 0;

//        示例 4：
//        输入：nums = [1], target = 1
//        输出：[0,0]
        int[] arr = {1};
        int target = 1;

        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{left(nums, target), right(nums, target)};
    }

    public static int left(int[] nums, int target) {
        int front = 0;
        int rear = nums.length - 1;
        int flag = -1;

        while (rear - front >= 0) {
            int mid = (front + rear) >>> 1;

            if (nums[mid] > target) {
                rear = mid - 1;
            } else if (nums[mid] < target) {
                front = mid + 1;
            } else {
                //继续向左找
                flag = mid;
                rear = mid - 1;
            }
        }
        return flag;
    }

    public static int right(int[] nums, int target) {
        int front = 0;
        int rear = nums.length - 1;
        int flag = -1;

        while (rear - front >= 0) {
            int mid = (front + rear) >>> 1;

            if (nums[mid] < target) {
                front = mid + 1;
            } else if (nums[mid] > target) {
                rear = mid - 1;
            } else {
                //继续向右找
                flag = mid;
                front = mid + 1;
            }
        }
        return flag;
    }
}
