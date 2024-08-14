package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import leetcode.auxiliary.AssertUtil;
import leetcode.auxiliary.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/">19.删除链表的倒数第 N 个结点</a>
 *
 * <p>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * <ul>
 *   <li>思路一：单指针法
 *       <p>遍历一遍计算链表长度，再遍历删除对应结点，时间复杂度 O(L)，空间复杂度 O(1)。
 *   <li>思路二：栈
 *       <p>遍历一遍链表全部入栈，然后弹出第 n 个结点进行删除操作，时间复杂度 O(L)，空间复杂度 O(L)。L 为链表长度
 *   <li>思路三：双指针
 *       <p>快指针先遍历 n 个结点，然后快慢指针一起遍历，最后用满指针删除结点，时间复杂度 O(L)，空间复杂度 O(1)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/14 13:08
 */
public final class Q19RemoveNthNodeFromEndOfList {
  @SuppressWarnings("unused")
  public static ListNode removeNthFromEnd2(ListNode head, int n) {
    // 双指针
    ListNode result = new ListNode(-1, head);
    ListNode slow = result;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return result.next;
  }

  @SuppressWarnings("unused")
  public static ListNode removeNthFromEnd1(ListNode head, int n) {
    // 栈
    ListNode dummy = new ListNode(-1, head);
    Deque<ListNode> stack = new LinkedList<>();
    ListNode cur = dummy;
    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    for (int i = 0; i < n; i++) {
      stack.pop();
    }
    ListNode prev = stack.pop();
    prev.next = prev.next.next;
    return dummy.next;
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    // 单指针法
    int length = 0;
    ListNode lengthHead = head;
    while (lengthHead != null) {
      ++length;
      lengthHead = lengthHead.next;
    }

    // 遍历删除对应结点
    ListNode dummy = new ListNode(-1, head);
    ListNode removeHead = dummy;
    for (int i = 0; i < length - n; i++) {
      removeHead = removeHead.next;
    }
    removeHead.next = removeHead.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    // 案例1
    ListNode head1 =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode result1 = removeNthFromEnd(head1, 2);
    System.out.println(result1);
    AssertUtil.assertTrue("[1,2,3,5]".equals(Objects.toString(result1)));
    // 案例2
    ListNode head2 = new ListNode(1);
    ListNode result2 = removeNthFromEnd(head2, 1);
    System.out.println(result2 == null ? "[]" : Objects.toString(result2));
    AssertUtil.assertTrue(result2 == null);
    // 案例3
    ListNode head3 = new ListNode(1, new ListNode(2));
    ListNode result3 = removeNthFromEnd(head3, 1);
    System.out.println(result3);
    AssertUtil.assertTrue("[1]".equals(Objects.toString(result3)));
  }
}
