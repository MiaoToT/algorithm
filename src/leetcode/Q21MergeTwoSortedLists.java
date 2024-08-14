package leetcode;

import leetcode.auxiliary.ListNode;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21.合并两个有序链表</a>
 *
 * <p>将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <ul>
 *   <li>思路一：迭代
 *       <p>当 l1 和 l2 都不是空链表时，将两个链表中最小值的头节点添加到结果里，以此类推，时间复杂度 O(n+m)，空间复杂度 O(1)。
 *   <li>思路二：递归
 *       <p>Floyd 判圈算法(龟兔赛跑算法)，时间复杂度 O(n+m)，空间复杂度 O(n+m)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/14 12:38
 */
public final class Q21MergeTwoSortedLists {
  public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    // 递归
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    } else if (list1.val < list2.val) {
      list1.next = mergeTwoLists1(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists1(list1, list2.next);
      return list2;
    }
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 迭代
    ListNode result = new ListNode(-1);
    ListNode curr = result;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        curr.next = list1;
        list1 = list1.next;
      } else {
        curr.next = list2;
        list2 = list2.next;
      }
      curr = curr.next;
    }
    curr.next = (list1 == null) ? list2 : list1;
    return result.next;
  }

  public static void main(String[] args) {
    ListNode result1 =
        mergeTwoLists(
            new ListNode(1, new ListNode(2, new ListNode(4))),
            new ListNode(1, new ListNode(3, new ListNode(4))));
    System.out.println(result1);
    assert result1.toString().equals("[1,1,2,3,4,4]");
    ListNode result2 = mergeTwoLists(null, null);
    System.out.println(result2 == null ? "[]" : result2.toString());
    assert result2 == null;
    ListNode result3 = mergeTwoLists(null, new ListNode(0));
    System.out.println(result3);
    assert result3.toString().equals("[0]");
  }
}
