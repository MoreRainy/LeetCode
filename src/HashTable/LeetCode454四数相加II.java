package HashTable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454四数相加II {
    //    给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
//            0 <= i, j, k, l < n
//    nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//
//    示例 1：
//    输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//    输出：2
//    解释：
//    两个元组如下：
//            1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
//            2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
//
//    示例 2：
//    输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//    输出：1
//
//
//    提示：
//
//    n == nums1.length
//    n == nums2.length
//    n == nums3.length
//    n == nums4.length
//    1 <= n <= 200
//    -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - (i + j), 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // 测试用例 1（示例 1）
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        int expected1 = 2;
        int actual1 = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println("测试用例 1:");
        System.out.println("预期结果: " + expected1);
        System.out.println("实际结果: " + actual1);
        System.out.println("是否通过: " + (expected1 == actual1 ? "✅ 通过" : "❌ 失败"));
        System.out.println();

        // 测试用例 2（示例 2）
        int[] nums5 = {0};
        int[] nums6 = {0};
        int[] nums7 = {0};
        int[] nums8 = {0};
        int expected2 = 1;
        int actual2 = fourSumCount(nums5, nums6, nums7, nums8);
        System.out.println("测试用例 2:");
        System.out.println("预期结果: " + expected2);
        System.out.println("实际结果: " + actual2);
        System.out.println("是否通过: " + (expected2 == actual2 ? "✅ 通过" : "❌ 失败"));
        System.out.println();

        // 测试用例 3（无匹配）
        int[] nums9 = {1, 1};
        int[] nums10 = {1, 1};
        int[] nums11 = {1, 1};
        int[] nums12 = {1, 1};
        int expected3 = 0;
        int actual3 = fourSumCount(nums9, nums10, nums11, nums12);
        System.out.println("测试用例 3:");
        System.out.println("预期结果: " + expected3);
        System.out.println("实际结果: " + actual3);
        System.out.println("是否通过: " + (expected3 == actual3 ? "✅ 通过" : "❌ 失败"));
        System.out.println();
    }
}
