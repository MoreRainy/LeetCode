package HashTable;

import java.util.*;

public class LeetCode15三数之和 {
    //    给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。
//
//
//
//    示例 1：
//    输入：nums = [-1,0,1,2,-1,-4]
//    输出：[[-1,-1,2],[-1,0,1]]
//    解释：
//    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//    不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//    注意，输出的顺序和三元组的顺序并不重要。
//
//    示例 2：
//    输入：nums = [0,1,1]
//    输出：[]
//    解释：唯一可能的三元组和不为 0 。
//
//    示例 3：
//    输入：nums = [0,0,0]
//    输出：[[0,0,0]]
//    解释：唯一可能的三元组和为 0 。
//
//
//    提示：
//            3 <= nums.length <= 3000
//            -105 <= nums[i] <= 105

    //超时 弃用
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        //先求二数之和，并保存下标
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                List<Integer> combination = new ArrayList<>();
                combination.add(i);
                combination.add(j);
                map.get(sum).add(combination);
            }
        }

        //再求三数之和，利用 第三数=-(第一数+第二数)，并保存下标
        for (int i = 0; i < nums.length; i++) {
            int diff = -nums[i];
            if (map.containsKey(diff)) {
                final List<List<Integer>> listList = map.get(diff);
                for (List<Integer> list : listList) {
                    //过滤下标相同的数
                    if (!list.contains(i)) {
                        //不能直接使用list.add()，因为会修改原map数组导致下次循环访问列表长度有误
                        List<Integer> newList = new ArrayList<>(list);  // 创建新的副本
                        newList.add(i);  // 在新副本上添加 i
                        resultList.add(newList);  // 添加新副本到结果
                    }
                }
            }
        }
        //将下标转换为值
        List<List<Integer>> finalResult = new ArrayList<>();
        for (List<Integer> indexList : resultList) {
            // 将下标组合转换为数值组合
            List<Integer> valueList = new ArrayList<>();
            for (int index : indexList) {
                valueList.add(nums[index]);  // 用 nums[index] 替换下标
            }
            finalResult.add(valueList);  // 添加到最终结果
        }

        // 去重：对 finalResult 进行排序并去重
        Set<List<Integer>> uniqueTriples = new HashSet<>();
        List<List<Integer>> deduplicatedResult = new ArrayList<>();

        for (List<Integer> triple : finalResult) {
            // 对三元组进行排序
            List<Integer> sortedTriple = new ArrayList<>(triple);
            Collections.sort(sortedTriple);

            // 如果未出现过，则加入结果
            if (uniqueTriples.add(sortedTriple)) {  // HashSet.add() 返回 true 表示未重复
                deduplicatedResult.add(sortedTriple);
            }
        }

        return deduplicatedResult;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        if (nums.length < 3) return resultList;

        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //首位去重
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            int temp = -nums[i];//双指针之和
            int left = i + 1;//左指针
            int right = n - 1;//右指针

            while (left < right) {
                if (nums[left] + nums[right] > temp) {
                    right--;//和大于0，右边界（较大值）左移
                    //去重
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < temp) {
                    left++;//和小于0，左边界（较小值）右移
                    //去重
                    while (left < n && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    resultList.add(Arrays.asList(nums[i], nums[left++], nums[right--]));

                    //去重
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    while (left < n && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return resultList;
    }

    // 辅助方法：将List<List<Integer>>转换为字符串表示，用于比较
    public static String listToString(List<List<Integer>> list) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            List<Integer> innerList = list.get(i);
            sb.append("[");
            for (int j = 0; j < innerList.size(); j++) {
                sb.append(innerList.get(j));
                if (j < innerList.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // 测试用例1: 标准情况
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result1 = threeSum(nums1);
        String expected1 = "[[-1, -1, 2], [-1, 0, 1]]";
        String actual1 = listToString(result1);
        System.out.println("Test Case 1:");
        System.out.println("Expected: " + expected1);
        System.out.println("Actual:   " + actual1);
        System.out.println("Result:   " + (expected1.equals(actual1) ? "PASS" : "FAIL"));
        System.out.println();

        // 测试用例2: 无解情况
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> result2 = threeSum(nums2);
        String expected2 = "[]";
        String actual2 = listToString(result2);
        System.out.println("Test Case 2:");
        System.out.println("Expected: " + expected2);
        System.out.println("Actual:   " + actual2);
        System.out.println("Result:   " + (expected2.equals(actual2) ? "PASS" : "FAIL"));
        System.out.println();

        // 测试用例3: 全零情况
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> result3 = threeSum(nums3);
        String expected3 = "[[0, 0, 0]]";
        String actual3 = listToString(result3);
        System.out.println("Test Case 3:");
        System.out.println("Expected: " + expected3);
        System.out.println("Actual:   " + actual3);
        System.out.println("Result:   " + (expected3.equals(actual3) ? "PASS" : "FAIL"));
        System.out.println();

        // 测试用例4: 边界情况 - 数组长度刚好3
        int[] nums4 = {1, 1, -2};
        List<List<Integer>> result4 = threeSum(nums4);
        String expected4 = "[[-2, 1, 1]]";
        String actual4 = listToString(result4);
        System.out.println("Test Case 4:");
        System.out.println("Expected: " + expected4);
        System.out.println("Actual:   " + actual4);
        System.out.println("Result:   " + (expected4.equals(actual4) ? "PASS" : "FAIL"));
        System.out.println();
    }
}
