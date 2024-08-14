package leetcode.auxiliary;

/**
 * 链表节点
 *
 * @author 喵粮都输光了
 * @since 2024/08/13 17:00
 */
public final class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
    this(0, null);
  }

  public ListNode(int val) {
    this(val, null);
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    ListNode curr = this;
    StringBuilder sb = new StringBuilder();
    sb.append("[").append(curr.val);
    while (curr.next != null) {
      curr = curr.next;
      sb.append(",").append(curr.val);
    }
    return sb.append("]").toString();
  }
}
