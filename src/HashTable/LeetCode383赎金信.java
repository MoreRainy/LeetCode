package HashTable;

public class LeetCode383赎金信 {
//    给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//    如果可以，返回 true ；否则返回 false 。
//
//    magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
//    示例 1：
//    输入：ransomNote = "a", magazine = "b"
//    输出：false
//
//    示例 2：
//    输入：ransomNote = "aa", magazine = "ab"
//    输出：false
//
//    示例 3：
//    输入：ransomNote = "aa", magazine = "aab"
//    输出：true
//
//
//    提示：
//            1 <= ransomNote.length, magazine.length <= 105
//            ransomNote 和 magazine 由小写英文字母组成

    /**
     * 哈希表
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            charCount[ransomNote.charAt(i) - 'a']++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            charCount[magazine.charAt(i) - 'a']--;
        }

        for (int i : charCount) {
            if (i > 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // 测试用例1: ransomNote = "a", magazine = "b"
        String ransomNote1 = "a";
        String magazine1 = "b";
        boolean result1 = canConstruct(ransomNote1, magazine1);
        System.out.println("Test Case 1: " + result1); // 预期输出: false

        // 测试用例2: ransomNote = "aa", magazine = "ab"
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        boolean result2 = canConstruct(ransomNote2, magazine2);
        System.out.println("Test Case 2: " + result2); // 预期输出: false

        // 测试用例3: ransomNote = "aa", magazine = "aab"
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        boolean result3 = canConstruct(ransomNote3, magazine3);
        System.out.println("Test Case 3: " + result3); // 预期输出: true

        // 测试用例4: 边界情况 - magazine刚好满足ransomNote
        String ransomNote4 = "abc";
        String magazine4 = "abc";
        boolean result4 = canConstruct(ransomNote4, magazine4);
        System.out.println("Test Case 4: " + result4); // 预期输出: true

        // 测试用例5: 边界情况 - magazine字符不足
        String ransomNote5 = "aaaa";
        String magazine5 = "aaa";
        boolean result5 = canConstruct(ransomNote5, magazine5);
        System.out.println("Test Case 5: " + result5); // 预期输出: false
    }
}
