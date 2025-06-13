package HashTable;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode349两个数组的交集 {
    //    给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
//    示例 1：
//    输入：nums1 = [1,2,2,1], nums2 = [2,2]
//    输出：[2]
//
//    示例 2：
//    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出：[9,4]
//    解释：[4,9] 也是可通过的
//
//
//    提示：
//
//            1 <= nums1.length, nums2.length <= 1000
//            0 <= nums1[i], nums2[i] <= 1000

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        List<Integer> list = new ArrayList<>();

        for (int i : nums2) {
            if(set.contains(i) && !list.contains(i)){
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        // 测试用例1
        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums2_1 = {2, 2};
        int[] result1 = intersection(nums1_1, nums2_1);
        System.out.println("测试用例1结果: " + Arrays.toString(result1)); // 预期输出: [2]

        // 测试用例2
        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] result2 = intersection(nums1_2, nums2_2);
        System.out.println("测试用例2结果: " + Arrays.toString(result2)); // 预期输出: [9, 4] 或 [4, 9]

        // 你可以添加更多的测试用例
        // 测试用例3: 无交集
        int[] nums1_3 = {1, 3, 5};
        int[] nums2_3 = {2, 4, 6};
        int[] result3 = intersection(nums1_3, nums2_3);
        System.out.println("测试用例3结果: " + Arrays.toString(result3)); // 预期输出: []

        // 测试用例4: 完全相同的数组
        int[] nums1_4 = {1, 2, 3};
        int[] nums2_4 = {1, 2, 3};
        int[] result4 = intersection(nums1_4, nums2_4);
        System.out.println("测试用例4结果: " + Arrays.toString(result4)); // 预期输出: [1, 2, 3]

        // 测试用例5: 一个数组为空
        int[] nums1_5 = {};
        int[] nums2_5 = {1, 2, 3};
        int[] result5 = intersection(nums1_5, nums2_5);
        System.out.println("测试用例5结果: " + Arrays.toString(result5)); // 预期输出: []
    }
}
