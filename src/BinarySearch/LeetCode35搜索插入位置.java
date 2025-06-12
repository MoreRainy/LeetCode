package BinarySearch;

public class LeetCode35搜索插入位置 {
    public static void main(String[] args) {
//        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//        请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
//        示例 1:
//        输入: nums = [1,3,5,6], target = 5
//        输出: 2
//        int[] arr = {1, 3, 5, 6};
//        int target = 5;

//        示例 2
//        输入: nums = [1,3,5,6], target = 2
//        输出: 1
//        int[] arr = {1, 3, 5, 6};
//        int target = 2;

//        示例 3:
//        输入: nums = [1,3,5,6], target = 7
//        输出: 4
//        int[] arr = {1, 3, 5, 6};
//        int target = 7;

//        示例 4:
//        输入: nums = [1,3,5,6], target = 4
//        输出: 2
        int[] arr = {1, 3, 5, 6};
        int target = 4;

        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int front = 0;
        int rear = nums.length;

        //特殊判断，目标值在区间外
        if (target > nums[rear - 1]) return rear;
        if (target < nums[front]) return front;

        //二分查找
        //此处不需要“=”是因为尾哨兵不是判断目标
        while (front < rear) {
            //去尾法取中间值（仅限于正数）
            int mid = (front + rear) >>> 1;

            if (nums[mid] > target)
                rear = mid;
            else if (nums[mid] < target)
                front = mid + 1;
            else
                return mid;
        }
        //循环结束仍未找到目标值，执行插入操作
        return front;
    }
}
