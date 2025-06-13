package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode350两个数组的交集II {
    //    给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//
//
//    示例 1：
//    输入：nums1 = [1,2,2,1], nums2 = [2,2]
//    输出：[2,2]
//
//    示例 2:
//    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出：[4,9]
//
//
//    提示：
//
//            1 <= nums1.length, nums2.length <= 1000
//            0 <= nums1[i], nums2[i] <= 1000
//
//
//    进阶：
//
//    如果给定的数组已经排好序呢？你将如何优化你的算法？
//    如果 nums1 的大小比 nums2 小，哪种方法更优？
//    如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                list.add(i);
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        // 测试用例 1
        int[] nums1_1 = {1, 2, 2, 1};
        int[] nums2_1 = {2, 2};
        int[] result1 = intersect(nums1_1, nums2_1);
        System.out.print("测试用例 1 输出: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        // 测试用例 2
        int[] nums1_2 = {4, 9, 5};
        int[] nums2_2 = {9, 4, 9, 8, 4};
        int[] result2 = intersect(nums1_2, nums2_2);
        System.out.print("测试用例 2 输出: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
