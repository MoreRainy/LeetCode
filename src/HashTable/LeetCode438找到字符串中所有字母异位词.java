package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438找到字符串中所有字母异位词 {
    //    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//
//
//    示例 1:
//    输入: s = "cbaebabacd", p = "abc"
//    输出: [0,6]
//    解释:
//    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//
//    示例 2:
//    输入: s = "abab", p = "ab"
//    输出: [0,1,2]
//    解释:
//    起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//    起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//    起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//
//
//    提示:
//
//            1 <= s.length, p.length <= 3 * 104
//            s 和 p 仅包含小写字母

    /**
     * 排序算法
     * 超时！！！
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        //子串必须比原串小
        if (p.length() > s.length()) return new ArrayList<>(0);

        int len = p.length();
        List<Integer> list = new ArrayList<>();

        //初始化窗口
        String str = s.substring(0, len);
        char[] window = str.toCharArray();

        //排序初始化子串
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);

        for (int i = 0; i < s.length() - len + 1; i++) {
            window[(i + len - 1) % len] = s.charAt(i + len - 1);
            System.out.println("win: " + Arrays.toString(window));

            if (compare(window, pArray)) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 排序算法辅助比较函数
     * @param win
     * @param b
     * @return
     */
    public static boolean compare(char[] win, char[] b) {
        char[] a = new char[win.length];
        System.arraycopy(win, 0, a, 0, win.length);

        Arrays.sort(a);
        final String strA = Arrays.toString(a);
        Arrays.sort(b);
        final String strB = Arrays.toString(b);

        return strA.equals(strB);
    }

    /**
     * 滑动窗口
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];  // 统计 p 的字符频率
        int[] sCount = new int[26];  // 统计当前窗口的字符频率
        int pLen = p.length();
        int sLen = s.length();

        // 初始化 p 的频率统计
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化第一个窗口的频率统计
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // 如果第一个窗口就是异位词，加入结果
        if (matches(pCount, sCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            // 移除左边界的字符
            sCount[s.charAt(i - pLen) - 'a']--;
            // 添加右边界的字符
            sCount[s.charAt(i) - 'a']++;

            // 检查是否匹配
            if (matches(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    /**
     * 比较两个频率数组是否相同
     * @param pCount
     * @param sCount
     * @return
     */
    private static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        // Test case 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        List<Integer> expected1 = Arrays.asList(0, 6);
        List<Integer> result1 = findAnagrams(s1, p1);
        System.out.println(result1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2
        String s2 = "abab";
        String p2 = "ab";
        List<Integer> expected2 = Arrays.asList(0, 1, 2);
        List<Integer> result2 = findAnagrams(s2, p2);
        System.out.println(result2);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3
        String s3 = "aaabb";
        String p3 = "bb";
        List<Integer> expected3 = Arrays.asList(3);
        List<Integer> result3 = findAnagrams(s3, p3);
        System.out.println(result3);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));

        // Test case 4
        String s4 = "baa";
        String p4 = "aa";
        List<Integer> expected4 = Arrays.asList(1);
        List<Integer> result4 = findAnagrams(s4, p4);
        System.out.println(result4);
        System.out.println("Test case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));
    }
}
