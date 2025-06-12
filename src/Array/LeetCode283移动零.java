package Array;

public class LeetCode283移动零 {
    //    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
//    示例 1:
//    输入: nums = [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//
//    示例 2:
//    输入: nums = [0]
//    输出: [0]
//
//
//    提示:
//
//            1 <= nums.length <= 104
//            -231 <= nums[i] <= 231 - 1
//
//
//    进阶：你能尽量减少完成的操作次数吗？
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //思路：fast遍历数组前移非零数，slow用于改变数组。fast到数组尾部后，slow开始到数组尾全部赋值0
        //1.前移非零数
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }

        //2.赋值0
        while (slow < nums.length) {
            nums[slow++] = 0;
        }

    }
}
