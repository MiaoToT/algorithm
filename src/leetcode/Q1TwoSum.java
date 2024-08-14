package leetcode;

import leetcode.auxiliary.AssertUtil;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum/">1.两数之和</a>
 *
 * <p>给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * <ul>
 *   <li>思路一：暴力枚举
 *       <p>双重 for 循环，时间复杂度 O(n<sup>2</sup>)，空间复杂度 O(1)。
 *   <li>思路二：哈希表
 *       <p>用 HashMap 替代一层 for 循环，时间复杂度 O(n)，空间复杂度 O(n)。
 * </ul>
 *
 * @author 喵粮都输光了
 * @since 2024/08/13 16:05
 */
public final class Q1TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    // 思路二：哈希表
    Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; ++i) {
      int calculateValue = target - nums[i];
      // 计算一个值存入map，如果发现另一个target计算出来的在map中，就说明两边加起来就是target，也就得出了答案
      // 这里用 hashMap 代替内层 for 循环查找是否存在另一个值，时间复杂度从O(n)降低至O(1)，但是空间复杂度从O(1)提升至O(n)
      if (hashMap.containsKey(calculateValue)) {
        return new int[] {hashMap.get(calculateValue), i};
      }
      hashMap.put(nums[i], i);
    }
    return new int[0];
  }

  public static void main(String[] args) {
    // 案例1
    int[] nums1 = {2, 7, 11, 15};
    int target1 = 9;
    int[] result1 = twoSum(nums1, target1);
    String resultStr1 = Arrays.toString(result1);
    assert resultStr1.equals("[0, 1]");
    System.out.println(
        MessageFormat.format(
            "nums:{0}, target:{1}, result:{2}", Arrays.toString(nums1), target1, resultStr1));
    // 案例2
    int[] nums2 = new int[] {3, 2, 4};
    int target2 = 6;
    int[] result2 = twoSum(nums2, target2);
    String resultStr2 = Arrays.toString(result2);
    System.out.println(
        MessageFormat.format(
            "nums:{0}, target:{1}, result:{2}", Arrays.toString(nums2), target2, resultStr2));
    AssertUtil.assertTrue("[1, 2]".equals(resultStr2));
    // 案例3
    int[] nums3 = new int[] {3, 3};
    int target3 = 6;
    int[] result3 = twoSum(nums3, target3);
    String resultStr3 = Arrays.toString(result3);
    System.out.println(
        MessageFormat.format(
            "nums:{0}, target:{1}, result:{2}", Arrays.toString(nums3), target3, resultStr3));
    AssertUtil.assertTrue("[0, 1]".equals(resultStr3));
  }
}
