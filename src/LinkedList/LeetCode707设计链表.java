package LinkedList;

public class LeetCode707设计链表 {
    //    你可以选择使用单链表或者双链表，设计并实现自己的链表。
//
//    单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
//
//    如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
//
//    实现 MyLinkedList 类：
//
//    MyLinkedList() 初始化 MyLinkedList 对象。
//    int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
//    void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
//    void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
//    void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
//    void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
//
//
//    示例：
//
//    输入
//    ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
//        [[], [1], [3], [1, 2], [1], [1], [1]]
//    输出
//    [null, null, null, null, 2, null, 3]
//
//    解释
//    MyLinkedList myLinkedList = new MyLinkedList();
//    myLinkedList.addAtHead(1);
//    myLinkedList.addAtTail(3);
//    myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//    myLinkedList.get(1);              // 返回 2
//    myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//    myLinkedList.get(1);              // 返回 3
//
//
//    提示：
//
//            0 <= index, val <= 1000
//    请不要使用内置的 LinkedList 库。
//    调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        // 测试用例
        myLinkedList.addAtHead(1);       // 链表: 1
        myLinkedList.addAtTail(3);       // 链表: 1->3
        myLinkedList.addAtIndex(1, 2);   // 链表: 1->2->3
        System.out.println(myLinkedList.get(1)); // 返回 2
        myLinkedList.deleteAtIndex(1);   // 链表: 1->3
        System.out.println(myLinkedList.get(1)); // 返回 3

        // 更多测试用例
        System.out.println("----- 更多测试 -----");
        myLinkedList.addAtHead(0);       // 链表: 0->1->3
        System.out.println(myLinkedList.get(0)); // 返回 0
        System.out.println(myLinkedList.get(2)); // 返回 3

        myLinkedList.addAtTail(4);       // 链表: 0->1->3->4
        System.out.println(myLinkedList.get(3)); // 返回 4

        myLinkedList.addAtIndex(2, 5);   // 链表: 0->1->5->3->4
        System.out.println(myLinkedList.get(2)); // 返回 5
        System.out.println(myLinkedList.get(3)); // 返回 3

        myLinkedList.deleteAtIndex(3);   // 链表: 0->1->5->4
        System.out.println(myLinkedList.get(3)); // 返回 4
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    static class MyLinkedList {
        int size;
        ListNode head;
        ListNode tail;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= 0 && index < size) {
                ListNode curr;
                if (index < size / 2) {
                    curr = head.next;

                    for (int i = 0; i < index; i++) {
                        curr = curr.next;
                    }

                    return curr.val;
                } else {
                    curr = tail.prev;

                    for (int i = size - 1; i > index; i--) {
                        curr = curr.prev;
                    }

                    return curr.val;
                }
            } else {
                return -1;
            }
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val, head.next, head);
            head.next.prev = newNode;
            head.next = newNode;

            size++;
        }

        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val, tail, tail.prev);
            tail.prev.next = newNode;
            tail.prev = newNode;

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
            } else if (index == size) {
                addAtTail(val);
            } else if (index > 0 && index < size) {
                ListNode prev;
                if (index < size / 2) {
                    prev = head.next;

                    for (int i = 0; i < index; i++) {
                        prev = prev.next;
                    }
                } else {
                    prev = tail.prev;

                    for (int i = size; i > index; i--) {
                        prev = prev.prev;
                    }
                }

                ListNode newNode = new ListNode(val, prev.next, prev);
                prev.next.prev = newNode;
                prev.next = newNode;

                size++;
            } else {
                return;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= 0 && index < size) {
                ListNode toDelete;
                if (index < size / 2) {
                    toDelete = head.next;

                    for (int i = 0; i < index; i++) {
                        toDelete = toDelete.next;
                    }
                } else {
                    toDelete = tail.prev;

                    for (int i = size - 1; i > index; i--) {
                        toDelete = toDelete.prev;
                    }
                }

                toDelete.prev.next = toDelete.next;
                toDelete.next.prev = toDelete.prev;

                size--;
            } else {
                return;
            }
        }
    }
}
