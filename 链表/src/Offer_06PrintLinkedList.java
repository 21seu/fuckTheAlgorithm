import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 0 <= 链表长度 <= 10000
 */
public class Offer_06PrintLinkedList {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
