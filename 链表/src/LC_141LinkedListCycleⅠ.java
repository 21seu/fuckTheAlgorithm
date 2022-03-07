import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class LC_141LinkedListCycleⅠ {

    public boolean hasCycle1(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode p1 = head; //man
        ListNode p2 = head.next; //kuai
        while(p2 != p1) {
            if(p2 == null || p2.next == null) return false;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return true;
    }

    //方法1：快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    //方法2：set集合
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> set = new HashSet();
//        while (head != null) {
//            if (!set.add(head)) {
//                return true;
//            }
//            head = head.next;
//        }
//        return false;
//    }
}
