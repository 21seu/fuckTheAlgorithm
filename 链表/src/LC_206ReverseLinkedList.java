import java.util.Stack;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 输入：head = []
 * 输出：[]
 */
public class LC_206ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            //消除node指向
            node.next = null;
            cur.next = node;
            //指针往下走
            cur = cur.next;
        }
        return head;
    }
}
