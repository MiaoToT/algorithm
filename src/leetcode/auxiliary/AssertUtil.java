package leetcode.auxiliary;

/**
 * 断言工具
 *
 * @author 喵粮都输光了
 * @since 2024/08/14 14:19
 */
public final class AssertUtil {
  private AssertUtil() {}

  public static void assertTrue(boolean condition) {
    assertTrue(condition, null);
  }

  /**
   * 如果条件为 True 正常运行，否则抛出异常
   *
   * @param condition 断言条件
   * @param msg 不符合断言抛出的提示
   */
  public static void assertTrue(boolean condition, String msg) {
    if (!condition) {
      throw new AssertionError(msg);
    }
  }
}
