package leetcode;

import java.util.HashSet;
import java.util.Set;
import leetcode.auxiliary.AssertUtil;
import leetcode.auxiliary.ListNode;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">141.环形链表</a>
 *
 * <p>给你一个链表的头节点 head，判断链表中是否有环。
 *
 * <ul>
 *   <li>思路一：哈希表
 *       <p>用哈希表存储访问过的节点，如果访问的节点存在于哈希表中则有环，时间复杂度 O(n)，空间复杂度 O(n)。
 *   <li>思路二：快慢指针
 *       <p>Floyd 判圈算法(龟兔赛跑算法)，时间复杂度 O(n)，空间复杂度 O(1)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/14 12:03
 */
public final class Q141LinkedListCycle {
  @SuppressWarnings("unused")
  public static boolean hasCycle1(ListNode head) {
    // 哈希表
    Set<ListNode> seen = new HashSet<>();
    while (head != null) {
      if (!seen.add(head)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  public static boolean hasCycle(ListNode head) {
    // 快慢指针
    ListNode slow = head;
    ListNode fast = head;
    do {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    } while (slow != fast);
    return true;
  }

  public static void main(String[] args) {
    // 案例1
    ListNode head1 = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
    head1.next.next.next.next = head1.next;
    boolean result1 = hasCycle(head1);
    System.out.println(result1);
    AssertUtil.assertTrue(result1);
    // 案例2
    ListNode head2 = new ListNode(1, new ListNode(2));
    head2.next.next = head2;
    boolean result2 = hasCycle(head2);
    System.out.println(result2);
    AssertUtil.assertTrue(result2);
    // 案例3
    ListNode head3 = new ListNode(1);
    boolean result3 = hasCycle(head3);
    System.out.println(result3);
    AssertUtil.assertTrue(!result3);
  }
}
