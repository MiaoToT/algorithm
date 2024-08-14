package leetcode;

import java.util.Objects;
import leetcode.auxiliary.AssertUtil;
import leetcode.auxiliary.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206.反转链表</a>
 *
 * <p>给你单链表的头节点 head，请你反转链表，并返回反转后的链表。
 *
 * <ul>
 *   <li>思路一：迭代
 *       <p>遍历节点，将每个节点指向其前一个节点，时间复杂度 O(n)，空间复杂度 O(1)。
 *   <li>思路二：递归
 *       <p>递归先遍历到倒数第二个节点，然后修改最后一个节点的指针指向倒数第二个节点，以此类推，时间复杂度 O(n)，空间复杂度 O(n)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/13 16:59
 */
public final class Q206ReverseLinkedList {
  @SuppressWarnings("unused")
  public static ListNode reverseList1(ListNode head) {
    // 递归
    if (head == null || head.next == null) {
      return head;
    }
    // 遍历到倒数第二个节点
    ListNode newHead = reverseList1(head.next);
    // 开始处理结点指向
    head.next.next = head;
    head.next = null;
    // 返回头节点
    return newHead;
  }

  public static ListNode reverseList(ListNode head) {
    // 迭代
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    // 案例1
    ListNode head1 =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result1 = reverseList(head1);
    System.out.println(result1);
    AssertUtil.assertTrue("[5,4,3,2,1]".equals(Objects.toString(result1)));
    // 案例2
    ListNode head2 = new ListNode(1, new ListNode(2));
    ListNode result2 = reverseList(head2);
    System.out.println(result2);
    AssertUtil.assertTrue("[2,1]".equals(Objects.toString(result2)));
  }
}
