package BinarySearch;

import java.util.Arrays;

public class LeetCode704二分查找 {
    public static void main(String[] args) {
//        给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
//        写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
//
//
//        示例 1:
//        输入: nums = [-1,0,3,5,9,12], target = 9
//        输出: 4
//        解释: 9 出现在 nums 中并且下标为 4
//        int[] arr = {-1, 0, 3, 5, 9, 12};
//        int target = 9;

//        示例 2:
//        输入: nums = [-1,0,3,5,9,12], target = 2
//        输出: -1
//        解释: 2 不存在 nums 中因此返回 -1
//        int[] arr = {-1, 0, 3, 5, 9, 12};
//        int target = 2;

//        示例 3:
//        输入: nums = [5], target = 5
//        输出: 0
//        解释: 5 出现在 nums 中并且下标为 0
        int[] arr = {5};
        int target = 5;

        System.out.println(Arrays.toString(arr));

        System.out.println(search(arr, target));
    }

    //二分查找方法
    public static int search(int[] nums, int target) {
        //定义首尾哨兵
        int front = 0;
        int rear = nums.length - 1;

        //此处需要“=”是因为尾哨兵同样是判断目标
        while (front <= rear) {
            //去尾法取中间值（仅限于正数）
            int mid = (front + rear) >>> 1;

            if (nums[mid] > target)
                rear = mid - 1;
            else if (nums[mid] < target)
                front = mid + 1;
            else
                return mid;
        }
        //循环结束仍未找到目标值
        return -1;
    }
}
