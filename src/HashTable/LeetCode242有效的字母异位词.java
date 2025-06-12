package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetCode242有效的字母异位词 {
    //    给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//
//
//    示例 1:
//    输入: s = "anagram", t = "nagaram"
//    输出: true
//
//    示例 2:
//    输入: s = "rat", t = "car"
//    输出: false
//
//
//    提示:
//            1 <= s.length, t.length <= 5 * 104
//    s 和 t 仅包含小写字母
//
//
//    进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// 假设的解决方案方法：使用排序判断是否是字母异位词

    /**
     * 数组排序
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        // 如果长度不同，直接返回false
        if (s.length() != t.length()) {
            return false;
        }
        // 将字符串转换为字符数组并排序
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        // 比较排序后的字符数组
        return Arrays.equals(sArray, tArray);
    }

    /**
     * 哈希表-map
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        final Set<Character> keySetS = mapS.keySet();
        final Set<Character> keySetT = mapT.keySet();

        if (!keySetT.equals(keySetS)) return false;

        for (Character character : keySetT) {
            if (!mapS.get(character).equals(mapT.get(character))) return false;
        }

        return true;
    }

    /**
     * 哈希表-数组
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }

        for (int i : hash) {
            if (i != 0) return false;
        }

        return true;
    }

    // 测试方法
    public static void main(String[] args) {
        // 测试用例数组，每个测试用例包含s, t, 预期结果
        Object[][] testCases = {
                {"anagram", "nagaram", true},    // 示例1
                {"rat", "car", false},           // 示例2
                {"a", "a", true},                // 相同字符
                {"a", "b", false},               // 不同字符
                {"abc", "cba", true},            // 排列不同但字母相同
                {"abcd", "dcba", true},          // 排列不同但字母相同
                {"listen", "silent", true},      // 另一个例子
                {"hello", "billion", false},     // 不同长度
                {"", "", true},                  // 空字符串
                {"aabbcc", "abcabc", true},      // 重复字母
                {"aabbcc", "aabbc", false}       // 长度不同
        };

        // 遍历所有测试用例并验证
        for (Object[] testCase : testCases) {
            String s = (String) testCase[0];
            String t = (String) testCase[1];
            boolean expected = (boolean) testCase[2];
            boolean result = isAnagram(s, t);
            if (result == expected) {
                System.out.printf("测试通过: s=\"%s\", t=\"%s\", 预期=%b, 结果=%b%n",
                        s, t, expected, result);
            } else {
                System.out.printf("测试失败: s=\"%s\", t=\"%s\", 预期=%b, 结果=%b%n",
                        s, t, expected, result);
            }
        }
    }
}