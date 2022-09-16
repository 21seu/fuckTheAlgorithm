import java.util.List;
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

    public ListNode reverseList3(ListNode head) {
        return dfs(head, null);
    }

    private ListNode dfs(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = dfs(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        curr.next = new ListNode(2);
        curr = curr.next;
        curr.next = new ListNode(3);
        curr = curr.next;
        curr.next = new ListNode(4);
        System.out.println(new LC_206ReverseLinkedList().reverseList3(head));
    }
}
