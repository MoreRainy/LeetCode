package LinkedList;

import org.w3c.dom.Node;

public class LeetCode82删除排序链表中的重复元素II {
    private static ListNode head;

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
//        给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//        示例 1：
//        输入：head = [1,2,3,3,4,4,5]
//        输出：[1,2,5]
//        int arr[] = {1, 2, 3, 3, 4, 4, 5};
//
//        示例 2：
//        输入：head = [1,1,1,2,3]
//        输出：[2,3]
        int arr[] = {1, 1, 1, 2, 3};
//
//
//        提示：
//        链表中节点数目在范围 [0, 300] 内
//                -100 <= Node.val <= 100
//        题目数据保证链表已经按升序 排列

        for (int i = arr.length - 1; i >= 0; i--)
            addFirst(arr[i]);

        head = deleteDuplicates(head);

        loop(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode listNode = dummy;

        while (listNode.next != null && listNode.next.next != null) {
            if (listNode.next.val == listNode.next.next.val) {
                int record = listNode.next.val;
                listNode.next = listNode.next.next.next;
                while (listNode.next != null && listNode.next.val == record) {
                    listNode.next = listNode.next.next;
                }
            } else {
                listNode = listNode.next;
            }
        }

        return dummy.next;
    }

    private static void addFirst(int val) {
        head = new ListNode(val, head);
    }

    private static void loop(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
