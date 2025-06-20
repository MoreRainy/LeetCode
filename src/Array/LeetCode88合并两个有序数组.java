package Array;

import java.util.Arrays;

public class LeetCode88合并两个有序数组 {
    public static void main(String[] args) {
//        给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//        注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
//
//
//        示例 1：
//        输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        输出：[1,2,2,3,5,6]
//        解释：需要合并 [1,2,3] 和 [2,5,6] 。
//        合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;

//        示例 2：
//        输入：nums1 = [1], m = 1, nums2 = [], n = 0
//        输出：[1]
//        解释：需要合并 [1] 和 [] 。
//        合并结果是 [1] 。
//        int[] nums1 = {1};
//        int m = 1;
//        int[] nums2 = {};
//        int n = 0;

//        示例 3：
//        输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//        输出：[1]
//        解释：需要合并的数组是 [] 和 [1] 。
//        合并结果是 [1] 。
//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;

//        示例 4：
//        输入：nums1 = [4,5,6,0,0,0], m = 3, nums2 = [1,2,3], n = 3
//        输出：[1,2,3,4,5,6]
//        int[] nums1 = {4, 5, 6, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {1, 2, 3};
//        int n = 3;

//        示例 5：
//        输入：nums1 = [4,0,0,0,0,0], m = 1, nums2 = [1,2,3,5,6], n = 5
//        输出：[1,2,3,4,5,6]
        int[] nums1 = {4, 0, 0, 0, 0, 0};
        int m = 1;
        int[] nums2 = {1, 2, 3, 5, 6};
        int n = 5;

//        注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    /*
    采用类似排序的思想，将哨兵索引左边的值视为已按规则排列，右边的视为未排列
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        i 核心哨兵，用于标识nums1数组排列分界点
        j 哨兵，用于标识nums2数组排列分界点
        len 记录nums1逻辑长度
         */
        int i = 0, j = 0, len = m;
        while (i < len && j < n) {
            if (nums1[i] >= nums2[j]) {//nums2数组的更小，则插入，否则跟nums1数组的下一位在比较
                System.arraycopy(nums1, i, nums1, i + 1, len - i);//整体后移一位留空
                nums1[i] = nums2[j++];//插入数值
                len++;//插入数值,长度+1
            }
            i++;//每次循环都必有一位数排列成功，需将核心哨兵后移一位
        }
        //若nums1先遍历结束,将nums2剩余部分直接贴在nums1后面
        if (i == len)
            System.arraycopy(nums2, j, nums1, m + j, n - j);
    }
}
