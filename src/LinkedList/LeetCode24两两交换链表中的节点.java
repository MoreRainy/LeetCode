package LinkedList;

import java.util.Arrays;

public class LeetCode24两两交换链表中的节点 {
    //    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
//
//    示例 1：
//    输入：head = [1,2,3,4]
//    输出：[2,1,4,3]
//
//    示例 2：
//    输入：head = []
//    输出：[]
//
//    示例 3：
//    输入：head = [1]
//    输出：[1]
//
//
//    提示：
//    链表中节点的数目在范围 [0, 100] 内
//    0 <= Node.val <= 100
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fir = dummy.next;
        ListNode sec;
        ListNode prev = dummy;

        while (fir != null && fir.next != null) {
            sec = fir.next;

            //交换
            fir.next = sec.next;
            sec.next = fir;
            prev.next = sec;

            //更新变量
            prev = fir;
            fir = fir.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 测试函数
    public static void main(String[] args) {
        // 测试用例1: [1,2,3,4] -> [2,1,4,3]
        ListNode head1 = arrayToList(new int[]{1, 2, 3, 4});
        ListNode swapped1 = swapPairs(head1);
        int[] result1 = listToArray(swapped1);
        assert Arrays.equals(result1, new int[]{2, 1, 4, 3}) : "测试用例1失败";

        // 测试用例2: [] -> []
        ListNode head2 = arrayToList(new int[]{});
        ListNode swapped2 = swapPairs(head2);
        int[] result2 = listToArray(swapped2);
        assert Arrays.equals(result2, new int[]{}) : "测试用例2失败";

        // 测试用例3: [1] -> [1]
        ListNode head3 = arrayToList(new int[]{1});
        ListNode swapped3 = swapPairs(head3);
        int[] result3 = listToArray(swapped3);
        assert Arrays.equals(result3, new int[]{1}) : "测试用例3失败";

        // 测试用例4: [1,2,3,4,5] -> [2,1,4,3,5]
        ListNode head4 = arrayToList(new int[]{1, 2, 3, 4, 5});
        ListNode swapped4 = swapPairs(head4);
        int[] result4 = listToArray(swapped4);
        assert Arrays.equals(result4, new int[]{2, 1, 4, 3, 5}) : "测试用例4失败";

        // 测试用例5: [1,2,3,4,5,6] -> [2,1,4,3,6,5]
        ListNode head5 = arrayToList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode swapped5 = swapPairs(head5);
        int[] result5 = listToArray(swapped5);
        assert Arrays.equals(result5, new int[]{2, 1, 4, 3, 6, 5}) : "测试用例5失败";

        System.out.println("所有测试用例通过!");
    }

    // 辅助方法：将数组转换为链表
    private static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // 辅助方法：将链表转换为数组
    private static int[] listToArray(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        // 先计算链表长度
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        // 创建数组并填充
        int[] result = new int[length];
        current = head;
        int index = 0;
        while (current != null) {
            result[index++] = current.val;
            current = current.next;
        }
        return result;
    }
}
