package Recursion;

import java.util.Arrays;

public class LeetCode70爬楼梯 {

    public static void main(String[] args) {
//        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//
//        示例 1：
//        输入：n = 2
//        输出：2
//        解释：有两种方法可以爬到楼顶。
//        1. 1 阶 + 1 阶
//        2. 2 阶
//        int n = 2;
//
//        示例 2：
//        输入：n = 3
//        输出：3
//        解释：有三种方法可以爬到楼顶。
//        1. 1 阶 + 1 阶 + 1 阶
//        2. 1 阶 + 2 阶
//        3. 2 阶 + 1 阶
        int n = 3;
//
//
//        提示：
//
//        1 <= n <= 45
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1; // 到达第0级台阶有1种方法
        dp[1] = 1; // 到达第1级台阶有1种方法

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //return climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}
