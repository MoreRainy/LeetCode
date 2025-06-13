package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode202快乐数 {
    //    编写一个算法来判断一个数 n 是不是快乐数。
//
//            「快乐数」 定义为：
//
//    对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//    然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//    如果这个过程 结果为 1，那么这个数就是快乐数。
//    如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//
//
//
//    示例 1：
//    输入：n = 19
//    输出：true
//    解释：
//            12 + 92 = 82
//            82 + 22 = 68
//            62 + 82 = 100
//            12 + 02 + 02 = 1
//
//    示例 2：
//    输入：n = 2
//    输出：false
//
//
//    提示：
//
//            1 <= n <= 231 - 1

    /**
     * 哈希表
     *
     * @param n
     * @return
     */
    public static boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sum = 0;
            // 计算各位数字的平方和
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }

        // 如果最终 n 变为 1，则是快乐数
        return n == 1;
    }

    /**
     * 双指针
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    /**
     * 得到下一组数据
     *
     * @param num
     * @return
     */
    public static int getNext(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10) * (num % 10);
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] testCases = {19, 2, 1, 7, 4};

        for (int n : testCases) {
            boolean result = isHappy(n);
            System.out.println("输入: n = " + n + " 输出: " + result);//期望输出 true false true true false
        }
    }
}
