package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18四数之和 {
    //    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//
//            0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。
//
//
//
//    示例 1：
//    输入：nums = [1,0,-1,0,-2,2], target = 0
//    输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//
//    示例 2：
//    输入：nums = [2,2,2,2,2], target = 8
//    输出：[[2,2,2,2]]
//
//
//    提示：
//
//            1 <= nums.length <= 200
//            -109 <= nums[i] <= 109
//            -109 <= target <= 109
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 4) return resultList;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length && i < j; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                long temp = (long) target - (long) nums[i] - (long) nums[j];
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[left] + (long) nums[right];
                    if (sum > temp) {
                        right--;//和大于0，右边界（较大值）左移

                        while (right >= 0 && nums[right] == nums[right + 1]) right--;
                    } else if (sum < temp) {
                        left++;//和小于0，左边界（较小值）右移

                        while (left < n && nums[left] == nums[left - 1]) left++;
                    } else {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));

                        while (right >= 0 && nums[right] == nums[right + 1]) right--;
                        while (left < n && nums[left] == nums[left - 1]) left++;
                    }
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        // 测试用例1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> result1 = fourSum(nums1, target1);
        List<List<Integer>> expected1 = Arrays.asList(
                Arrays.asList(-2, -1, 1, 2),
                Arrays.asList(-2, 0, 0, 2),
                Arrays.asList(-1, 0, 0, 1)
        );
        printTestResult("测试用例1", nums1, target1, result1, expected1);

        // 测试用例2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        List<List<Integer>> result2 = fourSum(nums2, target2);
        List<List<Integer>> expected2 = Arrays.asList(
                Arrays.asList(2, 2, 2, 2)
        );
        printTestResult("测试用例2", nums2, target2, result2, expected2);

        // 测试用例3: 普通情况
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int target3 = 16;
        List<List<Integer>> result3 = fourSum(nums3, target3);
        List<List<Integer>> expected3 = Arrays.asList(
                Arrays.asList(1, 2, 5, 8),
                Arrays.asList(1, 2, 6, 7),
                Arrays.asList(1, 3, 4, 8),
                Arrays.asList(1, 3, 5, 7),
                Arrays.asList(1, 4, 5, 6),
                Arrays.asList(2, 3, 4, 7),
                Arrays.asList(2, 3, 5, 6)
        );
        printTestResult("测试用例3", nums3, target3, result3, expected3);

        // 测试用例4: 无解情况
        int[] nums4 = {1, 2, 3, 4};
        int target4 = 100;
        List<List<Integer>> result4 = fourSum(nums4, target4);
        List<List<Integer>> expected4 = Arrays.asList();
        printTestResult("测试用例4", nums4, target4, result4, expected4);
    }

    // 打印测试结果和预期结果
    private static void printTestResult(String testCaseName, int[] nums, int target,
                                        List<List<Integer>> result, List<List<Integer>> expected) {
        System.out.println("========== " + testCaseName + " ==========");
        System.out.println("输入: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("实际输出: " + formatResult(result));
        System.out.println("预期输出: " + formatResult(expected));

        if (compareResults(result, expected)) {
            System.out.println("结果: ✅ 通过");
        } else {
            System.out.println("结果: ❌ 失败");
        }
        System.out.println();
    }

    // 比较两个结果列表是否相同(顺序无关)
    private static boolean compareResults(List<List<Integer>> result, List<List<Integer>> expected) {
        if (result.size() != expected.size()) {
            return false;
        }

        // 将结果列表转换为可比较的形式(排序后的字符串)
        List<String> resultList = new ArrayList<>();
        for (List<Integer> list : result) {
            String key = list.toString();
            resultList.add(key);
        }

        List<String> expectedList = new ArrayList<>();
        for (List<Integer> list : expected) {
            String key = list.toString();
            expectedList.add(key);
        }

        // 排序后比较
        resultList.sort(String::compareTo);
        expectedList.sort(String::compareTo);

        return resultList.equals(expectedList);
    }

    // 格式化输出结果
    private static String formatResult(List<List<Integer>> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            sb.append("[");
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j));
                if (j < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i < result.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
