package LinkedList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.List;

public class LeetCode203移除链表元素 {
    private static ListNode head;

    public static void main(String[] args) {
//        给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
//
//        示例 1：
//        输入：head = [1,2,6,3,4,5,6], val = 6
//        输出：[1,2,3,4,5]
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

//        示例 2：
//        输入：head = [], val = 1
//        输出：[]
//        arr = new int[]{};
//        val = 1;

//        示例 3：
//        输入：head = [7,7,7,7], val = 7
//        输出：[]
//        arr = new int[]{7, 7, 7, 7};
//        val = 7;

        for (int i = arr.length - 1; i >= 0; i--)
            addFirst(arr[i]);
        ListNode newHead = removeElements(head, val);
        loop(newHead);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        ListNode p1 = sentinel;
        ListNode p2;

        while ((p2 = p1.next) != null) {
            if (p2.val == val)
                p1.next = p2.next;
            else
                p1 = p1.next;
        }

        return sentinel.next;
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

    public static void addFirst(int val) {
        if (head == null)
            head = new ListNode(val, null);
        else
            head = new ListNode(val, head);
    }

    public static void loop(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
