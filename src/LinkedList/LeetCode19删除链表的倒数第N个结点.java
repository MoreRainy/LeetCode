package LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode19删除链表的倒数第N个结点 {
    private static ListNode head;

    public static void main(String[] args) {
//        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//        示例 1：
//        输入：head = [1,2,3,4,5], n = 2
//        输出：[1,2,3,5]
        int arr[] = {1, 2, 3, 4, 5};
        int n = 2;
//
//        示例 2：
//        输入：head = [1], n = 1
//        输出：[]
        arr = new int[]{1};
        n = 1;
//
//        示例 3：
//        输入：head = [1,2], n = 1
//        输出：[1]
//        arr = new int[]{1, 2};
//        n = 1;

        for (int i = arr.length - 1; i >= 0; i--)
            addFirst(arr[i]);

        ListNode newNode = removeNthFromEnd(head, n);
        loop(newNode);
    }

    //方法一：遍历获取链表长度
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode sentinel = new ListNode(-1, head);
//        ListNode p = sentinel;
//
//        int length = loop(sentinel);
//
//        for (int i = 0; i < length - n - 1; i++)
//            p = p.next;
//
//        p.next = p.next.next;
//
//        return sentinel.next;
//    }

    //方法二：栈
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode sentinel = new ListNode(-1, head);
//        LinkedList<ListNode> stack = new LinkedList<ListNode>();
//        ListNode p = sentinel;
//
//        while (p != null) {
//            stack.push(p);
//            p = p.next;
//        }
//
//        for (int i = 0; i < n; i++)
//            stack.pop();
//
//        ListNode node = stack.peek();
//        node.next = node.next.next;
//
//        return sentinel.next;
//    }

    //方法三：双指针
//    public static ListNode removeNthFromEnd(ListNode head, int n){
//        ListNode s = new ListNode(-1, head);
//        ListNode p1 = s;
//        ListNode p2 = s;
//
//        for (int i = 0; i < n + 1; i++) {
//            p2 = p2.next;
//        }
//
//        while (p2 != null) {
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        p1.next = p1.next.next;
//
//        return s.next;
//    }

    //方法四：递归
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1, head);
        recursion(sentinel, n);

        return sentinel.next;
    }

    public static int recursion(ListNode p, int n) {
        if (p == null) return 0;

        int nth = recursion(p.next, n);

        if (nth == n) p.next = p.next.next;

        return nth + 1;
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

    public static int loop(ListNode head) {
        int n = 0;
        ListNode curr = head;

        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
            n++;
        }

        return n;
    }
}
