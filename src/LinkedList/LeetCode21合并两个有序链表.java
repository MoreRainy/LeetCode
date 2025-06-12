package LinkedList;

import org.w3c.dom.Node;

public class LeetCode21合并两个有序链表 {
    private static ListNode l1, l2;

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

    public static void main(String[] args) {
//        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//        示例 1：
//        输入：l1 = [1,2,4], l2 = [1,3,4]
//        输出：[1,1,2,3,4,4]
        int arr1[] = {1, 2, 4};
        int arr2[] = {1, 3, 4};
//
//        示例 2：
//        输入：l1 = [], l2 = []
//        输出：[]
//
//        示例 3：
//        输入：l1 = [], l2 = [0]
//        输出：[0]
//
//        提示：
//
//        两个链表的节点数目范围是 [0, 50]
//        -100 <= Node.val <= 100
//        l1 和 l2 均按 非递减顺序 排列

        for (int i = arr1.length - 1; i >= 0; i--)
            l1 = addFirst(arr1[i], l1);
        for (int i = arr2.length - 1; i >= 0; i--)
            l2 = addFirst(arr2[i], l2);

        ListNode newL = mergeTwoLists(l1, l2);
        loop(newL);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode newL = new ListNode(0,null);
        ListNode l = newL;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                l.next = p1;
                p1 = p1.next;
            } else {
                l.next = p2;
                p2 = p2.next;
            }
            l = l.next;
        }

        if (p1 == null) l.next = p2;
        else l.next = p1;

        return newL.next;
    }

    private static ListNode addFirst(int val, ListNode head) {
        head = new ListNode(val, head);
        return head;
    }

    private static void loop(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
