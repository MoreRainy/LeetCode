package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LeetCode面试题0207链表相交 {
    //    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//
//    图示两个链表在节点 c1 开始相交：
//
//
//    题目数据 保证 整个链式结构中不存在环。
//
//    注意，函数返回结果后，链表必须 保持其原始结构 。
//
//
//    示例 1：
//    输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//    输出：Intersected at '8'
//    解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//    从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//    在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//    示例 2：
//    输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
//    输出：Intersected at '2'
//    解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
//    从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
//    在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//    示例 3：
//    输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//    输出：null
//    解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
//    由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
//    这两个链表不相交，因此返回 null 。
//
//
//    提示：
//
//    listA 中节点数目为 m
//    listB 中节点数目为 n
//            0 <= m, n <= 3 * 104
//            1 <= Node.val <= 105
//            0 <= skipA <= m
//            0 <= skipB <= n
//    如果 listA 和 listB 没有交点，intersectVal 为 0
//    如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
//
//
//    进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;

        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // 创建链表
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // 打印链表
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 示例 1
        int[] listA1 = {4, 1, 8, 4, 5};
        int[] listB1 = {5, 0, 1, 8, 4, 5};
        int skipA1 = 2;
        int skipB1 = 3;

        ListNode headA1 = createLinkedList(listA1);
        ListNode headB1 = createLinkedList(listB1);

        // 创建相交部分
        ListNode intersectNode1 = headA1;
        for (int i = 0; i < skipA1; i++) {
            intersectNode1 = intersectNode1.next;
        }
        ListNode tempB1 = headB1;
        for (int i = 0; i < skipB1; i++) {
            tempB1 = tempB1.next;
        }
        tempB1.next = intersectNode1;

        System.out.println("Example 1:");
        printLinkedList(headA1);
        printLinkedList(headB1);
        ListNode result1 = getIntersectionNode(headA1, headB1);
        System.out.println("Intersection at: " + (result1 != null ? result1.val : "null"));

        // 示例 2
        int[] listA2 = {0, 9, 1, 2, 4};
        int[] listB2 = {3, 2, 4};
        int skipA2 = 3;
        int skipB2 = 1;

        ListNode headA2 = createLinkedList(listA2);
        ListNode headB2 = createLinkedList(listB2);

        // 创建相交部分
        ListNode intersectNode2 = headA2;
        for (int i = 0; i < skipA2; i++) {
            intersectNode2 = intersectNode2.next;
        }
        ListNode tempB2 = headB2;
        for (int i = 0; i < skipB2; i++) {
            tempB2 = tempB2.next;
        }
        tempB2.next = intersectNode2;

        System.out.println("Example 2:");
        printLinkedList(headA2);
        printLinkedList(headB2);
        ListNode result2 = getIntersectionNode(headA2, headB2);
        System.out.println("Intersection at: " + (result2 != null ? result2.val : "null"));

        // 示例 3
        int[] listA3 = {2, 6, 4};
        int[] listB3 = {1, 5};
        int skipA3 = 3;
        int skipB3 = 2;

        ListNode headA3 = createLinkedList(listA3);
        ListNode headB3 = createLinkedList(listB3);

        // 这里没有相交部分

        System.out.println("Example 3:");
        printLinkedList(headA3);
        printLinkedList(headB3);
        ListNode result3 = getIntersectionNode(headA3, headB3);
        System.out.println("Intersection at: " + (result3 != null ? result3.val : "null"));
    }
}
