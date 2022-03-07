/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */
public class LC_203RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        //定义一个头节点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}