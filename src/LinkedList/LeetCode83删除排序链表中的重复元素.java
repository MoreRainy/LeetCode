package LinkedList;

import org.w3c.dom.Node;

public class LeetCode83删除排序链表中的重复元素 {
    private static ListNode head;

    public static void main(String[] args) {
//        给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//        示例 1：
//        输入：head = [1,1,2]
//        输出：[1,2]
        int arr[] = {1, 1, 2};
//
//        示例 2：
//        输入：head = [1,1,2,3,3]
//        输出：[1,2,3]
//        int arr[] = {1, 1, 2, 3, 3};
//
//        提示：
//        链表中节点数目在范围 [0, 300] 内
//                -100 <= Node.val <= 100
//        题目数据保证链表已经按升序 排列

        for (int i = arr.length - 1; i >= 0; i--)
            addFirst(arr[i]);

        deleteDuplicates(head);

        loop(head);
    }

    private static void loop(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode listNode = head;
        ListNode target;//用于一次删除多个连续元素

        while (listNode != null && listNode.next != null) {
            if (listNode.val == listNode.next.val) {
                target = listNode.next.next;
                while (target != null && target.val == listNode.val) {//一次性删除多个重复元素，找到不同值或达到链表尾端为止
                    target = target.next;
                }
                listNode.next = target;
            }
            listNode = listNode.next;
        }

        return head;
    }

//官方题解
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//
//        ListNode cur = head;
//        while (cur.next != null) {
//            if (cur.val == cur.next.val) {
//                cur.next = cur.next.next;
//            } else {
//                cur = cur.next;
//            }
//        }
//
//        return head;
//    }

    private static void addFirst(int val) {
        if (head == null)
            head = new ListNode(val, null);
        else
            head = new ListNode(val, head);
    }
}
