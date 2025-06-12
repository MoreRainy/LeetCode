package BinarySearch;

import java.util.Scanner;

public class LeetCode69x的平方根 {
    //    给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
//    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//
//    注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
//
//
//
//    示例 1：
//    输入：x = 4
//    输出：2
//
//    示例 2：
//    输入：x = 8
//    输出：2
//    解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
//
//
//    提示： 0 <= x <= 231 - 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            scanner.nextLine();

            System.out.println(mySqrt(n));
        }
    }

    public static int mySqrt(int x) {
        int front = 0;
        int rear = x;
        int result = -1;

        while (front <= rear) {
            int mid = front + (rear - front) / 2;

            if ((long) mid * mid <= x) {
                result = mid;
                front = mid + 1;
            } else if (mid * mid > x) {
                rear = mid - 1;
            }
        }

        return result;
    }
}
