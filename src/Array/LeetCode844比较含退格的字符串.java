package Array;

public class LeetCode844比较含退格的字符串 {
    //    给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
//
//    注意：如果对空文本输入退格字符，文本继续为空。
//
//
//
//    示例 1：
//    输入：s = "ab#c", t = "ad#c"
//    输出：true
//    解释：s 和 t 都会变成 "ac"。
//
//    示例 2：
//    输入：s = "ab##", t = "c#d#"
//    输出：true
//    解释：s 和 t 都会变成 ""。
//
//    示例 3：
//    输入：s = "a#c", t = "b"
//    输出：false
//    解释：s 会变成 "c"，但 t 仍然是 "b"。
//
//
//    提示：
//
//            1 <= s.length, t.length <= 200
//    s 和 t 只含有小写字母以及字符 '#'
//
//
//    进阶：
//
//    你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String s, String t) {
        // 构造最终的字符串
        String finalS = buildString(s);
        String finalT = buildString(t);

        // 比较最终字符串是否相等
        return finalS.equals(finalT);
    }

    private static String buildString(String str) {
        StringBuilder result = new StringBuilder();
        int skip = 0; // 用于记录需要跳过的字符数量

        // 从后往前遍历字符串
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') {
                skip++; // 遇到 '#'，增加跳过计数
            } else if (skip > 0) {
                skip--; // 如果当前字符不是 '#'，且需要跳过，则减少跳过计数
            } else {
                result.append(str.charAt(i)); // 将当前字符加入结果字符串
            }
        }

        // 由于是从后往前构建的，需要反转结果字符串
        return result.reverse().toString();
    }
}
