package LinkedList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;

public class LeetCode234回文链表 {
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
//        给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
//
//        示例 1：
//        输入：head = [1,2,2,1]
//        输出：true
        int[] arr = {1, 2, 2, 1};
//
//        示例 2：
//        输入：head = [1,2]
//        输出：false
//
//        提示：
//        链表中节点数目在范围[1, 105] 内
//        0 <= Node.val <= 9
//
//        进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

        for (int i = arr.length - 1; i >= 0; i--) {
            addFirst(arr[i]);
        }

        System.out.println(isPalindrome(head));

        loop(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
    }

    //    public static boolean isPalindrome(ListNode head) {
//        ListNode stack = null;
//
//        loop(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//            }
//        });
//
//        return false;
//    }

    //双指针
//    public static boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//
//        ListNode p = head;
//        while (p != null) {
//            list.add(p.val);
//            p = p.next;
//        }
//
//        int front = 0;
//        int rear = list.size() - 1;
//        while (front < rear) {
//            if (!list.get(front).equals(list.get(rear))) {
//                return false;
//            }
//            front++;
//            rear--;
//        }
//
//        return true;
//    }

    //递归
    private static ListNode front;

    public static boolean isPalindrome(ListNode head){
        front = head;

        if(recursion(head)){
            return true;
        }
        return false;
    }

    public static boolean recursion(ListNode cur){
        if(cur!=null){
            if(!recursion(cur.next)){//递归到链表末端
                return false;
            }
            if(front.val != cur.val){
                return false;
            }
            front = front.next;
        }

        return true;
    }

    private static void addFirst(int val) {
        head = new ListNode(val, head);
    }

    private static void loop(Consumer<Integer> consumer) {
        ListNode p = head;
        while (p != null) {
            consumer.accept(p.val);
            p = p.next;
        }
    }
}
