package String;

public class LeetCode344反转字符串 {
    //    编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//
//
//    示例 1：
//    输入：s = ["h","e","l","l","o"]
//    输出：["o","l","l","e","h"]
//
//    示例 2：
//    输入：s = ["H","a","n","n","a","h"]
//    输出：["h","a","n","n","a","H"]
//
//
//    提示：
//
//            1 <= s.length <= 105
//            s[i] 都是 ASCII 码表中的可打印字符

    /**
     * 直接交换
     *
     * @param s
     */
    public static void reverseString1(char[] s) {
        int len = s.length;

        for (int i = 0; i < len / 2; i++) {
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }

    /**
     * 位运算交换
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // 使用异或运算交换 s[left] 和 s[right]
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // 测试用例1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println("测试用例1: " + arrayToString(s1)); // 预期输出: ["o","l","l","e","h"]

        // 测试用例2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println("测试用例2: " + arrayToString(s2)); // 预期输出: ["h","a","n","n","a","H"]

        // 可以添加更多测试用例
        // 测试用例3: 单个字符
        char[] s3 = {'A'};
        reverseString(s3);
        System.out.println("测试用例3: " + arrayToString(s3)); // 预期输出: ["A"]

        // 测试用例4: 空数组(根据题目提示，s.length >=1，所以这个测试用例可能不需要)
        // char[] s4 = {};
        // reverseString(s4);
        // System.out.println("测试用例4: " + arrayToString(s4));
    }

    // 辅助方法，将字符数组转换为字符串表示形式
    public static String arrayToString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("\"").append(arr[i]).append("\"");
            if (i != arr.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
