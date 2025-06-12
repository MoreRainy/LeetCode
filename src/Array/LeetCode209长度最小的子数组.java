package Array;

public class LeetCode209长度最小的子数组 {
    //    给定一个含有 n 个正整数的数组和一个正整数 target 。
//
//    找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
//
//
//
//    示例 1：
//    输入：target = 7, nums = [2,3,1,2,4,3]
//    输出：2
//    解释：子数组 [4,3] 是该条件下的长度最小的子数组。
//
//    示例 2：
//    输入：target = 4, nums = [1,4,4]
//    输出：1
//
//    示例 3：
//    输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//    输出：0
//
//
//    提示：
//
//            1 <= target <= 109
//            1 <= nums.length <= 105
//            1 <= nums[i] <= 104
//
//
//    进阶：
//
//    如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    /**
     * 暴力算法
     * 时间复杂度 O(n2) 空间复杂度O(1)
     *
     * @param target 目标和
     * @param nums   输入数组
     * @return 满足条件的最短子数组长度，如果不存在则返回0
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        // 初始化最短长度为0，表示尚未找到满足条件的子数组
        int len = 0;

        // 遍历数组，尝试以每个元素作为子数组的起始位置
        for (int i = 0; i < nums.length; i++) {
            // p 表示当前子数组的结束位置
            int p = i;
            // sum 表示当前子数组的和
            int sum = 0;

            // 从当前起始位置i开始，向后扩展子数组，直到和≥target或到达数组末尾
            while (sum < target && p < nums.length) {
                sum += nums[p++]; // 将当前元素加入和，并移动结束位置
            }

            // 如果当前子数组的和≥target，说明找到了一个满足条件的子数组
            if (sum >= target) {
                // 如果是第一个满足条件的子数组，直接记录其长度
                if (len == 0) {
                    len = p - i; // 子数组长度 = 结束位置 - 起始位置
                }
                // 如果不是第一个满足条件的子数组，且当前子数组比之前记录的更短
                else if (len > p - i) {
                    len = p - i; // 更新最短长度
                }
                // 继续下一个起始位置的搜索（因为可能找到更短的子数组）
                continue;
            }
            // 如果从当前起始位置i开始的所有可能子数组都无法满足条件
            // 由于数组是顺序遍历的，后续更长的子数组也不可能满足条件（因为和会更小）
            // 因此可以直接退出循环
            break;
        }

        // 返回找到的最短长度，如果没有找到则返回0
        return len;
    }

    /**
     * 滑动窗口
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        // 初始化最短长度为最大值（表示尚未找到满足条件的子数组）
        int len = Integer.MAX_VALUE;
        // 左边界（窗口起始位置）
        int l = 0;
        // 右边界（窗口结束位置）
        int r = 0;
        // 当前窗口内元素的和
        int sum = 0;

        // 外层循环：扩展右边界，直到遍历完整个数组
        while (r < nums.length) {
            // 扩展右边界：将当前元素加入窗口和
            sum += nums[r++];

            // 内层循环：收缩左边界，直到窗口和不满足条件（sum < target）
            while (sum >= target) {
                // 更新最短长度：比较当前窗口长度与历史最短长度
                len = Math.min(len, r - l);
                // 收缩左边界：移除左边界元素，并移动左边界
                sum -= nums[l++];
            }
        }

        // 返回结果：如果未找到满足条件的子数组，返回0；否则返回最短长度
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
