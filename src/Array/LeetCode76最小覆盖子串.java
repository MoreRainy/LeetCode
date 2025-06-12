package Array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76最小覆盖子串 {
    //    给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
//    注意：
//
//    对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//    如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//    示例 1：=
//    输入：s = "ADOBECODEBANC", t = "ABC"
//    输出："BANC"
//    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
//
//    示例 2：
//    输入：s = "a", t = "a"
//    输出："a"
//    解释：整个字符串 s 是最小覆盖子串。
//
//    示例 3:
//    输入: s = "a", t = "aa"
//    输出: ""
//    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//    因此没有符合条件的子字符串，返回空字符串。
//
//
//    提示：
//
//    m == s.length
//    n == t.length
//    1 <= m, n <= 105
//    s 和 t 由英文字母组成
//
//
//    进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？

    /**
     * 给你一个字符串 s 和一个字符串 t，返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""。
     * 时间复杂度O(m+n) 空间复杂度O(1)
     *
     * @param s 源字符串
     * @param t 目标字符串
     * @return 最小覆盖子串
     */
    public static String minWindow(String s, String t) {
        // 统计目标字符串t中每个字符的出现次数
        Map<Character, Integer> targetCount = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        // 滑动窗口相关变量
        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int resultLeft = -1;
        int resultRight = -1;
        int sLength = s.length();

        // 扩展右边界
        for (int right = 0; right < sLength; right++) {
            char currentChar = s.charAt(right);
            windowCount.put(currentChar, windowCount.getOrDefault(currentChar, 0) + 1);

            // 当窗口满足条件时，尝试收缩左边界
            while (isWindowValid(targetCount, windowCount)) {
                int currentWindowLength = right - left + 1;
                // 更新最小窗口
                if (currentWindowLength < minLength) {
                    minLength = currentWindowLength;
                    resultLeft = left;
                    resultRight = right;
                }

                // 移动左边界
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                left++;
            }
        }

        // 如果没有找到符合条件的子串，返回空字符串
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        // 构建并返回结果字符串
        return s.substring(resultLeft, resultRight + 1);
    }

    /**
     * 检查当前窗口是否满足包含目标字符串所有字符的条件
     *
     * @param targetCount 目标字符串字符计数
     * @param windowCount 当前窗口字符计数
     * @return 如果窗口满足条件返回true，否则返回false
     */
    private static boolean isWindowValid(Map<Character, Integer> targetCount, Map<Character, Integer> windowCount) {
        for (Map.Entry<Character, Integer> entry : targetCount.entrySet()) {
            char key = entry.getKey();
            int requiredCount = entry.getValue();
            int actualCount = windowCount.getOrDefault(key, 0);
            if (actualCount < requiredCount) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t)); // 应输出 "BANC"
    }
}
