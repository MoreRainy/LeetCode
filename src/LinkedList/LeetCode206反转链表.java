package LinkedList;

public class LeetCode206反转链表 {
    public static void main(String[] args) {
//        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//        示例 1：
//        输入：head = [1,2,3,4,5]
//        输出：[5,4,3,2,1]

//        示例 2：
//        输入：head = [1,2]
//        输出：[2,1]

//        示例 3：
//        输入：head = []
//        输出：[]
    }

    public class ListNode {
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

    public ListNode reverseList(ListNode head) {
        ListNode n = null;
        ListNode p = head;
        while (p != null) {
            n = new ListNode(p.val, n);
            p = p.next;
        }
        return n;
    }
}
