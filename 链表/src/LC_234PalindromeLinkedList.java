import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * 如果是，返回 true ；否则，返回 false 。
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 输入：head = [1,2]
 * 输出：false
 * <p>
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LC_234PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        //3、维护一个数组
        if (head == null) return false;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int front = 0, behind = list.size() - 1;
        while (front < behind) {
            if (!list.get(front).equals(list.get(behind))) {
                return false;
            }
            front++;
            behind--;
        }
        return true;
    }
}
