package leetcode;

import java.util.Objects;
import leetcode.auxiliary.AssertUtil;
import leetcode.auxiliary.ListNode;

/**
 * <a href="https://leetcode.cn/problems/middle-of-the-linked-list/">876.链表的中间结点</a>
 *
 * <p>给你单链表的头结点 head ，请你找出并返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 *
 * <ul>
 *   <li>思路一：单指针法
 *       <p>计算链表长度后重新遍历返回第n/2个结点，时间复杂度 O(n)，空间复杂度 O(1)。
 *   <li>思路二：快慢指针法
 *       <p>快指针步长2，慢指针步长1，一起遍历最后返回慢指针对应的结点，时间复杂度 O(n)，空间复杂度 O(1)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/14 16:07
 */
public final class Q876MiddleOfTheLinkedList {
  @SuppressWarnings("unused")
  public static ListNode middleNode1(ListNode head) {
    // 快慢指针法
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static ListNode middleNode(ListNode head) {
    // 单指针法
    int length = 0;
    ListNode lengthHead = head;
    while (lengthHead != null) {
      ++length;
      lengthHead = lengthHead.next;
    }

    // 取中间结点
    for (int i = 0; i < length / 2; i++) {
      head = head.next;
    }
    return head;
  }

  public static void main(String[] args) {
    // 案例1
    ListNode head1 =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result1 = middleNode(head1);
    System.out.println(result1);
    AssertUtil.assertTrue("[3,4,5]".equals(Objects.toString(result1)));
    // 案例2
    ListNode head2 =
        new ListNode(
            1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    ListNode result2 = middleNode(head2);
    System.out.println(result2);
    AssertUtil.assertTrue("[4,5,6]".equals(Objects.toString(result2)));
  }
}
