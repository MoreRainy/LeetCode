package Array;

public class LeetCode977有序数组的平方 {
    //    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//    示例 1：
//    输入：nums = [-4,-1,0,3,10]
//    输出：[0,1,9,16,100]
//    解释：平方后，数组变为 [16,1,0,9,100]
//    排序后，数组变为 [0,1,9,16,100]
//
//    示例 2：
//    输入：nums = [-7,-3,2,3,11]
//    输出：[4,9,9,49,121]
//
//
//    提示：
//
//            1 <= nums.length <= 104
//            -104 <= nums[i] <= 104
//    nums 已按 非递减顺序 排序
//
//
//    进阶：
//
//    请你设计时间复杂度为 O(n) 的算法解决本问题
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] arr = sortedSquares(nums);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        //数组两侧为绝对值最大值，故从数组首尾遍历数组逆序实现新数组更为合适
        int index = nums.length - 1;
        int l = 0;
        int r = index;
        int[] arr = new int[index + 1];
        while (l <= r) {
            if (Math.abs(nums[l]) >= Math.abs(nums[r])) {
                arr[index--] = nums[l] * nums[l];
                l++;
            } else {
                arr[index--] = nums[r] * nums[r];
                r--;
            }
        }

        return arr;
    }
}
