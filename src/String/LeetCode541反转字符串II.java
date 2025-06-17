package String;

import java.util.Arrays;

public class LeetCode541反转字符串II {
    //    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//    如果剩余字符少于 k 个，则将剩余字符全部反转。
//    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//    示例 1：
//    输入：s = "abcdefg", k = 2
//    输出："bacdfeg"
//
//    示例 2：
//    输入：s = "abcd", k = 2
//    输出："bacd"
//
//
//    提示：
//            1 <= s.length <= 104
//            s 仅由小写英文组成
//            1 <= k <= 104
    public static String reverseStr(String s, int k) {
        final char[] chars = s.toCharArray();
        int len = chars.length;

        for (int i = 0; i < len; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, len - 1);

            while (start < end) {
                chars[start] = (char) (chars[start] ^ chars[end]);
                chars[end] = (char) (chars[start] ^ chars[end]);
                chars[start] = (char) (chars[start] ^ chars[end]);

                start++;
                end--;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        // 测试用例1
        String s1 = "abcdefg";
        int k1 = 2;
        String result1 = reverseStr(s1, k1);
        System.out.println("测试用例1: s = \"" + s1 + "\", k = " + k1);
        System.out.println("输出: \"" + result1 + "\"");
        System.out.println();  // 空行分隔测试用例

        // 测试用例2
        String s2 = "abcd";
        int k2 = 2;
        String result2 = reverseStr(s2, k2);
        System.out.println("测试用例2: s = \"" + s2 + "\", k = " + k2);
        System.out.println("输出: \"" + result2 + "\"");
    }
}
