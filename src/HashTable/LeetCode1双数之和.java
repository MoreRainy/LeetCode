package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1双数之和 {
    //    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//    你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
//
//    你可以按任意顺序返回答案。
//
//
//
//    示例 1：
//    输入：nums = [2,7,11,15], target = 9
//    输出：[0,1]
//    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//    示例 2：
//    输入：nums = [3,2,4], target = 6
//    输出：[1,2]
//
//    示例 3：
//    输入：nums = [3,3], target = 6
//    输出：[0,1]
//
//
//    提示：
//
//            2 <= nums.length <= 104
//            -109 <= nums[i] <= 109
//            -109 <= target <= 109
//    只会存在一个有效答案
//
//
//    进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

    /**
     * 暴力
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};

        return new int[0];
    }

    /**
     * 哈希表 Map
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Test case 1: [" + result1[0] + ", " + result1[1] + "]");

        // 测试用例2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Test case 2: [" + result2[0] + ", " + result2[1] + "]");

        // 测试用例3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Test case 3: [" + result3[0] + ", " + result3[1] + "]");
    }
}
